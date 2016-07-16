package com.androidjp.lib_binder_aidl.db;

/**
 * 统一管理所有的数据库
 * Created by androidjp on 16-7-15.
 */
public enum DBEnum {
    PHONE("BINDER_DB");

    private String dbName;

    private DBEnum(String dbName){
        this.dbName = dbName;
    }

    @Override
    public String toString() {
        return this.name();
    }

    public String getDbName(){
        return this.dbName;
    }

}
