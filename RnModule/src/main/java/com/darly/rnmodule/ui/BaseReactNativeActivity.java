package com.darly.rnmodule.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;

/**
 * author:zhangyuhui
 * date:2020-01-1409:27
 * description:
 */
public class BaseReactNativeActivity extends ReactActivity {


    @Override
    protected ReactActivityDelegate createReactActivityDelegate() {
        return new ReactActivityDelegate(this,getMainComponentName()){
            @Nullable
            @Override
            protected Bundle getLaunchOptions() {
                return getOwnLaunchOptions();
            }
        };
    }


    public  Bundle getOwnLaunchOptions(){
        Log.d("BaseReactNativeActivity", "getOwnLaunchOptions() called");
        return null;
    }


    @Override
    public void onBackPressed() {
        if (getReactInstanceManager()!=null){
            getReactInstanceManager().onBackPressed();
        }else {
            super.onBackPressed();
        }
    }
}
