package com.darly.chinese.decompression;

import com.darly.chinese.R;
import com.darly.chinese.parse.OnParseJsonListener;
import com.darly.dlcommon.common.bolts.tasks.Task;
import com.darly.dlcommon.common.bolts.tasks.iface.Continuation;
import com.darly.dlcommon.framework.ContextController;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * author:zhangyuhui
 * date:2020-01-0614:15
 * description: 解压工具类，这里使用工具进行网络下载的压缩包进行解压到目标文件内。进行后续处理
 */
public class DecompressionController {

    /**
     * 提示信息
     */
    public String type = ContextController.getInstance().getApplication().getResources().getString(R.string.type_decompress);

    private DecompressionController() {
    }

    static class DecompressionControllerHolder {
        static DecompressionController controller = new DecompressionController();
    }

    public static DecompressionController getInstance() {
        return DecompressionControllerHolder.controller;
    }

    /**
     * 进行压缩包解压，获取对应文件
     *
     * @param zipFile  压缩包
     * @param tagDec   解压路径
     * @param listener 回调
     */
    public void decompressionInit(final String zipFile, final String tagDec, final OnParseJsonListener listener) {
        listener.onStart(type);
        Task.call(new Callable<List<File>>() {
            @Override
            public List<File> call() throws Exception {
                List<File> files = ZipDecompressionCommon.unzipFile(zipFile, tagDec);
                listener.onProgress(100);
                return files;
            }
        }, Task.BACKGROUND_EXECUTOR).continueWith(new Continuation<List<File>, Void>() {
            @Override
            public Void then(Task<List<File>> task) throws Exception {
                if (task.getResult() != null) {
                    listener.onComplete(type, task.getResult());
                } else {
                    listener.onFailed(type, task.getError().getMessage());
                }
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

}

