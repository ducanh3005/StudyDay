/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.chinese.parse;

/**
 * Description TODO:解析回调类
 * Package com.darly.dlcommon.parse
 * @author zhangyuhui
 * Date 2019/7/31 17:39
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public interface OnParseJsonListener {

    /**
     * 解析完成
     */
    void onComplete();

    /**加载进度
     * @param percent  进度值
     */
    void onProgress(int percent);

    /**
     * 解析失败
     * @param msg 失败信息
     */
    void onFailed(String msg);
}
