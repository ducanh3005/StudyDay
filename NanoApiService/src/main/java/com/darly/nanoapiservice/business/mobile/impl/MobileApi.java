package com.darly.nanoapiservice.business.mobile.impl;

import android.text.TextUtils;

import com.darly.nanoapiservice.base.ApiCons;
import com.darly.nanoapiservice.base.ApiValue;
import com.darly.nanoapiservice.business.mobile.service.UserApiInterface;
import com.darly.nanoapiservice.db.chinese.table.SongCiAuthorBean;
import com.darly.nanoapiservice.db.crud.DataBaseController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * author:zhangyuhui
 * date:2020-05-2311:47
 * description: mobile接口入口
 */
public class MobileApi implements UserApiInterface {


    @ApiValue(ApiCons.MOBILE_KEY)
    public String key(Map<String, String> paramer) {
        JSONObject json = new JSONObject();
        try {
            if (paramer != null) {
                String ip = paramer.get("ip");
                if (!TextUtils.isEmpty(ip)) {
                    JSONObject ob = new JSONObject();
                    ob.put("key","");
                    //接口正确
                    json.put("code", 200);
                    json.put("ip", "");
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
                        ob.put("key","");
                        //接口正确
                        json.put("code", 200);
                        json.put("ip", "");
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


    @Override
    @ApiValue(ApiCons.MOBILE_LIST)
    public String list(Map<String, String> param) {
        JSONObject json = new JSONObject();
        try {
            if (param != null) {
                for (Map.Entry<String, String> entry : param.entrySet()) {
                    //POST请求只有key
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        //接口正确
                        List<SongCiAuthorBean> data = DataBaseController.selectByLimit(SongCiAuthorBean.class, 10, 1);
                        JSONArray array = new JSONArray();
                        if (data!=null){
                            for (SongCiAuthorBean model:data) {
                                JSONObject ob = new JSONObject();
                                ob.put("key",model.getName());
                                array.put(ob);
                            }
                        }
                        //接口正确
                        json.put("code", 200);
                        json.put("data", array);
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
