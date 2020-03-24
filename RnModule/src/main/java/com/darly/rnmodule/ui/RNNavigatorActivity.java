package com.darly.rnmodule.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.darly.rnmodule.ModuleEnum;

/**
 * author:zhangyuhui
 * date:2020-01-1011:38
 * description: 导航界面
 */
public class RNNavigatorActivity extends BaseReactNativeActivity {


    @Nullable
    @Override
    protected String getMainComponentName() {
        Log.e("RNNavigatorActivity", "getMainComponentName: "+ModuleEnum.RNNAVIGATORACTIVITY.getDesc());
        return ModuleEnum.RNNAVIGATORACTIVITY.getDesc();
    }

    @Override
    public Bundle getOwnLaunchOptions() {
        Log.d("RNNavigatorActivity", "getOwnLaunchOptions() called");
        return null;
    }
}
