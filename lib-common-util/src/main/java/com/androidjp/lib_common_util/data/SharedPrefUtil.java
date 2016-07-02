package com.androidjp.lib_common_util.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.junpeng.jpserver.MyAppl;

/**
 * Created by JP on 2016/3/24.
 */
public class SharedPrefUtil {
    private static final String APP_PREFERENCES = "APP_PREFERENCES";

    private static SharedPreferences sharedPrefs;


    /**
     * 使用前必须初始化
     *
     * @param context
     */
    public static void initSharedPreferences(Context context) {
        if (sharedPrefs == null) {
            sharedPrefs = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        }
//        setMsgList(null);/*TODO：暂时每一次进入APP，清空文件中的我的消息列表*/
    }

    public static SharedPreferences getInstance() {
        if (sharedPrefs == null) {
            sharedPrefs = MyAppl.getInstance().getApplicationContext().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        }
        return sharedPrefs;
    }


}
