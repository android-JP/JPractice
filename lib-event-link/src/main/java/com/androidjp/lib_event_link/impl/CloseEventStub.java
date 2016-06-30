package com.androidjp.lib_event_link.impl;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.androidjp.lib_event_link.EventStub;
import com.androidjp.lib_event_link.IEvent;

/**
 * 处理最后一条消息的展示，以及，Activity的关闭
 * Created by androidjp on 16-6-30.
 */
public class CloseEventStub extends EventStub<View>{


    /**
     * @param mEventStub 下一级的事件接收者
     * @param viewStub   下一级被处理的对象
     */
    public CloseEventStub(IEvent mEventStub, View viewStub) {
        super(mEventStub, viewStub);
    }

    @Override
    protected boolean onEventImpl (@NonNull View obj) {

        if (obj.getVisibility() == View.GONE) {
            obj.setVisibility(View.VISIBLE);
            return true;
        }

        if (!isDestroyed(obj)){
            finish(obj);
            return true;
        }

        return false;
    }

    private void finish(View obj) {
        if (obj.getContext() instanceof Activity){
            ((Activity)obj.getContext()).finish();
        }
    }

    private boolean isDestroyed(View obj) {
        return false;
    }




}
