/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.chinese.db.chinese.bean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Description TODO:
 * Package com.darly.chinese.db.chinese.bean
 *
 * @author zhangyuhui
 * @date 2019/8/23 16:22
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public abstract class BaseBean implements Serializable {
    public BaseBean() {
    }

    public abstract UUID getUUID();

    public abstract String getString();

}
