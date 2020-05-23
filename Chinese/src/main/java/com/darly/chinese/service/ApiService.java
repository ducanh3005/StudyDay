package com.darly.chinese.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.darly.dlcommon.common.dlog.DLog;

import java.io.IOException;

/**
 * author:zhangyuhui
 * date:2020-05-2209:49
 * description: 启动一个Service，然后通过API进行调用。
 */
public class ApiService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 创建对象，端口我这里设置为8080
        DLog.d("[ApiService 启动中...]");
        MethodName.setMethodsMap();//初始化接口对象集合。
        HttpService myServer = new HttpService(8089);
        try {
            // 开启HTTP服务
            myServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
