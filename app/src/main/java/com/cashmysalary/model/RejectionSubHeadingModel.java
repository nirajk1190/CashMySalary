package com.cashmysalary.model;

import android.os.Parcel;
import android.os.Parcelable;

public class RejectionSubHeadingModel implements Parcelable {
    private String name;

    public RejectionSubHeadingModel(Parcel in) {
        name = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RejectionSubHeadingModel(String name) {
        this.name = name;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RejectionSubHeadingModel> CREATOR = new Creator<RejectionSubHeadingModel>() {
        @Override
        public RejectionSubHeadingModel createFromParcel(Parcel in) {
            return new RejectionSubHeadingModel(in);
        }

        @Override
        public RejectionSubHeadingModel[] newArray(int size) {
            return new RejectionSubHeadingModel[size];
        }
    };
}
