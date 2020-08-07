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
 * Description TODO:中国词
 * Package com.darly.dlcommon.db.chinese.table
 *
 * @author zhangyuhui
 * Date 2019/7/31 17:30
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class SongCiModel extends BaseBean implements Serializable {
    private UUID autoId;
    private String author;
    private String paragraphs;
    private String rhythmic;

    public SongCiModel(UUID autoId, String author, String paragraphs, String rhythmic) {
        this.autoId = autoId;
        this.author = author;
        this.paragraphs = paragraphs;
        this.rhythmic = rhythmic;
    }

    public UUID getAutoId() {
        return autoId;
    }

    public void setAutoId(UUID autoId) {
        this.autoId = autoId;
    }

    public String getAuthor() {
        return TextUtils.isEmpty(author) ? "空数据" : author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getParagraphs() {
        return TextUtils.isEmpty(paragraphs) ? "空数据" : paragraphs;
    }

    public void setParagraphs(String paragraphs) {
        this.paragraphs = paragraphs;
    }

    public String getRhythmic() {
        return TextUtils.isEmpty(rhythmic) ? "空数据" : rhythmic;
    }

    public void setRhythmic(String rhythmic) {
        this.rhythmic = rhythmic;
    }

    @Override
    public UUID getUUID() {
        return getAutoId();
    }

    @Override
    public String getString() {
        return "autoId = " + getAutoId() +
                "author = " + getAuthor() +
                "paragraphs = " + getParagraphs() +
                "rhythmic = " + getRhythmic();
    }

    public static String getClassName() {
        return "宋词";
    }
}
