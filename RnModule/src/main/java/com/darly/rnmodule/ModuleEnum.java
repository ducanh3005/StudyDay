package com.darly.rnmodule;

/**
 * author:zhangyuhui
 * date:2020-01-0911:21
 * description:所有RN调用原生方法的类返回名称
 */
public enum ModuleEnum {
    //提供React Native进行调用的原生方法
    LISTMODULE("ListModule"),

    //提供React Native进行调用的原生封装控件
    TOASTMANAGER("ToastManager"),

    //提供React Native界面调用入口（对应的Android原生界面）
    RNSTUDYACTIVITY("RNStudyActivity"),
    LISTENTITYACTIVITY("ListEntityActivity");

    private String desc;

    ModuleEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
