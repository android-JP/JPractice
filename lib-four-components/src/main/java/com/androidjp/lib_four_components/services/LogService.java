package com.androidjp.lib_four_components.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * 基类Service
 * 功能：实现生命周期的基本log和toast输出
 * Created by androidjp on 16-7-1.
 */
public abstract class LogService extends Service{

    protected abstract String getTag();


    @Override
    public IBinder onBind(Intent intent) {
        String msg = String.format(">>服务%s:onBind,intent=%s", getTag(), intent);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Log.e(getTag(), msg);
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        String msg = String.format(">>服务%s:onUnbind,intent=%s", getTag(), intent);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Log.e(getTag(), msg);
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        String msg = String.format(">>服务%s:onCreate", getTag());
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Log.e(getTag(), msg);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        String msg = String.format(">>服务%s:onStart,intent=%s,startId=%s", getTag(), intent, startId);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Log.e(getTag(), msg);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String msg = String.format(">>服务%s:onStartCommand,intent=%s,flags=%s,startId=%s", getTag(), intent, flags, startId);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Log.e(getTag(), msg);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        String msg = String.format(">>服务%s:onDestroy", getTag());
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Log.e(getTag(), msg);
        super.onDestroy();
    }

    @Override
    public void onRebind(Intent intent) {
        String msg = String.format(">>服务%s:onRebind,intent=%s", getTag(), intent);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Log.e(getTag(), msg);
        super.onRebind(intent);
    }

}
