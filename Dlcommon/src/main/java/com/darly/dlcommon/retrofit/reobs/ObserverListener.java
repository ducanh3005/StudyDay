package com.darly.dlcommon.retrofit.reobs;



/**
 * 观察者接口，实现此接口者，皆调用接口里面的方法。
 * @author Darly/张宇辉/2017/11/23 14:18
 * @version 1.0/com.darly.common
 */
public interface ObserverListener {

    void initRetrofit(Class<? extends RxNotification> cls);

    void notifUI();
}