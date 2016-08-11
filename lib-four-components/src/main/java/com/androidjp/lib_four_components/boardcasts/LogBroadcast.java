package com.androidjp.lib_four_components.boardcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * 带Log的广播
 * Created by androidjp on 16-7-19.
 */
public class LogBroadcast extends BroadcastReceiver {

    ///控制是否输出Toast
    private static final boolean IS_TOAST = false;
    ///控制是否输出Log
    private static final boolean IS_LOG = true;

    protected String getTag(){
        return this.getClass().getName();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        onLog(context,"onReceive()");


    }


    private void onLog(Context context,String msg){
        if (IS_LOG){
            Log.e(getTag(), msg);
        }
        if (IS_TOAST){
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }




}
