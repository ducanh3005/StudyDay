package com.darly.rnmodule;

/**
 * author:zhangyuhui
 * date:2020-01-0911:21
 * description:所有RN调用原生方法的类返回名称
 */
public enum ModuleEnum {
    //提供React Native进行调用的原生方法
    LISTMODULE("ListModule"),
    //初始化RN需要原生参数的方法。
    INIT_MODULE("InitModule"),

    //提供React Native进行调用的原生封装控件
    TOASTMANAGER("ToastManager"),
    //提供React Native进行调用的原生封装控件地图组件
    LBSMAPMANAGER("LbsMapManager"),

    //提供React Native界面调用入口（对应的Android原生界面）
    RNSTUDYACTIVITY("RNStudyActivity"),
    LISTENTITYACTIVITY("ListEntityActivity"),
    //有导航界面的React Native
    RNNAVIGATORACTIVITY("RNNavigatorActivity"),
    //React Native首页
    REACTNATIVEMAINACTIVITY("ReactNativeMainActivity");


    private String desc;

    ModuleEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
