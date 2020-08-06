package com.darly.chinese.table;

import android.os.Parcel;
import android.os.Parcelable;

public class BlackTable implements Parcelable {
    private int id;
    private String key0;
    private String key15;
    private String key30;
    private String key45;

    public BlackTable() {
    }

    public BlackTable(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey0() {
        return key0;
    }

    public void setKey0(String key0) {
        this.key0 = key0;
    }

    public String getKey15() {
        return key15;
    }

    public void setKey15(String key15) {
        this.key15 = key15;
    }

    public String getKey30() {
        return key30;
    }

    public void setKey30(String key30) {
        this.key30 = key30;
    }

    public String getKey45() {
        return key45;
    }

    public void setKey45(String key45) {
        this.key45 = key45;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 把javanbean中的数据写到Parcel
     *
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(key0);
        dest.writeString(key15);
        dest.writeString(key30);
        dest.writeString(key45);
    }

    /**
     * 添加一个静态成员,名为CREATOR,该对象实现了Parcelable.Creator接口
     */
    public static final Parcelable.Creator<BlackTable> CREATOR = new Parcelable.Creator<BlackTable>() {
        @Override
        public BlackTable createFromParcel(Parcel source) {//从Parcel中读取数据，返回person对象
            BlackTable info = new BlackTable();
            info.id = source.readInt();
            info.key0 = source.readString();
            info.key15 = source.readString();
            info.key30 = source.readString();
            info.key45 = source.readString();
            return info;
        }

        @Override
        public BlackTable[] newArray(int size) {
            return new BlackTable[size];
        }
    };

}
