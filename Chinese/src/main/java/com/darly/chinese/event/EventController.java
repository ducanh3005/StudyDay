/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.chinese.event;

import com.darly.dlcommon.framework.ContextController;

/**
 * Description TODO:
 * Package com.darly.chinese.event
 *
 * @author zhangyuhui
 * @date 2019/8/22 17:06
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class EventController {
    private EventController() {
    }
    public static void register(Object ob){
        ContextController.getInstance().getEventBusController().regist(ob);
    }
    public static void unregister(Object ob){
        ContextController.getInstance().getEventBusController().unregist(ob);
    }


    public static void postMessage(BaseEvent event){
        ContextController.getInstance().getEventBusController().postMessage(event);
    }
}
