/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.chinese.db.chinese.table;

import com.darly.chinese.db.chinese.database.ChineseDataBase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;
import java.util.UUID;

/**
 * Description TODO:诗人
 * Package com.darly.dlcommon.db.chinese.table
 * @author zhangyuhui
 * Date 2019/7/31 17:35
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
@Table(database = ChineseDataBase.class)
public class SongCiAuthorBean extends BaseModel{
    public static String NAME = "author.song";
    /**
     * 自增ID
     */
    @PrimaryKey
    @Column
    UUID autoId;
    /**
     * 作者名称
     */
    @Column
    String name;
    /**
     * 详细介绍
     */
    @Column
    String description;
    /**
     * 简单介绍
     */
    @Column
    String short_description;

    public UUID getAutoId() {
        return autoId;
    }

    public void setAutoId(UUID autoId) {
        this.autoId = autoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }
}
