package com.darly.rnmodule.obs;

import com.darly.dlcommon.retrofit.reobs.ObserverListener;
import com.darly.dlcommon.retrofit.reobs.RxNotification;

/**
 * 對封裝后的工具使用Image進行初始化。
 * @author Darly/张宇辉/2017/11/23 14:18
 * @version 1.0/com.darly.common
 */
public class InitCfg implements ObserverListener {

    private static InitCfg instance = null;

    private Class<? extends RxNotification> cls;

    private InitCfg() {
    }

    public static InitCfg getInstance() {
        if(instance == null) {
            instance = new InitCfg();
        }
        return instance;
    }

    @Override
    public void initRetrofit(Class<? extends RxNotification> cls) {
        this.cls = cls;
    }

    @Override
    public void notifUI() {

    }


    public Class<? extends RxNotification> getCls() {
        return cls;
    }
}