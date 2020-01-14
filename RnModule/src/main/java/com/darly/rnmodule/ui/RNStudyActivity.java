package com.darly.rnmodule.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.darly.rnmodule.ModuleEnum;

/**
 * author:zhangyuhui
 * date:2020-01-1011:38
 * description: RN 导入界面
 */
public class RNStudyActivity extends BaseReactNativeActivity {


    @Nullable
    @Override
    protected String getMainComponentName() {
        return ModuleEnum.RNSTUDYACTIVITY.getDesc();
    }

    @Override
    public Bundle getOwnLaunchOptions() {
        Log.d("RNStudyActivity", "getOwnLaunchOptions() called");
        return null;
    }
}
