package com.darly.rnmodule.obs;

import com.darly.dlcommon.retrofit.reobs.DesignListener;

/**
 * author:zhangyuhui
 * date:2020-05-2517:59
 * description:RN工具界面，使用APP中的方法。调用初始化方法。
 */
public class RNModule {
    /**
     * 观察者模式中的响应者。
     */
    protected static DesignListener design;

    /**
     * 对工具类进行初始化方法，在主项目的Application中进行初始化调用。
     * @return DesignListener
     */
    public static DesignListener init(){
        //在這裡對DView中的組件進行初始化變量操作
        design = new AbstractDesigner();
        design.addObserver(InitCfg.getInstance());
        return design;
    }

}
