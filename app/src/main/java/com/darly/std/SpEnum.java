package com.darly.std;

/**
 * author:zhangyuhui
 * date:2020-01-0911:21
 * description:保存缓存的关键字枚举类
 */
public enum SpEnum {

    //SO的版本号
    SOVERSION("soversion"),

    //是否第一次打开应用，是否进入欢迎页面
    FIRSTOPEN("firstopen"),
    //是否已经设置用户信息，是否进入信息设置引导页面。
    SYSTEMUSERINFO("systemuserinfo"),
    //用户信息保存主键
    USERINFO("userinfo");


    private String desc;

    SpEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
