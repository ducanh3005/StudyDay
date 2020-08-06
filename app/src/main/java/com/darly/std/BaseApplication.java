/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;

import androidx.multidex.MultiDex;

import com.darly.api.base.NetStateChangeReceiver;
import com.darly.api.service.ApiService;
import com.darly.chinese.ChineseApplication;
import com.darly.chinese.common.SpController;
import com.darly.chinese.controller.fileload.ExternalStorageUtil;
import com.darly.dlcommon.common.dlog.DLog;
import com.darly.dlcommon.common.net.NetUtil;
import com.darly.dlcommon.retrofit.RxInterceptor;
import com.darly.dlcommon.retrofit.RxjavaRetrofitRequestUtil;
import com.darly.rnmodule.RnModulePackage;
import com.darly.rnmodule.obs.RNModule;
import com.darly.std.obs.NotificationToApp;
import com.darly.std.retrofit.RetrofitCfg;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.horcrux.svg.SvgPackage;
import com.oblador.vectoricons.VectorIconsPackage;
import com.swmansion.gesturehandler.react.RNGestureHandlerPackage;
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;

import java.util.Arrays;
import java.util.List;

/**
 * Description TODO:
 * Package com.darly.std
 *
 * @author zhangyuhui
 * Date 2019/8/1 14:44
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */

public class BaseApplication extends ChineseApplication implements ReactApplication {

    NetStateChangeReceiver receiver;

    @Override
    public void onCreate() {
        super.onCreate();
        // 方法数量大于65536
        MultiDex.install(this);

        if (BuildConfig.DEBUG) {
            ExternalStorageUtil.delete();
        }
        SoLoader.init(this, false);
        SpController.getInstance().setName("study");
        SpController.getInstance().putValue(NetUtil.SYSTEM_IP, NetUtil.getIPAddress(this));
        //启动服务器
        DLog.d("[BaseApplication 服务启动中...]");
        Intent service = new Intent(this, ApiService.class);
        startService(service);
        receiver = new NetStateChangeReceiver();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, intentFilter);
        //初始化网络工具
        RxInterceptor.setVersionCode(getVersionCode());
        RxInterceptor.init(new RetrofitCfg());
        String url = "http://" + SpController.getInstance().getValue(NetUtil.SYSTEM_IP) + ":55550";
        RxjavaRetrofitRequestUtil.setBaseUrl(url);

        RNModule.init().initRetrofit(NotificationToApp.class);

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
                    new SafeAreaContextPackage(),
                    //React Native图标
                    new VectorIconsPackage(),
                    //iconfont图标
                    new SvgPackage()
            );
        }
    };


    public int getVersionCode() {
        int version = 0;

        try {
            PackageInfo e = this.getPackageManager().getPackageInfo(this.getPackageName(), 0);
            version = e.versionCode;
        } catch (PackageManager.NameNotFoundException var3) {
            var3.printStackTrace();
        }

        return version;
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
        //关闭服务器
        DLog.d("[BaseApplication 服务关闭中...]");
        Intent service = new Intent(this, ApiService.class);
        stopService(service);
        unregisterReceiver(receiver);
    }
}
