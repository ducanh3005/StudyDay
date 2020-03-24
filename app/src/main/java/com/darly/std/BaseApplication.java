/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std;

import com.darly.chinese.ChineseApplication;
import com.darly.chinese.common.SpController;
import com.darly.chinese.controller.fileload.ExternalStorageUtil;
import com.darly.rnmodule.RnModulePackage;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.swmansion.gesturehandler.react.RNGestureHandlerPackage;
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;

import java.util.Arrays;
import java.util.List;

/**
 * Description TODO:
 * Package com.darly.std
 * @author zhangyuhui
 * Date 2019/8/1 14:44
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */

public class BaseApplication extends ChineseApplication implements ReactApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG){
            ExternalStorageUtil.delete();
        }
        SoLoader.init(this, false);
        SpController.getInstance().setName("study");
    }

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage(),
                    new RnModulePackage(),
                    //react-navigation 3.x版本的安装以及react-native-gesture-handler配置
                    new RNGestureHandlerPackage(),
                    new SafeAreaContextPackage()
            );
        }
    };
}
