package com.darly.std.retrofit.model;


/**
 * author:zhangyuhui
 * date:2020-05-2617:08
 * description: 返回IP
 */
public class IPModel extends BaseModel {

    private String ip;

    private SubModel data;

    public IPModel(){

    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setData(SubModel data) {
        this.data = data;
    }

    public SubModel getData() {
        return data;
    }
}
