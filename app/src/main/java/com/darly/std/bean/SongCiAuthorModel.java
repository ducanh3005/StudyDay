/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std.bean;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.UUID;

/**
 * Description TODO:诗人
 * Package com.darly.dlcommon.db.chinese.table
 *
 * @author zhangyuhui
 * Date 2019/7/31 17:35
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class SongCiAuthorModel extends BaseBean implements Serializable {

    UUID autoId;
    String name;
    String description;
    String short_description;

    public SongCiAuthorModel(UUID autoId, String name, String description, String short_description) {
        this.autoId = autoId;
        this.name = name;
        this.description = description;
        this.short_description = short_description;
    }

    public UUID getAutoId() {
        return autoId;
    }

    public void setAutoId(UUID autoId) {
        this.autoId = autoId;
    }

    public String getName() {
        return TextUtils.isEmpty(name) ? "空数据" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return TextUtils.isEmpty(description) ? "空数据" : description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShort_description() {
        return TextUtils.isEmpty(short_description) ? "空数据" : short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    @Override
    public UUID getUUID() {
        return getAutoId();
    }


    @Override
    public String getString() {
        return "autoId = " + getAutoId() +
                "name = " + getName() +
                "description = " + getDescription() +
                "short_description = " + getShort_description();
    }

    public static String getClassName() {
        return "宋词作者";
    }
}
