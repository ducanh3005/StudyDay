package com.darly.api.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.darly.chinese.common.SpController;
import com.darly.dlcommon.common.StringUtil;
import com.darly.dlcommon.common.dlog.DLog;
import com.darly.dlcommon.common.net.NetUtil;
import com.darly.dlcommon.retrofit.RxjavaRetrofitRequestUtil;
import com.darly.rnmodule.module.NoticeReactNativeModule;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

/**
 * author:zhangyuhui
 * date:2020-05-2211:22
 * description: 通过广播获取当前网络修改状态
 */
public class NetStateChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            DLog.d("[NetStateChangeReceiver IP发生变化]");
            String localIp = NetUtil.getIPAddress(context);
            if (!StringUtil.isEmpty(localIp)) {
                SpController.getInstance().putValue(NetUtil.SYSTEM_IP, localIp);
                String url = "http://"+ localIp+":8089";
                RxjavaRetrofitRequestUtil.setBaseUrl(url);
                WritableMap ip = Arguments.createMap();
                ip.putString(NetUtil.SYSTEM_IP, localIp);
                NoticeReactNativeModule.sendEvent(NetUtil.SYSTEM_IP, ip);
            }
        }

    }
}
