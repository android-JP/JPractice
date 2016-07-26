package com.androidjp.app.recyclerview.bean;

/**
 * Created by androidjp on 16-7-24.
 */
public class Dog {
    public String name;
    public int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "名字："+ name +", 年龄："+ age;
    }
}
