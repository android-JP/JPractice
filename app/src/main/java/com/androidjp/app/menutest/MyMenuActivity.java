package com.androidjp.app.menutest;

import android.os.Bundle;

import com.androidjp.app.R;
import com.androidjp.lib_four_components.activities.MenuActivity;

/**
 * 测试各种Menu
 * Created by androidjp on 16-7-18.
 */
public class MyMenuActivity extends MenuActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_actionbar);
    }
}
