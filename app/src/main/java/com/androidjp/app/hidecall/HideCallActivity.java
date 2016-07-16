package com.androidjp.app.hidecall;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.androidjp.app.MainActivity;
import com.androidjp.app.R;
import com.androidjp.lib_four_components.activities.LogActivity;

/**
 * 测试隐式调用
 * 测试BaseActivity
 * Created by androidjp on 16-7-4.
 */
public class HideCallActivity extends LogActivity{



    @Override
    protected String getTag() {
        return HideCallActivity.class.getSimpleName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        this.setCanceledCallback(() -> {
            Toast.makeText(HideCallActivity.this,"He canceled!", Toast.LENGTH_SHORT).show();
        });
        this.setOkCallback(() -> {
            Toast.makeText(HideCallActivity.this,"He OK!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(MainActivity.ACTION_TEST);
        this.stopService(intent);

        setResult(RESULT_CANCELED);
    }
}
