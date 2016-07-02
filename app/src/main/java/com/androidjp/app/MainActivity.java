package com.androidjp.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androidjp.app.demo.EventDispatchActivity;
import com.androidjp.lib_custom_view.titlebar.ImmerseTitleBar;

public class MainActivity extends Activity implements View.OnClickListener{

    private ImmerseTitleBar mTitleBar;
    private Button mBtnEventDispatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mTitleBar = (ImmerseTitleBar) findViewById(R.id.titlebar);

        mTitleBar.showView(ImmerseTitleBar.TitleBarItem.ICON_LEFT).showView(ImmerseTitleBar.TitleBarItem.TITLE).showView(ImmerseTitleBar.TitleBarItem.BTN_RIGHT);

//        initView();
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
