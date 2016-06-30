package com.androidjp.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androidjp.app.demo.EventDispatchActivity;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button mBtnEventDispatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mBtnEventDispatch = (Button) findViewById(R.id.btn_eventdispatch);
        mBtnEventDispatch.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.equals(mBtnEventDispatch)){
            startActivity(EventDispatchActivity.actionView(this, null));
        }
    }
}
