package com.darly.rnmodule.module;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import com.darly.dlcommon.common.dlog.DLog;
import com.darly.dlcommon.common.net.NetUtil;
import com.darly.dlcommon.framework.ContextController;
import com.darly.rnmodule.ModuleEnum;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;

/**
 * author:zhangyuhui
 * date:2020-01-1311:37
 * description: 初始化RN需要原生参数的方法。
 */
public class InitModule extends ReactContextBaseJavaModule {

    public InitModule(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return ModuleEnum.INIT_MODULE.getDesc();
    }

    @ReactMethod
    public void init(Promise promise){
        DLog.d("init() called");
        WritableMap init = Arguments.createMap();
        init.putString(NetUtil.SYSTEM_IP,ContextController.getInstance().getSharePerferenceController().getValue(NetUtil.SYSTEM_IP).toString());

        promise.resolve(init);
    }

    /**
     * 提供RN调用退出时的方法。
     */
    @ReactMethod
    public void finish() {
        try {
            getCurrentActivity().setResult(Activity.RESULT_OK);
            getCurrentActivity().finish();
        }catch (Exception e){

        }catch (Error e){

        }
    }

}
