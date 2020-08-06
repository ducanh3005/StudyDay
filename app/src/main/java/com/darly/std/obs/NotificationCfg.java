package com.darly.std.obs;


import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.darly.dlcommon.common.dlog.DLog;
import com.darly.dlcommon.common.net.NetUtil;
import com.darly.dlcommon.framework.ContextController;
import com.darly.dlcommon.retrofit.RxjavaRetrofitRequestUtil;
import com.darly.dlcommon.retrofit.reobs.ObserverListener;
import com.darly.dlcommon.retrofit.reobs.RxNotification;
import com.darly.rnmodule.module.NoticeReactNativeModule;
import com.darly.std.retrofit.HttpInterface;
import com.darly.std.retrofit.model.BaseModel;
import com.darly.std.retrofit.model.IPModel;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.google.gson.JsonObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 對封裝后的工具使用Image進行初始化。
 *
 * @author Darly/张宇辉/2017/11/23 14:18
 * @version 1.0/com.darly.common
 */
public class NotificationCfg implements ObserverListener {

    private static NotificationCfg instance = null;


    private NotificationCfg() {
    }

    public static NotificationCfg getInstance() {
        if (instance == null) {
            instance = new NotificationCfg();
        }
        return instance;
    }

    @Override
    public void initRetrofit(Class<? extends RxNotification> cls) {

    }

    @Override
    public void notifUI() {
        DLog.d("notifUI");
        RxjavaRetrofitRequestUtil.getInstance().get(HttpInterface.class).getKey((String) ContextController.getInstance().getSharePerferenceController().getValue(NetUtil.SYSTEM_IP))
                .subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<JsonObject, IPModel>() {
                    @Override
                    public IPModel call(JsonObject s) {
                        DLog.json("Func1", s.toString());

                        IPModel model = JSON.parseObject(s.toString(), IPModel.class);
                        return model;
                    }
                })
                .subscribe(new rx.Observer<IPModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(IPModel s) {
                        WritableMap result = Arguments.createMap();
                        //父类子类属性集合
                        List<String> names = new ArrayList<>();
                        findAllFiedls(names, s.getClass());
                        for (String name : names) {
                            Object value = getFieldValueByName(name, s);
                            result.putString(name, value == null ? "" : value.toString());
                        }
                        NoticeReactNativeModule.sendEvent(NoticeReactNativeModule.NATIVE_GET_CALL, result);
                    }
                });
    }

    public void findAllFiedls(List<String> names, Class cls) {
        if (TextUtils.equals(cls.getSuperclass().getSimpleName(), "Object")) {
            //还有父类
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                names.add(field.getName());
            }
        } else {
            findAllFiedls(names, cls.getSuperclass());
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                names.add(field.getName());
            }
        }
    }

    /**
     * @param name 参数名称
     * @return
     * @throws IllegalAccessException
     * @Description 根据属性名 获取值（value）
     */
    public Object getFieldValueByName(String name, BaseModel model) {
        String first_letter = name.substring(0, 1).toUpperCase();
        String getter = "get" + first_letter + name.substring(1);
        Method method;
        Object value;
        try {
            method = model.getClass().getMethod(getter);
            value = method.invoke(model);
            return value;
        } catch (Exception e) {
        }
        return null;
    }
}