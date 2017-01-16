package com.coolweatherpractice.db;

import android.os.Parcel;
import android.os.Parcelable;

import org.litepal.crud.DataSupport;

/**
 * Created by hcywff on 2017/1/15.
 */

public class Province extends DataSupport implements Parcelable {

    private int id;
    private String provinceName;
    private int provinceCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.provinceName);
        dest.writeInt(this.provinceCode);
    }

    public Province() {
    }

    protected Province(Parcel in) {
        this.id = in.readInt();
        this.provinceName = in.readString();
        this.provinceCode = in.readInt();
    }

    public static final Parcelable.Creator<Province> CREATOR = new Parcelable.Creator<Province>() {
        @Override
        public Province createFromParcel(Parcel source) {
            return new Province(source);
        }

        @Override
        public Province[] newArray(int size) {
            return new Province[size];
        }
    };
}
