package com.darly.api.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.darly.api.base.ApiCons;
import com.darly.api.base.BaseServiceModel;
import com.darly.api.base.ServiceStartEntry;
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
        // 创建对象，端口我这里设置为55550
        DLog.d("[ApiService 启动中...]");
        BaseServiceModel start = ServiceStartEntry.initService();
        if (start.getCode() == ApiCons.SUCCESS) {
            //当服务初始化完成后，启动服务。
            HttpService myServer = new HttpService(55550);
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
