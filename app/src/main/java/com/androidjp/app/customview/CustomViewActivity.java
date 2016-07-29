package com.androidjp.app.customview;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.androidjp.app.R;
import com.androidjp.lib_custom_view.edittext.JPwdInputView;
import com.androidjp.lib_four_components.activities.LogActivity;

/**
 * 自定义View 演示界面
 * Created by androidjp on 16-7-27.
 */
public class CustomViewActivity extends LogActivity{

    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customview);

        container = (LinearLayout) findViewById(R.id.container_customview);

        addView();
    }

    private void addView() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(10,10,10,10);
        JPwdInputView inputView1  = new JPwdInputView(this);
                inputView1.setBorderColor(R.color.colorAccent)
                .setStrokeWidth(6)
                .setRadiuSize(12)
                .setContentBlod(true)
                .setContentColor(R.color.red)
                .setJustNumber(true)
                .setContentPersentage(0.5f)
                .setInputCallback(result -> {
            Toast.makeText(CustomViewActivity.this , result, Toast.LENGTH_SHORT).show();
            inputView1.postDelayed(() -> inputView1.clearResult(),2000);
        });

        inputView1.setBackgroundColor(Color.YELLOW);

        container.addView(inputView1);

    }


}
