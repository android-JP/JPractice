package com.androidjp.app.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androidjp.app.R;
import com.androidjp.lib_event_link.EventStub;
import com.androidjp.lib_event_link.impl.AnimationLeftEventStub;
import com.androidjp.lib_event_link.impl.CloseEventStub;
import com.androidjp.lib_event_link.impl.ViewEventStub;

/**
 *
 * 自定义事件分发顺序（库：lib-event-link）
 * Created by androidjp on 16-6-30.
 */
public class EventDispatchActivity extends Activity {
    public static final String EXTRA_INTENT = "EXTRA_INTENT";

    View view1;
    View view2;
    View view3;
    View view4;
    View view5;
    Button btn;

    EventStub event;


    /**
     * Activity 启动Intent设置
     * @param context 启动方的上下文环境
     * @param activityIntent 额外意图
     * @return 返回一个封装好的意图
     */
    public static Intent actionView(Context context, Intent activityIntent) {
       if (activityIntent==null){
           return new Intent(context, EventDispatchActivity.class);
       }else{
           if (1 == 2){
               //如果要直接启动额外意图
               return activityIntent;
           }else{
               //将额外Intent进行嵌套 返回嵌套过后的Intent对象
               return new Intent(context,EventDispatchActivity.class)
               .putExtra(EXTRA_INTENT,activityIntent);
           }
       }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventdispatch);

        initView();

        initEvent();
    }

    private void initEvent() {
        event = new CloseEventStub(null,null);
        event = new AnimationLeftEventStub(event,view5);
        event = new AnimationLeftEventStub(event,view4);
        event = new ViewEventStub(event,view3);
        event = new ViewEventStub(event,view2);
    }

    private void initView() {
        view1 = findViewById(R.id.tv_1);
        view2 = findViewById(R.id.tv_2);
        view3 = findViewById(R.id.tv_3);
        view4 = findViewById(R.id.tv_4);
        view5 = findViewById(R.id.tv_5);
    }


    public void dispatch(View v){
        event.onEvent(view1);
    }
}
