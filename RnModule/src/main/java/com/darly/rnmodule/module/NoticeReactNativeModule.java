package com.darly.rnmodule.module;

import androidx.annotation.NonNull;

import com.darly.dlcommon.common.dlog.DLog;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import javax.annotation.Nullable;

/**
 * author:zhangyuhui
 * date:2020-05-2212:02
 * description: 原生发送通知给RN
 */
public class NoticeReactNativeModule extends ReactContextBaseJavaModule {

    private static ReactContext mReactContext;

    public NoticeReactNativeModule(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
        this.mReactContext = reactContext;
    }

    @Override
    public String getName() {
        return "NoticeRNApi";
    }


    public static void sendEvent(String eventName,@Nullable WritableMap params) {
        try{
            if (mReactContext == null){
                DLog.e("react-native-module", eventName+"---null");
            }else{
                DLog.e("react-native-module", eventName + "————"+ params.toString());
                mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, params);
            }
        }catch(Exception e){

        }

    }

    public static void sendEvent(String eventName,String params) {
        try {
            if (mReactContext == null) {
                DLog.e("react-native-module", eventName + "---null");
            } else {
                DLog.e("react-native-module", eventName + "————" + params);
                mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, params);
            }
        }catch (Exception e){

        }

    }


    public static void sendEvent(String eventName,@Nullable  WritableMap params, ReactContext contekxt) {
        try {
            if (contekxt == null) {
                DLog.e("react-native-module", eventName + "---null");
            } else {
                DLog.e("react-native-module", eventName + "————" + params.toString());
                contekxt.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, params);
            }
        }catch (Exception e){


        }

    }

}
