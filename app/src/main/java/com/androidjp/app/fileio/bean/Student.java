package com.androidjp.app.fileio.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * 测试：学生
 * Created by androidjp on 16-7-22.
 */
public class Student implements Parcelable,Serializable{

    private int id;
    private String name;
    private Address home;

    public Student(int id, String name, Address home) {
        this.id = id;
        this.name = name;
        this.home = home;
    }


    protected Student(Parcel in) {
        id = in.readInt();
        name = in.readString();
        home = in.readParcelable(Address.class.getClassLoader());
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeParcelable(home, flags);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{id:").append(id).append(",name:").append(name).append(",address:").append(home.toString()).append("}");
        return sb.toString();
    }
}
