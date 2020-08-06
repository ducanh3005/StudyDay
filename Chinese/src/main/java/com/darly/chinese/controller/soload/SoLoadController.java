package com.darly.chinese.controller.soload;

import android.content.Context;
import android.os.Build;

import com.darly.chinese.R;
import com.darly.chinese.base.BaseController;
import com.darly.chinese.base.ControllerEnum;
import com.darly.chinese.controller.OnControllerBackListener;
import com.darly.chinese.controller.fileload.ExternalStorageUtil;
import com.darly.dlcommon.framework.ContextController;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;

/**
 * author:zhangyuhui
 * date:2020-01-0716:33
 * description: SO 动态加载工具类
 */
public class SoLoadController extends BaseController {

    private static final String TARGET_LIBS_NAME = "libs";

    private String[] abi = new String[]{};


    private SoLoadController() {
        init();
    }

    @Override
    public ControllerEnum getType() {
        return ControllerEnum.SOLOAD;
    }

    static class SoLoadControllerHolder {
        static SoLoadController controller = new SoLoadController();
    }

    public static SoLoadController getInstance() {
        return SoLoadControllerHolder.controller;
    }

    private void init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            abi = Build.SUPPORTED_ABIS;
        } else {
            abi = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }
    }


    /**
     * 加载so文件
     */
    public void loadSo(OnControllerBackListener loadListener) {
        loadListener.onStart(ContextController.getInstance().getApplication().getResources().getString(R.string.type_so));
        File dir = ContextController.getInstance().getApplication().getDir(TARGET_LIBS_NAME, Context.MODE_PRIVATE);
        File[] currentFiles;
        currentFiles = dir.listFiles();
        //这个是data/data路径，直接反射到内部路径。直接使用System.loadLibrary()方法导入SO包
        installSoDir();
        loadListener.onComplete(ContextController.getInstance().getApplication().getResources().getString(R.string.type_so_suc), ControllerEnum.SOLOAD, currentFiles);
    }


    /**
     * 复制SO文件
     *
     * @param isCover true覆盖原文件即删除原有文件后拷贝新的文件进来
     */
    public void copySo(boolean isCover, OnControllerBackListener listener) {
        listener.onStart(ContextController.getInstance().getApplication().getResources().getString(R.string.type_so));
        try {
            //调用复制so到data目录方法
            copySo("", isCover);
            //将So导入系统中
            loadSo(listener);
        } catch (Exception e) {
            e.printStackTrace();
            listener.onFailed(ContextController.getInstance().getApplication().getResources().getString(R.string.type_so_fail), ControllerEnum.SOLOAD, "SO库复制失败");
        }
    }


    /**
     * 复制到data文件夹中
     */
    private void copySo(String path, boolean isCover) {
        File file = new File(ExternalStorageUtil.getDownLoadPath() + File.separator + path);
        if (file.isDirectory()) {
            //文件夹
            File[] clones = file.listFiles();
            for (File clone : clones) {
                copySo(path + File.separator + clone.getName(), isCover);
            }
        } else {
            // 若是文件
            //目标目录
            File targetDir = ContextController.getInstance().getApplication().getDir(TARGET_LIBS_NAME, Context.MODE_PRIVATE);
            //创建目录
            if (!targetDir.exists()) {
                targetDir.mkdirs();
            } else {
                //删除全部老文件
                if (isCover) {
                    ExternalStorageUtil.delete(targetDir);
                }
            }
            if (abi != null && abi.length > 0) {
                if (file.getAbsolutePath().contains(abi[0]) && !file.getName().startsWith("._")) {
                    //._这是Unix系统解压时产生的多余数据。需要进行隔离
                    copySdcardFile(file.getPath(), targetDir + File.separator + file.getName());
                }
            } else {
                return;
            }
        }
    }


    /**
     * 文件拷贝(要复制的目录下的所有非文件夹的文件拷贝)
     *
     * @param fromFile
     * @param toFile
     */
    private void copySdcardFile(String fromFile, String toFile) {
        try {
            FileInputStream fis = new FileInputStream(fromFile);
            FileOutputStream fos = new FileOutputStream(toFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            // 从内存到写入到具体文件
            fos.write(bos.toByteArray());
            // 关闭文件流
            bos.close();
            fos.close();
            fis.close();
        } catch (Exception ex) {
            return;
        }
    }


    /**
     * 将so所在的目录放入PathClassLoader里的nativeLibraryDirectories中
     * 反射将so放到加载对应路径中。
     * 主要任务是将SO库加载的内部路径更新
     */
    public void installSoDir() {
        File soDirFile = ContextController.getInstance().getApplication().getDir(TARGET_LIBS_NAME, Context.MODE_PRIVATE);
        if (!soDirFile.exists()) {
            soDirFile.mkdirs();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //这里是6.0以上版本
            v23Install(soDirFile, ContextController.getInstance().getApplication());
        } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            belowLevel14(soDirFile, ContextController.getInstance().getApplication()); // 4.0以下系统
        } else {
            //4.0以上6.0以下
            v14Install(soDirFile, ContextController.getInstance().getApplication());
        }
    }

    /**
     * 4.0以上6.0以下版本的手机进入该方法。保存路径
     *
     * @param soDirFile 新增的路径
     * @param context   引用
     */
    private void v14Install(File soDirFile, Context context) {
        PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
        Object pathList = getPathList(pathClassLoader);
        if (pathList != null) {
            //获取当前类的属性
            try {
                Field nativeLibraryDirectoriesField = pathList.getClass().getDeclaredField("nativeLibraryDirectories");
                nativeLibraryDirectoriesField.setAccessible(true);
                // 获取 DEXPATHList中的属性值
                File[] files = (File[]) nativeLibraryDirectoriesField.get(pathList);

                Object newFiles = Array.newInstance(File.class, files.length + 1);

                // 添加自定义.so路径
                Array.set(newFiles, 0, soDirFile);

                // 将系统自己的追加上
                for (int i = 1; i < files.length + 1; i++) {
                    Array.set(newFiles, i, files[i - 1]);
                }
                nativeLibraryDirectoriesField.set(pathList, newFiles);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 6.0以上版本的手机进入该方法。保存路径
     *
     * @param soDirFile 新增的路径
     * @param context   引用
     */
    private void v23Install(File soDirFile, Context context) {
        PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
        Object pathList = getPathList(pathClassLoader);
        if (pathList != null) {
            //获取当前类的属性
            try {
                Class<?> elementClass = Class.forName("dalvik.system.DexPathList$NativeLibraryElement");
                Constructor<?> constructor = elementClass.getConstructor(File.class, boolean.class, File.class, DexFile.class);
                constructor.setAccessible(true);

                Object nativeLibraryPathElements = pathList.getClass().getDeclaredField("nativeLibraryPathElements");
                ((Field) nativeLibraryPathElements).setAccessible(true);
                // 获取 DEXPATHList中的属性值
                Object[] elementFiles = (Object[]) ((Field) nativeLibraryPathElements).get(pathList);

                Object newElementFiles = Array.newInstance(elementClass, elementFiles.length + 1);

                Object element = constructor.newInstance(soDirFile, true, null, null);

                if (element != null) {
                    Array.set(newElementFiles, 0, element);
                    for (int i = 1; i < elementFiles.length + 1; i++) {
                        Array.set(newElementFiles, i, elementFiles[i - 1]);
                    }
                    ((Field) nativeLibraryPathElements).set(pathList, newElementFiles);
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private Object getPathList(Object classLoader) {
        String pathListName = "pathList";
        try {
            Class cls = Class.forName("dalvik.system.BaseDexClassLoader");
            Field declaredField = cls.getDeclaredField(pathListName);
            declaredField.setAccessible(true);
            return declaredField.get(classLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 4.0以下版本的手机进入该方法。保存路径
     *
     * @param soDirFile 新增的路径
     * @param context   引用
     */
    private void belowLevel14(File soDirFile, Context context) {
        try {
            PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
            Field mLibPaths = pathClassLoader.getClass().getDeclaredField("mLibPaths");
            mLibPaths.setAccessible(true);
            String[] libs = (String[]) (mLibPaths).get(pathClassLoader);
            Object newPaths = Array.newInstance(String.class, libs.length + 1);
            // 添加自定义.so路径
            Array.set(newPaths, 0, soDirFile.getAbsolutePath());
            // 将系统自己的追加上
            for (int i = 1; i < libs.length + 1; i++) {
                Array.set(newPaths, i, libs[i - 1]);
            }
            mLibPaths.set(pathClassLoader, newPaths);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
