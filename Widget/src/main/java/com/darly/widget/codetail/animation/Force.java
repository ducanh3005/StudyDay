/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.widget.codetail.animation;

/**
 * Hide this for now, in case we want to change the API.
 */

/**
 * Description 该类功能为：同步文件保存路径
 * Package com.darly.widget.codetail.animation
 *
 * @author zhangyuhui
 * @date 2019/8/21
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
interface Force {
    // Acceleration based on position.
    float getAcceleration(float position, float velocity);

    boolean isAtEquilibrium(float value, float velocity);
}
