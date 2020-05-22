package com.darly.std;

/**
 * author:zhangyuhui
 * date:2020-01-0911:21
 * description:保存缓存的关键字枚举类
 */
public enum SpEnum {

    //SO的版本号
    SO_VERSION("so_version"),
    //是否第一次打开应用，是否进入欢迎页面
    FIRST_OPEN("first_open"),
    //是否已经设置用户信息，是否进入信息设置引导页面。
    SYSTEM_USER_INFO("system_user_info"),

    //用户信息保存主键
    USER_INFO("user_info");


    private String desc;

    SpEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
