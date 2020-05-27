/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.dlcommon.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    /**判断字符串是否为空
     * @param arg 字符串
     * @return 是否为空
     */
    public static boolean isEmpty(String arg){
        if (arg == null||"".equals(arg)){
            return true;
        }else{
            return false;
        }
    }

}
