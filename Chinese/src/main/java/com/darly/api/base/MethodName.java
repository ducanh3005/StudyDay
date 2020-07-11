package com.darly.api.base;

import com.darly.api.business.mobile.impl.MobileApi;
import com.darly.api.business.mobile.service.UserApiInterface;
import com.darly.dlcommon.common.StringUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * author:zhangyuhui
 * date:2020-05-2311:46
 * description: 所有接口名称对接匹配
 */
public class MethodName {

    private MethodName() {

    }

    private static Map<String, UserApiInterface> MethodsMap = new HashMap<>();

    /**
     * 设置接口合集。
     */
    public static void setMethodsMap() {
        MethodsMap.put(ApiCons.MOBILE, new MobileApi());
    }


    public static String getMethods(String uri, Map<String, String> data) {
        if (StringUtil.isEmpty(uri)) {
            JSONObject json = new JSONObject();
            try {
                json.put("code", 404);
                json.put("msg", "拒绝访问");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return json.toString();
        }
        UserApiInterface obj = null;
        if (uri.startsWith(ApiCons.MOBILE)) {
            //是mobile请求
            obj = MethodsMap.get(ApiCons.MOBILE);
        } else {
            obj = MethodsMap.get(uri);
        }
        Class cls = obj.getClass();
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            try {
                boolean isApi = method.isAnnotationPresent(ApiValue.class);//判断这个类中有没有注解
                if (!isApi) {
                    continue;
                }
                ApiValue value = method.getAnnotation(ApiValue.class);
                String valueName = value.value();
                if (uri.equals(valueName)) {//传递过来的uri就是注解情况，执行该方法。
                    return (String) method.invoke(obj, data);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
