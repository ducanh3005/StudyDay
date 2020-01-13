package com.darly.rnmodule;

/**
 * author:zhangyuhui
 * date:2020-01-0911:21
 * description:所有RN调用原生方法的类返回名称
 */
public enum ModuleEnum {

    LISTMODULE("ListModule"),

    //是否第一次打开应用，是否进入欢迎页面
    FIRSTOPEN("firstopen"),
    //是否已经设置用户信息，是否进入信息设置引导页面。
    SYSTEMUSERINFO("systemuserinfo"),
    //用户信息保存主键
    USERINFO("userinfo"),

    TOASTMANAGER("ToastManager");


    private String desc;

    ModuleEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
