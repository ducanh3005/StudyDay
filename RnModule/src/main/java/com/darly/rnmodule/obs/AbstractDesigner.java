package com.darly.rnmodule.obs;


import com.darly.dlcommon.retrofit.reobs.DesignListener;
import com.darly.dlcommon.retrofit.reobs.ObserverListener;
import com.darly.dlcommon.retrofit.reobs.RxNotification;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 调用方法类。
 * @author Darly/张宇辉/2017/11/23 14:18
 * @version 1.0/com.darly.common
 */
public class AbstractDesigner implements DesignListener {
    private Vector<ObserverListener> vector = new Vector();

    public AbstractDesigner() {
    }

    @Override
    public void addObserver(ObserverListener ob) {
        this.vector.add(ob);
    }

    @Override
    public void delObserver(ObserverListener ob) {
        this.vector.remove(ob);
    }

    @Override
    public void initRetrofit(Class<? extends RxNotification> cls) {
        Enumeration enumd = this.vector.elements();
        while(enumd.hasMoreElements()) {
            ObserverListener observerListener = (ObserverListener)enumd.nextElement();
            observerListener.initRetrofit(cls);
        }
    }

    @Override
    public void notifUI() {

    }
}