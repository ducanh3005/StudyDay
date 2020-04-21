package com.darly.std.boot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.darly.std.GuideActivity;

/**
 * author:zhangyuhui
 * date:2020-04-2118:29
 * description: 基础拦截系统启动广播，
 */
public class BootBroadcastReceiver extends BroadcastReceiver {
    static final String action_boot="android.intent.action.BOOT_COMPLETED";
    @Override
    public void onReceive(Context context, Intent intent) {
        //接收到系统启动完成广播直接打开自身应用。
        if (intent.getAction().equals(action_boot)){
            Intent ootStartIntent=new Intent(context, GuideActivity.class);
            ootStartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(ootStartIntent);
        }
    }
}
