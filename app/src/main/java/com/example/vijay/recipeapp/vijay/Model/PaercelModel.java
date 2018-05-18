package com.example.vijay.recipeapp.vijay.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vijay on 14-02-2018.
 */

public class PaercelModel implements Parcelable {

    private String name;
    private String address;

    public PaercelModel(String n, String a) {

        this.name=n;
        this.address=a;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(name);
        parcel.writeString(address);

    }
    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<PaercelModel> CREATOR = new Parcelable.Creator<PaercelModel>() {
        public PaercelModel createFromParcel(Parcel in){
            return new PaercelModel(in);
        }

        public PaercelModel[] newArray(int size) {
            return new PaercelModel[size];
        }
    };
    public PaercelModel(Parcel in)
    {
        this.name=in.readString();
        this.address=in.readString();
    }
}
