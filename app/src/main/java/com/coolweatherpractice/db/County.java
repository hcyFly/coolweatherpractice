package com.coolweatherpractice.db;

import android.os.Parcel;
import android.os.Parcelable;

import org.litepal.crud.DataSupport;

/**
 * Created by hcywff on 2017/1/15.
 */

public class County extends DataSupport implements Parcelable {


    private int id;
    private String countyName;
    private String weatherId;
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.countyName);
        dest.writeString(this.weatherId);
        dest.writeInt(this.cityId);
    }

    public County() {
    }

    protected County(Parcel in) {
        this.id = in.readInt();
        this.countyName = in.readString();
        this.weatherId = in.readString();
        this.cityId = in.readInt();
    }

    public static final Parcelable.Creator<County> CREATOR = new Parcelable.Creator<County>() {
        @Override
        public County createFromParcel(Parcel source) {
            return new County(source);
        }

        @Override
        public County[] newArray(int size) {
            return new County[size];
        }
    };
}
