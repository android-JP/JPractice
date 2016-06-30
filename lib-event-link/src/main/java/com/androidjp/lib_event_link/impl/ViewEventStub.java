package com.androidjp.lib_event_link.impl;

import android.support.annotation.NonNull;
import android.view.View;

import com.androidjp.lib_event_link.EventStub;
import com.androidjp.lib_event_link.IEvent;

/**
 * 对View的事件传递的具体实现类
 *
 * Created by androidjp on 16-6-30.
 */
public class ViewEventStub extends EventStub<View>{
    /**
     * @param mEventStub 下一级的事件接收者
     * @param viewStub   下一级被处理的对象
     */
    public ViewEventStub(IEvent mEventStub, View viewStub) {
        super(mEventStub, viewStub);
    }

    /**
     * 如果View当前可见，就返回true
     * @param obj 事件
     * @return
     */
    @Override
    protected boolean onEventImpl(@NonNull View obj) {
        if (obj.getVisibility() == View.VISIBLE)
        {
            obj.setVisibility(View.GONE);
            return true;
        }
        return false;
    }
}
