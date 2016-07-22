package com.androidjp.app.themetest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.androidjp.app.R;

/**
 * Android主题和style测试：暗色
 * Created by androidjp on 16-7-17.
 */
public class DarkActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_actionbar);
    }
}
