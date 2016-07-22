package com.androidjp.app.service;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import com.androidjp.app.R;
import com.androidjp.app.boardcast.MyBroadcast;
import com.androidjp.lib_four_components.services.LogService;

/**
 * Created by androidjp on 16-7-19.
 */
public class MyBroadcastService extends LogService{

    BroadcastReceiver receiver;

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        receiver = new MyBroadcast();

        IntentFilter filter = new IntentFilter();
        filter.addAction("111");
        filter.addAction(R.string.action_head+"111");
        registerReceiver(receiver,filter);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }
}
