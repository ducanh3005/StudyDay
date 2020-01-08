package com.darly.chinese.soload;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.darly.chinese.R;
import com.darly.chinese.fileload.ExternalStorageUtil;
import com.darly.dlcommon.common.StringUtil;
import com.darly.dlcommon.framework.ContextController;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * author:zhangyuhui
 * date:2020-01-0716:33
 * description: SO 动态加载工具类
 */
public class SoLoadController {

    /**
     * 提示信息
     */
    public String type = ContextController.getInstance().getApplication().getResources().getString(R.string.type_so);

    private static final String TARGET_LIBS_NAME = "libs";

    String[] abis = new String[]{};

    private WeakReference<Context> weakReference;

    private SoLoadController() {

    }

    static class SoLoadControllerHolder {
        static SoLoadController controller = new SoLoadController();
    }

    public static SoLoadController getInstance() {
        return SoLoadControllerHolder.controller;
    }

    public void init(Context context) {
        weakReference = new WeakReference<>(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            abis = Build.SUPPORTED_ABIS;
        } else {
            abis = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }
    }


    /**
     * 加载so文件
     */
    public void loadSo(OnSoLoadListener loadListener) {
        loadListener.onSoStart(type);
        File dir = weakReference.get().getDir(TARGET_LIBS_NAME, Context.MODE_PRIVATE);
        File[] currentFiles;
        currentFiles = dir.listFiles();
        loadListener.onSoComplete(type, currentFiles);
    }


    /**
     * 复制SO文件
     *
     * @param isCover true覆盖原文件即删除原有文件后拷贝新的文件进来
     */
    public void copySo(boolean isCover, OnSoLoadListener listener) {
        if (weakReference == null) {
            return;
        }
        listener.onSoStart(type);
        try {
            copySo("", isCover);
            loadSo(listener);
        } catch (Exception e) {
            e.printStackTrace();
            listener.onSoFailed(type, "SO库复制失败");
        }
    }



    /**
     * 复制到data文件夹中
     */
    private void copySo(String path, boolean isCover) throws Exception {
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
            File targetDir = weakReference.get().getDir(TARGET_LIBS_NAME, Context.MODE_PRIVATE);
            //创建目录
            if (!targetDir.exists()) {
                targetDir.mkdirs();
            } else {
                //删除全部老文件
                if (isCover) {
                    ExternalStorageUtil.delete(targetDir);
                }
            }
            if (abis!=null&&abis.length>0){
                if (file.getAbsolutePath().contains(abis[0])&&!file.getName().startsWith("._")) {
                    //._这是Unix系统解压时产生的多余数据。需要进行隔离
                    copySdcardFile(file.getPath(), targetDir + File.separator + file.getName());
                }
            }else {
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
            FileInputStream fosfrom = new FileInputStream(fromFile);
            FileOutputStream fosto = new FileOutputStream(toFile);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = fosfrom.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            // 从内存到写入到具体文件
            fosto.write(baos.toByteArray());
            // 关闭文件流
            baos.close();
            fosto.close();
            fosfrom.close();
        } catch (Exception ex) {
            return;
        }
    }
}
