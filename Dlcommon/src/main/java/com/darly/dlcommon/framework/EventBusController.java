/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.dlcommon.framework;

import org.greenrobot.eventbus.EventBus;

/**
 * Description TODO:
 * Package com.darly.dlcommon.framework
 *
 * @author zhangyuhui
 * @date 2019/8/22 17:00
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class EventBusController {
    public EventBusController() {
    }

    public void regist(Object ob){
       EventBus.getDefault().register(ob);
    }
    public void unregist(Object ob){
        EventBus.getDefault().unregister(ob);
    }

    public void postMessage(Object event){
        EventBus.getDefault().post(event);
    }
}
