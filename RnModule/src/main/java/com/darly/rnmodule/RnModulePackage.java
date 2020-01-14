package com.darly.rnmodule;

import androidx.annotation.NonNull;

import com.darly.rnmodule.module.ListModule;
import com.darly.rnmodule.viewmodule.ToastManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.List;

/**
 * author:zhangyuhui
 * date:2020-01-1313:48
 * description: Rn 调用所有的Java方法对象集合
 */
public class RnModulePackage implements ReactPackage {


    @NonNull
    @Override
    public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactContext) {
        //这个是提供方法调用，传递参数到Java中，进行执行。（当然包含界面跳转）
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new ListModule(reactContext));//测试RN调用Java方法，对接
        return modules;
    }

    @NonNull
    @Override
    public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactContext) {
        //这个是提供Android封装的控件对象，RN直接引用Java控件
        List<ViewManager> managers = new ArrayList<>();
        managers.add(new ToastManager());
        return managers;
    }
}
