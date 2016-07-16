package com.androidjp.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.androidjp.app.eventdispatch.EventDispatchActivity;
import com.androidjp.lib_custom_view.titlebar.ImmerseTitleBar;
import com.androidjp.lib_four_components.activities.CommonTabActivity;
import com.androidjp.lib_four_components.activities.LogActivity;
import com.androidjp.lib_four_components.fragments.adapters.RecListAdapter;

public class MainActivity extends LogActivity implements View.OnClickListener{

    private ImmerseTitleBar mTitleBar;
    private LinearLayout mainLayout;

    public static final String ACTION_TEST = "com.androidjp.app.ACTION_TEST";

    private static final String IMG_URL = "http://i2.piimg.com/567571/2131d5ca85123c1d.png";


    @Override
    protected String getTag() {
        return MainActivity.class.getSimpleName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test);

        setContentView(R.layout.activity_main);

        mTitleBar = (ImmerseTitleBar) findViewById(R.id.titlebar);
        mTitleBar.showView(ImmerseTitleBar.TitleBarItem.BTN_LEFT).showView(ImmerseTitleBar.TitleBarItem.TITLE).showView(ImmerseTitleBar.TitleBarItem.BTN_RIGHT);
        mTitleBar.setLeftBtnListener(() -> {
            Intent intent = new Intent();
            intent.setAction(ACTION_TEST);
            startActivityForResult(intent,0);
            startService(intent);
        });


        initView();

        this.setCanceledCallback(() -> {
            Toast.makeText(this,"He canceled!", Toast.LENGTH_SHORT).show();
        });
        this.setOkCallback(() -> {
            Toast.makeText(this,"He OK!", Toast.LENGTH_SHORT).show();
        });

    }

    private void initView() {

        mainLayout = (LinearLayout) findViewById(R.id.layout_main);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        Button btn1 = new Button(this);
        btn1.setTag(1001);
        btn1.setText("自定义事件分发顺序");
        btn1.setLayoutParams(layoutParams);
        btn1.setPadding(10,10,10,10);
        btn1.setOnClickListener(this);

        Button btn2 = new Button(this);
        btn2.setTag(1002);
        btn2.setText("测试RecyclerView");
        btn2.setLayoutParams(layoutParams);
        btn2.setPadding(10,10,10,10);
        btn2.setOnClickListener(this);


        mainLayout.addView(btn1);
        mainLayout.addView(btn2);



    }


    @Override
    public void onClick(View view) {
        switch (((Integer)view.getTag())){
            case 1001:
                startActivity(EventDispatchActivity.actionView(this, null));
                break;
            case 1002:
                startActivity(CommonTabActivity.actionView(this, RecListAdapter.ALMOST_TYPE.SHOUYE.ordinal()));
                break;
        }
    }
}
