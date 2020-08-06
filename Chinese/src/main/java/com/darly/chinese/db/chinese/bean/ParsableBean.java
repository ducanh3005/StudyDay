package com.darly.chinese.db.chinese.bean;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * author:zhangyuhui
 * date:2020-03-1309:56
 * description: 测试对象参数传递问题。
 */
public class ParsableBean implements Parcelable {
    private String selfIntro;
    private String expertise;
    public String isEmailBound;
    public String isMobileBound;
    public ArrayList<String> skills = new ArrayList<>();// 员工技能
    public long departId;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(selfIntro);
        dest.writeString(expertise);
        dest.writeString(isEmailBound);
        dest.writeString(isMobileBound);
        dest.writeList(skills);
        dest.writeLong(departId);
    }


    /**
     * 添加一个静态成员,名为CREATOR,该对象实现了Parcelable.Creator接口
     */
    public static final Parcelable.Creator<ParsableBean> CREATOR = new Parcelable.Creator<ParsableBean>() {
        @Override
        public ParsableBean createFromParcel(Parcel source) {//从Parcel中读取数据，返回person对象
            ParsableBean info = new ParsableBean();
            info.selfIntro = source.readString();
            info.expertise = source.readString();
            info.isEmailBound = source.readString();
            info.isMobileBound = source.readString();
            source.readList(info.skills, JSONObject.class.getClassLoader());
            info.departId = source.readLong();
            return info;
        }

        @Override
        public ParsableBean[] newArray(int size) {
            return new ParsableBean[size];
        }
    };

}

