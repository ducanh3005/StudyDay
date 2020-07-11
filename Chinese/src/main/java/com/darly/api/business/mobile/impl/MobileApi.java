package com.darly.api.business.mobile.impl;


import com.darly.api.base.ApiCons;
import com.darly.api.base.ApiValue;
import com.darly.api.business.mobile.service.UserApiInterface;
import com.darly.dlcommon.common.StringUtil;
import com.darly.dlcommon.common.dlog.DLog;
import com.darly.dlcommon.common.net.NetUtil;
import com.darly.dlcommon.framework.ContextController;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * author:zhangyuhui
 * date:2020-05-2311:47
 * description: mobile接口入口
 */
public class MobileApi implements UserApiInterface {


    @ApiValue(ApiCons.MOBILE_KEY)
    public String key(Map<String, String> paramer) {
        DLog.d("paramer: " + paramer);
        JSONObject json = new JSONObject();
        try {
            if (paramer != null) {
                String ip = paramer.get("ip");
                if (!StringUtil.isEmpty(ip)) {
                    JSONObject ob = new JSONObject();
                    ob.put("key", ContextController.getInstance().getSharePerferenceController().getValue(NetUtil.SYSTEM_IP));
                    //接口正确
                    json.put("code", 200);
                    json.put("ip", ContextController.getInstance().getSharePerferenceController().getValue(NetUtil.SYSTEM_IP));
                    json.put("data", ob);
                    json.put("msg", "");
                } else {
                    json.put("code", 201);
                    json.put("msg", "参数错误");
                }
            } else {
                json.put("code", 200);
                json.put("msg", "没有数据");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    /**
     * 尝试POST请求
     *
     * @param paramer key有值
     * @return 返回数据
     */
    @ApiValue(ApiCons.MOBILE_VALUE)
    public String value(Map<String, String> paramer) {
        DLog.d("paramer: " + paramer);
        JSONObject json = new JSONObject();
        try {
            if (paramer != null) {
                for (Map.Entry<String, String> entry : paramer.entrySet()) {
                    //POST请求只有key
                    String key = entry.getKey();
                    JSONObject object = new JSONObject(key);
                    int over = object.optInt("over");
                    if (over == 1) {
                        //接口正确
                        JSONObject ob = new JSONObject();
                        ob.put("key", ContextController.getInstance().getSharePerferenceController().getValue(NetUtil.SYSTEM_IP));
                        //接口正确
                        json.put("code", 200);
                        json.put("ip", ContextController.getInstance().getSharePerferenceController().getValue(NetUtil.SYSTEM_IP));
                        json.put("data", ob);
                        json.put("msg", "");
                    } else {
                        json.put("code", 201);
                        json.put("msg", "参数错误");
                    }
                }
            } else {
                json.put("code", 200);
                json.put("msg", "没有数据");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }
}