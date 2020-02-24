/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.dlcommon.framework;

import android.app.Application;
import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

/**
 * Description TODO: 缓存工具类，保存Application
 * Package com.darly.dlcommon.framework
 * @author zhangyuhui
 * Date 2019/7/31 16:50
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class ContextController {

    private HashMap<String, Object> map = new HashMap(10);

    private ContextController(){
    }

    static class ContextControllerHolder{
        static ContextController controller = new ContextController();
    }

    public static ContextController getInstance(){
        return ContextControllerHolder.controller;
    }


    public Application getApplication(){
        return (Application)map.get("Application");
    }

    public void setApplication(Object value){
        map.put("Application",value);
    }

    public EventBusController getEventBusController(){
        return (EventBusController)map.get("EventBusController");
    }

    public void setEventBusController(Object value){
        map.put("EventBusController",value);
    }

    public SharePerferenceController getSharePerferenceController(){
        return (SharePerferenceController)map.get("SharePerferenceController");
    }

    public void setSharePerferenceController(Object value){
        map.put("SharePerferenceController",value);
    }

}
