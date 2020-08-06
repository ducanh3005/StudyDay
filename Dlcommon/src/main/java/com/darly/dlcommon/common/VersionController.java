/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.dlcommon.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.darly.dlcommon.framework.ContextController;

/**
 * Description TODO: 版本信息工具类
 * Package com.darly.dlcommon.common
 *
 * @author zhangyuhui
 * Date 2019/8/1 13:52
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class VersionController {

    private VersionController() {
    }

    /**
     * 获取包名
     *
     * @return 包名
     */
    public static String packageName() {
        return ContextController.getInstance().getApplication().getPackageName();
    }

    /**
     * 获取版本号
     *
     * @return 版本号
     */
    public static int versionCode() {
        PackageManager manager = ContextController.getInstance().getApplication().getPackageManager();
        int code = 0;
        try {
            PackageInfo info = manager.getPackageInfo(ContextController.getInstance().getApplication().getPackageName(), 0);
            code = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return code;
    }

    /**
     * 获取版本名称
     *
     * @return 版本名称
     */
    public static String versionName() {
        PackageManager manager = ContextController.getInstance().getApplication().getPackageManager();
        String name = null;
        try {
            PackageInfo info = manager.getPackageInfo(ContextController.getInstance().getApplication().getPackageName(), 0);
            name = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return name;
    }

    /**
     * 手机系统版本
     *
     * @return 系统版本
     */
    public static String getSdkVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 手机系统API level
     *
     * @return 系统API
     */
    public static int getSdkAPILevel() {
        return android.os.Build.VERSION.SDK_INT;
    }


}
