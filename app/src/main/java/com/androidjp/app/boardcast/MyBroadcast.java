package com.androidjp.app.boardcast;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.androidjp.app.R;
import com.androidjp.lib_four_components.boardcasts.LogBroadcast;

/**
 * Created by androidjp on 16-7-19.
 */
public class MyBroadcast extends LogBroadcast{

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        String action1 = R.string.action_head+"111";
        String action2 = "111";
        if (action1.equals(intent.getAction())){
            Log.d(getTag(),"我收到广播了");
        }else if (action2.equals(intent.getAction())){
            Log.d(getTag(),"其他广播");
        }


    }



}
