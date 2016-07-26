package com.androidjp.app.fileio.bean;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试：地址
 * Created by androidjp on 16-7-22.
 */
public class Address implements Parcelable, Serializable {

    public String country;
    public String city;
    public String street;
    public Bundle bundle;
    public Serializable serializable;
    public Binder binder;
    public Integer i;
    public int j;
    public List<String> stringList;
    public List<Bundle> bundleList;
//    public List<Serializable> serializableList;
    public ArrayList<IBinder> binderList;
//    public List<Integer> integerList;
    public int[] ints;

    public Address(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }

    protected Address(Parcel in) {
        country = in.readString();
        city = in.readString();
        street = in.readString();
        bundle = in.readBundle();
        serializable = in.readSerializable();
        binder = (Binder) in.readStrongBinder();
        i = in.readInt();
        j = in.readInt();
        stringList = in.createStringArrayList();
        bundleList = in.createTypedArrayList(Bundle.CREATOR);
        binderList = in.createBinderArrayList();
        ints = in.createIntArray();
    }

    public static final Creator<Address> CREATOR = new Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(country);
        dest.writeString(city);
        dest.writeString(street);
        dest.writeBundle(bundle);
        dest.writeSerializable(serializable);
        dest.writeStrongBinder(binder);
        dest.writeInt(i);
        dest.writeInt(j);
        dest.writeStringList(stringList);
        dest.writeTypedList(bundleList);
        dest.writeBinderList(binderList);
        dest.writeIntArray(ints);
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append("{country:").append(country).append(",city:").append(city).append(",street:").append(street).append("}");
        return sb.toString();
    }
}
