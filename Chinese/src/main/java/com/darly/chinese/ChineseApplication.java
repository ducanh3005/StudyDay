/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.chinese;

import androidx.multidex.MultiDexApplication;

import com.darly.dlcommon.CommonController;
import com.raizlabs.android.dbflow.config.ChineseGeneratedDatabaseHolder;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Description TODO: 基础APPlication
 * Package com.darly.chinese
 * @author zhangyuhui
 * @date 2019/8/1 14:45
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class ChineseApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
//        FlowManager.init(this);
//        FlowManager.init(new FlowConfig.Builder(context).build());
        //添加日志
        FlowManager.init(FlowConfig.builder(this).addDatabaseHolder(ChineseGeneratedDatabaseHolder.class).build());
        FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);
        CommonController.init(this);
    }


}
