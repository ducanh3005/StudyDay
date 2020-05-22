package com.darly.chinese.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.darly.chinese.common.SpController;
import com.darly.dlcommon.common.dlog.DLog;
import com.darly.dlcommon.common.net.NetUtil;

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
            SpController.getInstance().putValue(NetUtil.SYSTEM_IP, NetUtil.getIPAddress(context));
        }

    }
}
