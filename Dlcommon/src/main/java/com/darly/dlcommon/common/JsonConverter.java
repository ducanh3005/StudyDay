/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.dlcommon.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Description TODO: 使用FastJson进行对象解析
 * Package com.darly.dlcommon.common
 *
 * @author zhangyuhui
 * Date 2019/8/5 17:39
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class JsonConverter {
    private static final SerializeConfig config;
    private static final SerializerFeature[] features;

    public JsonConverter() {
    }

    public static String toJsonString(Object var0) {
        return JSON.toJSONString(var0, config, new SerializerFeature[0]);
    }

    public static String toJsonStringWithFeatures(Object var0) {
        return JSON.toJSONString(var0, config, features);
    }

    public static Object fromJsonString(String var0) {
        return JSON.parse(var0);
    }

    public static <T> T fromJsonString(String var0, Class<T> var1) {
        return JSON.parseObject(var0, var1);
    }

    public static <T> T fromJsonString(String var0, Type var1) {
        return JSON.parseObject(var0, var1, new Feature[0]);
    }

    public static Object[] toArray(String var0) {
        return toArray(var0, (Class) null);
    }

    public static <T> Object[] toArray(String var0, Class<T> var1) {
        return JSON.parseArray(var0, var1).toArray();
    }

    public static <T> List<T> toList(String var0, Class<T> var1) {
        return JSON.parseArray(var0, var1);
    }

    public static Map jsonStringToMap(String var0) {
        return JSONObject.parseObject(var0);
    }

    public static String mapToJsonString(Map var0) {
        return JSONObject.toJSONString(var0);
    }

    static {
        (config = new SerializeConfig()).put(Date.class, new JSONLibDataFormatSerializer());
        config.put(java.sql.Date.class, new JSONLibDataFormatSerializer());
        features = new SerializerFeature[]{SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullStringAsEmpty};
    }
}