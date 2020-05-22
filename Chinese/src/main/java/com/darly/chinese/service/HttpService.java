package com.darly.chinese.service;

import android.util.Log;

import com.darly.dlcommon.common.dlog.DLog;

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
        DLog.d("[ApiService 已启动]");
    }

    public HttpService(String hostname, int port) {
        super(hostname, port);
    }


    @Override
    public Response serve(IHTTPSession session) {
        try {
            // 这一句话必须要写，否则在获取数据时，获取不到数据
            session.parseBody(new HashMap<String, String>());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ResponseException e) {
            e.printStackTrace();
        }

        StringBuilder builder = new StringBuilder();
        String uri = session.getUri();
        Map<String, String> params = session.getParms();
        String data = params.get("data");//这里的data是POST提交表单时key
        DLog.d("uri: "+uri);//如果有uri,会打印出uri
        DLog.d("data: "+data);
        builder.append("Greeting for us!");// 反馈给调用者的数据
        return newFixedLengthResponse(builder.toString());
    }
}
