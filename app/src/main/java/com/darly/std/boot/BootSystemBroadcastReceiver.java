package com.darly.std.boot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.darly.chinese.common.LogController;
import com.darly.std.GuideActivity;

/**
 * author:zhangyuhui
 * date:2020-04-2118:29
 * description: 基础拦截系统启动广播，
 */
public class BootSystemBroadcastReceiver extends BroadcastReceiver {
    /**
     * 第一种：  监控RECEIVE_BOOT_COMPLETED，即开机启动事件
     */
    private String action_boot="android.intent.action.BOOT_COMPLETED";
    /**
     * 第二种： 监控sd卡mount事件  开机总会扫描sd卡吧？ 监控sd卡事件也有类似开机启动效果。特别app安装在sd卡的情况下有些os是抓取不到RECEIVE_BOOT_COMPLETED
     */
    private String action_event="RestartSerivcesForSystemEventReceiver";
    private String action_mount="android.intent.action.MEDIA_MOUNTED";
    private String action_unmount="android.intent.action.MEDIA_UNMOUNTED";
    private String action_media="android.intent.action.MEDIA_EJECT";
    //第三种： android:installLocation="internalOnly"， 限制app的安装位置，使其能抓取到RECEIVE_BOOT_COMPLETED
    //第四种： 监听电话或者短信事件。手机总得打电话收发短信吧？ 万一实在不行。退而求其次。这样的方式还是可行的

    @Override
    public void onReceive(Context context, Intent intent) {
        //接收到系统启动完成广播直接打开自身应用。
        LogController.d("BootSystemBroadcastReceiver",intent.getAction()+"接收到系统启动完成广播直接打开自身应用");
        if (intent.getAction().equals(action_boot)||intent.getAction().equals(action_event)||intent.getAction().equals(action_mount)||intent.getAction().equals(action_unmount)||intent.getAction().equals(action_media)){
            Intent ootStartIntent=new Intent(context, GuideActivity.class);
            ootStartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(ootStartIntent);
        }
    }
}
