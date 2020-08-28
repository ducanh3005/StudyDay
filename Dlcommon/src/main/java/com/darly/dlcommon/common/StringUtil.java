/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.dlcommon.common;

import androidx.annotation.NonNull;

import com.darly.dlcommon.BuildConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Description TODO: 判断字符串工具类
 * Package com.darly.dlcommon.common
 *
 * @author zhangyuhui
 * @date 2019/8/20 18:16
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class StringUtil {

    private StringUtil() {
    }

    /**
     * 判断字符串是否为空
     *
     * @param arg 字符串
     * @return 是否为空
     */
    public static boolean isEmpty(String arg) {
        if (arg == null || "".equals(arg)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * input 流转换为字符串
     *
     * @param is 流入口
     * @return
     */
    public static String convertStreamToString(InputStream is) {
        String s = null;
        try {
            //格式转换
            Scanner scanner = new Scanner(is, "UTF-8").useDelimiter("\\A");
            if (scanner.hasNext()) {
                s = scanner.next();
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 根据提供的字符串封装成http请求。
     * @param url 服务器地址
     * @param port 服务器端口号
     * @return 返回http请求
     */
    public static String getHost(@NonNull String url, String port){
        if (isEmpty(port)) {
            return BuildConfig.HOST.replace("{0}", url);
        }else {
            return BuildConfig.HOST.replace("{0}", url).replace("8090",port);
        }
    }


}
