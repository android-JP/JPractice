package com.androidjp.app.utils;

import android.widget.Toast;

import com.androidjp.app.MyAppl;


/**
 * Created by JP on 2016/3/20.
 */
public class ToastUtil {

    public static void showShort(String msg){
        Toast.makeText(MyAppl.getContext(),msg,Toast.LENGTH_SHORT).show();
    }

    public static void showLong(String msg){
        Toast.makeText(MyAppl.getContext(),msg,Toast.LENGTH_LONG).show();
    }
}
