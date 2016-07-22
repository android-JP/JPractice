package com.androidjp.app.actionbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.androidjp.app.R;
import com.androidjp.app.themetest.DarkActivity;
import com.androidjp.app.themetest.LightActivity;


public class MyActionbarActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_actionbar);

        initView();
    }

    private void initView() {

            LinearLayout mainLayout = (LinearLayout) findViewById(R.id.layout_main);

            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


            Button btn1 = new Button(this);
            btn1.setTag(1001);
            btn1.setText("Light主题的AppCompatActivity");
            btn1.setLayoutParams(layoutParams);
            btn1.setPadding(10,10,10,10);
            btn1.setOnClickListener(this);

            Button btn2 = new Button(this);
            btn2.setTag(1002);
            btn2.setText("Dark主题的ActiionBarActivity");
            btn2.setLayoutParams(layoutParams);
            btn2.setPadding(10,10,10,10);
            btn2.setOnClickListener(this);

            Button btn3 = new Button(this);
            btn3.setTag(1003);
            btn3.setText("自定义ActionBar样式");
            btn3.setLayoutParams(layoutParams);
            btn3.setPadding(10,10,10,10);
            btn3.setOnClickListener(this);


            mainLayout.addView(btn1);
            mainLayout.addView(btn2);
            mainLayout.addView(btn3);

    }


    @Override
    public void onClick(View view) {
        switch ((Integer)view.getTag()){
            case 1001:
                startActivity(new Intent(this, LightActivity.class));
                break;
            case 1002:
                startActivity(new Intent(this, DarkActivity.class));
                break;
            case 1003:
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
}
