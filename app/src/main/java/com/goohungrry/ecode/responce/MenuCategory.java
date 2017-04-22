package com.goohungrry.ecode.responce;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Kalyan on 4/22/2017.
 */

public class MenuCategory implements Parcelable {

    public String catgoryId;

    public String catagoryName;

    public String sortid;

    public String ccid;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.catgoryId);
        dest.writeString(this.catagoryName);
        dest.writeString(this.sortid);
        dest.writeString(this.ccid);
    }

    public MenuCategory() {
    }

    protected MenuCategory(Parcel in) {
        this.catgoryId = in.readString();
        this.catagoryName = in.readString();
        this.sortid = in.readString();
        this.ccid = in.readString();
    }

    public static final Parcelable.Creator<MenuCategory> CREATOR = new Parcelable.Creator<MenuCategory>() {
        @Override
        public MenuCategory createFromParcel(Parcel source) {
            return new MenuCategory(source);
        }

        @Override
        public MenuCategory[] newArray(int size) {
            return new MenuCategory[size];
        }
    };
}
