package com.darly.api.base;

/**
 * author:zhangyuhui
 * date:2020-07-0616:45
 * description: 基础返回的数据类型
 */
public class BaseServiceModel {

    private int code;
    private String msg;
    private boolean data;

    public BaseServiceModel() {
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }
}
