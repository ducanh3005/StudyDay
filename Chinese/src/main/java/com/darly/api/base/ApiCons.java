package com.darly.api.base;

/**
 * author:zhangyuhui
 * date:2020-06-2916:14
 * description: 定义常量，返回常量信息。
 */
public class ApiCons {

    /**
     * 请求成功，返回code = 200
     */
    public static final int SUCCESS = 200;
    /**
     * 请求失败，返回code = 100
     */
    public static final int FAILURE = 100;
    /**
     * 请求被拒绝，返回code = 400
     */
    public static final int SYS_REFUSE = 400;
    /**
     * 服务端错误，返回code = 500
     */
    public static final int SYS_ERROR = 500;
    /**
     * 请求返回的code
     */
    public static final String CODE = "code";
    /**
     * 请求返回的data
     */
    public static final String DATA = "data";
    /**
     * 请求返回的msg
     */
    public static final String MESSAGE = "msg";


    /**
     * mobile接口合集
     */
    public static final String MOBILE = "/mobile";
    public static final String MOBILE_KEY = MOBILE + "/key";
    public static final String MOBILE_VALUE = MOBILE + "/value";

}
