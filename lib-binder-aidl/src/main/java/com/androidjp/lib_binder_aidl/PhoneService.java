package com.androidjp.lib_binder_aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * 需要用到aidl，使用binder机制，调用系统的电话相关功能（自动挂电话）
 *
 * Created by androidjp on 16-7-15.
 */
public class PhoneService extends Service{

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();

    }
}
