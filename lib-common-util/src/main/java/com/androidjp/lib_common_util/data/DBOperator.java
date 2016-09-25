package com.androidjp.lib_common_util.data;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by androidjp on 16/9/25.
 */

public abstract class DBOperator {

    protected Context mContext;
    protected SQLiteDatabase db;


    public void craeteOrOpenDb(Context context, String path){
        this.db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.CREATE_IF_NECESSARY);
//        this.db = context.openOrCreateDatabase(path,Context.MODE_PRIVATE,null);
    }


    //增
    public abstract void insert(String key, Object value);

    //查
    public abstract Object query(String key);


}
