package com.darly.api.db.systemdb.table;

import androidx.annotation.NonNull;

import com.darly.api.db.systemdb.database.SystemDataBase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.UUID;

/**
 * author:zhangyuhui
 * date:2020-07-0615:58
 * description: 后台系统数据库，保存系统级别的数据。
 */

@Table(database = SystemDataBase.class)
public class System_Table extends BaseModel {

    /**
     * 自增ID
     */
    @PrimaryKey
    @Column
    UUID autoId;
    /**
     * apikey
     */
    @Column
    String key;
    /**
     * apivalue
     */
    @Column
    String value;

    public UUID getAutoId() {
        return autoId;
    }

    public void setAutoId(UUID autoId) {
        this.autoId = autoId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @NonNull
    @Override
    public String toString() {
        return " autoId：" + autoId + " key：" + key + " value：" + value;
    }
}
