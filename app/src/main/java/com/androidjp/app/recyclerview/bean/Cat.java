package com.androidjp.app.recyclerview.bean;

/**
 * Created by androidjp on 16-7-24.
 */
public class Cat {
    public String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
