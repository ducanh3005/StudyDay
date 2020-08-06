package com.darly.dlcommon.common.net;

/**
 * author:zhangyuhui
 * date:2020-05-2211:15
 * description: 网络状态
 */
public enum NetworkType {

    NETWORK_WIFI("WiFi"),
    NETWORK_4G("4G"),
    NETWORK_2G("2G"),
    NETWORK_3G("3G"),
    NETWORK_UNKNOWN("Unknown"),
    NETWORK_NO("No network");

    private String desc;

    NetworkType(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }

}
