/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.dlcommon.db.version.table;

import androidx.annotation.NonNull;

import com.darly.dlcommon.db.version.database.VersionDataBase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.UUID;

/**
 * Description TODO:版本信息
 * Package com.darly.dlcommon.db.chinese.table
 * @author zhangyuhui
 * Date 2019/7/31 17:30
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
@Table(database = VersionDataBase.class)
public class VersionBean extends BaseModel {
    /**
     * 自增ID
     */
    @PrimaryKey
    @Column
    private UUID autoId;
    /**
     * 应用包名
     */
    @Column
    private String packagename;
    /**
     * 版本号
     */
    @Column
    private int versioncode;
    /**
     * 版本名称
     */
    @Column
    private String versionname;

    public UUID getAutoId() {
        return autoId;
    }

    public void setAutoId(UUID autoId) {
        this.autoId = autoId;
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public int getVersioncode() {
        return versioncode;
    }

    public void setVersioncode(int versioncode) {
        this.versioncode = versioncode;
    }

    public String getVersionname() {
        return versionname;
    }

    public void setVersionname(String versionname) {
        this.versionname = versionname;
    }

    @NonNull
    @Override
    public String toString() {
        return " autoId："+autoId+" packagename："+packagename+" versioncode："+versioncode+" versionname:"+versionname;
    }
}
