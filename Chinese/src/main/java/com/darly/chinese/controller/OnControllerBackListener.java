/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.chinese.controller;

import com.darly.chinese.base.ControllerEnum;

/**
 * Description TODO:任务回调类
 * Package com.darly.dlcommon.parse
 *
 * @author zhangyuhui
 * Date 2019/7/31 17:39
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public interface OnControllerBackListener {
    /**
     * 任务开始
     *
     * @param type 任务名称
     */
    void onStart(String title);


    /**
     * 任务加载进度
     *
     * @param percent 进度值
     */
    void onProgress(int percent);

    /**
     * 辅助加载进度
     *
     * @param percent 进度值
     */
    void onSecProgress(int percent);

    /**
     * 任务完成
     *
     * @param type 任务名称
     * @param ob   任务返回数据
     */
    void onComplete(String title, ControllerEnum type, Object ob);

    /**
     * 任务失败
     *
     * @param type 任务名称
     * @param msg  失败信息
     */
    void onFailed(String title, ControllerEnum type, String msg);
}
