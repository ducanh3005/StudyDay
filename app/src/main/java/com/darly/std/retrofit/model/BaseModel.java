package com.darly.std.retrofit.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * author:zhangyuhui
 * date:2020-05-2617:00
 * description: 接口返回的基础数据对象。
 */
public class BaseModel implements Parcelable,Comparable<BaseModel> {

    private int code;
    private String msg;

    public BaseModel(){
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeString(msg);
    }

    public static final Parcelable.Creator<BaseModel> CREATOR = new Parcelable.Creator<BaseModel>() {
        public BaseModel createFromParcel(Parcel in) {
            BaseModel model = new BaseModel();
            model.setCode(in.readInt());
            model.setMsg(in.readString());
            return model;
        }

        public BaseModel[] newArray(int size) {
            return new BaseModel[size];
        }
    };

    @Override
    public int compareTo(BaseModel model) {
        return toString().compareTo(model.toString());
    }
}
