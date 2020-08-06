package com.darly.dlcommon.retrofit.reobs;


/**
 * 設計者，將觀察者集中註冊到這裡。
 *
 * @author Darly/张宇辉/2017/11/23 14:18
 * @version 1.0/com.darly.common
 */
public interface DesignListener {

    void addObserver(ObserverListener ob);

    void delObserver(ObserverListener ob);

    void initRetrofit(Class<? extends RxNotification> cls);

    void notifUI();
}