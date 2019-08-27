/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std.vm;

/**
 * Description TODO: 单个条目点击事件
 * Package com.darly.qtest.vm
 *
 * @author zhangyuhui
 * @date 2019/8/20 17:57
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public interface OnItemClickListener<T> {

    /**
     * 条目点击回调
     * @param t 对象
     */
    void onItemClick(T t);
}
