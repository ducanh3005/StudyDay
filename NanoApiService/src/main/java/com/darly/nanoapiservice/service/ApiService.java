package com.darly.nanoapiservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;


import com.darly.nanoapiservice.BuildConfig;
import com.darly.nanoapiservice.base.ApiCons;
import com.darly.nanoapiservice.base.BaseServiceModel;
import com.darly.nanoapiservice.base.ServiceStartEntry;

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
        // 创建对象，端口我这里设置为55550
        Log.d(getClass().getSimpleName(),"[ApiService 启动中...]");
        BaseServiceModel start = ServiceStartEntry.initService();
        if (start.getCode() == ApiCons.SUCCESS) {
            //当服务初始化完成后，启动服务。
            Log.d(getClass().getSimpleName(),"[ApiService 打开端口：]"+ BuildConfig.PORT);
            HttpService myServer = new HttpService(BuildConfig.PORT);
            try {
                // 开启HTTP服务
                myServer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "服务初始化失败！", Toast.LENGTH_SHORT);
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
