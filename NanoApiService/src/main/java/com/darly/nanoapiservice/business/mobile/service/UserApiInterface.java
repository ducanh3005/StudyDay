package com.darly.nanoapiservice.business.mobile.service;

import java.util.Map;

/**
 * author:zhangyuhui
 * date:2020-05-2311:32
 * description: 接口调用入口，从这里判断进入哪个方法执行。
 */
public interface UserApiInterface {

    String list(Map<String, String> param);

}
