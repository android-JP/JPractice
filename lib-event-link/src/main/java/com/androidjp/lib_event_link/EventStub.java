package com.androidjp.lib_event_link;

import android.support.annotation.NonNull;

import java.net.URLClassLoader;

/**
 * 对IEvent的初步实现
 * 事件传递的核心
 * Created by androidjp on 16-6-30.
 */
public abstract class EventStub<T> implements IEvent<T>{

    protected IEvent mEventStub;

    protected T viewStub;

    /**
     *
     * @param mEventStub 下一级的事件接收者
     * @param viewStub   下一级被处理的对象
     */
    public EventStub(IEvent mEventStub, T viewStub) {
        this.mEventStub = mEventStub;
        this.viewStub = viewStub;
    }


    @Override
    public boolean onEvent(@NonNull T obj) {
        boolean b = onEventImpl(obj);
        if (!b && mEventStub!=null){
            return mEventStub.onEvent(this.viewStub);///给下一个接收者
        }

        return b;
    }

    /**
     * 代表是否有消耗事件
     * @param obj 事件
     * @return 有没有消耗事件
     */
    protected abstract boolean onEventImpl(T obj);
}
