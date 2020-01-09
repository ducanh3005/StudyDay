/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.dlcommon;

import android.content.Context;

import com.darly.dlcommon.common.dlog.DLog;
import com.darly.dlcommon.framework.ContextController;
import com.darly.dlcommon.framework.EventBusController;
import com.darly.dlcommon.framework.SharePerferenceController;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.config.GeneratedDatabaseHolder;


/**
 * Description TODO: 工具类初始化方案。
 * Package com.darly.dlcommon
 * @author zhangyuhui
 * Date 2019/8/3 17:00
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class CommonController {

    private CommonController() {
    }

    public static void init(Context context) {
        ContextController.getInstance().setApplication(context);
        ContextController.getInstance().setEventBusController(new EventBusController());
        ContextController.getInstance().setSharePerferenceController(new SharePerferenceController(context));
//        FlowManager.init(context);
//        FlowManager.init(new FlowConfig.Builder(context).build());
        //添加日志
        FlowManager.init(FlowConfig.builder(context).addDatabaseHolder(GeneratedDatabaseHolder.class).build());
        FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);
        DLog.d("CommonController", "init() called with: context = [" + context + "]");
    }

}
