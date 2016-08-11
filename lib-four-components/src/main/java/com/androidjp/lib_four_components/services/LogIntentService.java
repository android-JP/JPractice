package com.androidjp.lib_four_components.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * IntentService 相比于 Service:
 * 创建默认的工作线程，用于在应用的UI线程外执行传递个给onStartCommand()所有Intent
 * Created by androidjp on 16-7-30.
 */
public class LogIntentService extends IntentService{


    ///控制是否输出Toast
    private static final boolean IS_TOAST = false;
    ///控制是否输出Log
    private static final boolean IS_LOG = true;


    private String getTag(){
        return this.getClass().getName();
    }

    private void onLog(String msg){
        if (IS_LOG){
            Log.e(getTag(), msg);
        }
        if (IS_TOAST){
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public LogIntentService(String name) {
        super(name);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        onLog("onHandleIntent()");
    }
}
