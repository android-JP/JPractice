package com.androidjp.app.hidecall;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.androidjp.lib_four_components.services.LogService;

/**
 * 测试隐式调用
 * Created by androidjp on 16-7-4.
 */
public class HideCallService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


//    @Override
//    public void onCreate() {
//        super.onCreate();
//        Toast.makeText(this, "服务被创建", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onStart(Intent intent, int startId) {
//        super.onStart(intent, startId);
//        Toast.makeText(this, "服务:onStart()", Toast.LENGTH_SHORT).show();
//    }
//
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
}
