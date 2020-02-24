package com.darly.chinese.controller.fileload;


import com.darly.chinese.R;
import com.darly.chinese.base.BaseController;
import com.darly.chinese.base.ControllerEnum;
import com.darly.chinese.controller.OnControllerBackListener;
import com.darly.dlcommon.common.bolts.tasks.Task;
import com.darly.dlcommon.common.bolts.tasks.iface.Continuation;
import com.darly.dlcommon.framework.ContextController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * author:zhangyuhui
 * date:2020-01-0709:32
 * description: 下载文件、本地文件处理控制类
 */
public class FileController extends BaseController {


    private FileController() {
    }

    @Override
    public ControllerEnum getType() {
        return ControllerEnum.FILELOAD;
    }

    static class FileControllerHolder {
        static FileController controller = new FileController();
    }

    public static FileController getInstance() {
        return FileControllerHolder.controller;
    }

    /**
     * 目标路径下载对应文件
     */
    public void downFile() {

    }

    /**
     * 从assets中复制文件
     */
    public void copyFile(final String assetsFile, final OnControllerBackListener listener) {
        listener.onStart(ContextController.getInstance().getApplication().getResources().getString(R.string.type_file));
        Task.call(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                try {
                    if (ExternalStorageUtil.isExternalStorageReadable() && ExternalStorageUtil.isExternalStorageWritable()) {
                        //将文件复制到SD卡中
                        ExternalStorageUtil.creatFile(ExternalStorageUtil.GOODS_DETAIL_PATH);
                        copyAssetsFiles(assetsFile, ExternalStorageUtil.GOODS_DETAIL_PATH);
                        File file = new File(ExternalStorageUtil.getExternalStoragePath() + ExternalStorageUtil.GOODS_DETAIL_PATH);
                        File[] files = file.listFiles();
                        List<String> tagFiles = new ArrayList<>();
                        for (File tagCompress : files) {
                            if (tagCompress.getName().endsWith(".rar") || tagCompress.getName().endsWith(".zip")) {
                                tagFiles.add(tagCompress.getAbsolutePath());
                            }
                        }
                        return tagFiles;
                    } else {
                        return null;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }

            }
        }, Task.BACKGROUND_EXECUTOR).continueWith(new Continuation<List<String>, Void>() {
            @Override
            public Void then(Task<List<String>> task) throws Exception {
                if (task.getResult() != null) {
                    listener.onComplete(ContextController.getInstance().getApplication().getResources().getString(R.string.type_file_suc), ControllerEnum.FILELOAD, task.getResult());
                } else {
                    listener.onFailed(ContextController.getInstance().getApplication().getResources().getString(R.string.type_file_fail), ControllerEnum.FILELOAD, task.getError().getMessage());
                }
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /**
     * 复制assets目录下所有文件及文件夹到指定路径
     *
     * @param mAssetsPath Assets目录的相对路径(DownLoad)
     * @param mSavePath   复制文件的保存路径
     * @return void
     */
    private void copyAssetsFiles(String mAssetsPath, String mSavePath) throws Exception {
        String[] fileNames = ContextController.getInstance().getApplication().getResources().getAssets().list(mAssetsPath);
        if (fileNames.length > 0) {
            // 若是目录
            for (String fileName : fileNames) {
                String newAssetsPath = "";
                // 确保Assets路径后面没有斜杠分隔符，否则将获取不到值
                if ((mAssetsPath == null) || "".equals(mAssetsPath) || "/".equals(mAssetsPath)) {
                    newAssetsPath = fileName;
                } else {
                    if (mAssetsPath.endsWith("/")) {
                        newAssetsPath = mAssetsPath + fileName;
                    } else {
                        newAssetsPath = mAssetsPath + "/" + fileName;
                    }
                }
                // 递归调用
                copyAssetsFiles(newAssetsPath, mSavePath + "/" + fileName);
            }
        } else {
            // 若是文件
            File file = new File(ExternalStorageUtil.getExternalStoragePath() + mSavePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            InputStream is = ContextController.getInstance().getApplication().getResources().getAssets().open(mAssetsPath);
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int byteCount = 0;
            // 循环从输入流读取字节
            while ((byteCount = is.read(buffer)) != -1) {
                // 将读取的输入流写入到输出流
                fos.write(buffer, 0, byteCount);
            }
            // 刷新缓冲区
            fos.flush();
            fos.close();
            is.close();
        }
    }
}
