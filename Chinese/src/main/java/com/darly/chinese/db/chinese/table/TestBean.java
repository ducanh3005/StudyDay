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

import java.util.UUID;

/**
 * Description TODO:中国词
 * Package com.darly.dlcommon.db.chinese.table
 * @author zhangyuhui
 * Date 2019/7/31 17:30
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
@Table(database = ChineseDataBase.class)
public class TestBean extends BaseModel {
    /**
     * 自增ID
     */
    @PrimaryKey
    @Column
    private UUID autoId;
    /**
     * 操作库存
     */
    @Column
    private int author;

    public UUID getAutoId() {
        return autoId;
    }

    public void setAutoId(UUID autoId) {
        this.autoId = autoId;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }
}
