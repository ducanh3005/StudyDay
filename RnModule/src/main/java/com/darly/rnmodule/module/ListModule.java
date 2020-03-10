package com.darly.rnmodule.module;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import com.darly.rnmodule.ModuleEnum;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * author:zhangyuhui
 * date:2020-01-1311:37
 * description: 创建一个提供RN调用的Java方法。
 */
public class ListModule extends ReactContextBaseJavaModule {

    public ListModule(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return ModuleEnum.LISTMODULE.getDesc();
    }

    @ReactMethod
    public void showToast(){
        Log.d(ModuleEnum.LISTMODULE.getDesc(), "showToast() called");
    }

    @ReactMethod
    public void showActin(String key){
        Log.d(ModuleEnum.LISTMODULE.getDesc(), "showToast() called with: key = [" + key + "]");
    }

    @ReactMethod
    public void showExit(String key, Promise promise){
        Log.d(ModuleEnum.LISTMODULE.getDesc(), "showToast() called with: key = [" + key + "], promise = [" + promise + "]");
        promise.resolve(key);

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
