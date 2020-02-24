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

/**
 * Description TODO:
 * Package com.darly.std
 * @author zhangyuhui
 * Date 2019/8/1 14:44
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class BaseApplication extends ChineseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG){
            ExternalStorageUtil.delete();
        }
        SpController.getInstance().setName("study");
    }
}
