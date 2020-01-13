package com.darly.rnmodule.viewmodule;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.darly.rnmodule.ModuleEnum;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

/**
 * author:zhangyuhui
 * date:2020-01-1313:53
 * description:
 */
public class ToastManager extends SimpleViewManager<View> {
    @NonNull
    @Override
    public String getName() {
        return ModuleEnum.TOASTMANAGER.getDesc();
    }

    @NonNull
    @Override
    protected View createViewInstance(@NonNull ThemedReactContext reactContext) {
       TextView textView =  new TextView(reactContext);
        textView.setText("ToastManager");
        textView.setTextColor(Color.DKGRAY);
        return textView;
    }
}
