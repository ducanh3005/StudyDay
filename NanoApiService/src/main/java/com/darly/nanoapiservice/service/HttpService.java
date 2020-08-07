package com.darly.nanoapiservice.service;


import android.util.Log;

import com.darly.nanoapiservice.base.MethodName;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import fi.iki.elonen.NanoHTTPD;

/**
 * author:zhangyuhui
 * date:2020-05-2210:30
 * description: 使用NanoHTTPD，建立简单服务器
 */
public class HttpService extends NanoHTTPD {

    public HttpService(int port) {
        super(port);
        Log.d(getClass().getSimpleName(),"[ApiService 已启动]");
    }

    public HttpService(String hostname, int port) {
        super(hostname, port);
    }


    @Override
    public Response serve(IHTTPSession session) {
        //可以看到是什么请求方式
        try {
            /*
             * 对于post请求，你需要先调用parseBody()方法，
             * 直接传一个简单的新构造的map就行了
             */
            session.parseBody(new HashMap());
            Map params = session.getParms();
            String uri = session.getUri();
            //通过uri进行匹配现有的逻辑，看看走向哪里。返回的都是
            String json = MethodName.getMethods(uri, params);
            return newFixedLengthResponse(json);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ResponseException e) {
            e.printStackTrace();
        }

        JSONObject json = new JSONObject();
        try {
            json.put("code", 500);
            json.put("msg", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return newFixedLengthResponse(json.toString());
    }
}
