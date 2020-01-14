package com.darly.rnmodule.ui;

import androidx.annotation.Nullable;

import com.darly.rnmodule.ModuleEnum;

/**
 * author:zhangyuhui
 * date:2020-01-1409:17
 * description: 列表展示使用RN界面
 */
public class ListEntityActivity extends BaseReactNativeActivity {

    @Nullable
    @Override
    protected String getMainComponentName() {
        return ModuleEnum.LISTENTITYACTIVITY.getDesc();
    }
}
