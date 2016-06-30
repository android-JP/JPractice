package com.androidjp.lib_event_link;

import android.support.annotation.NonNull;

/**
 * 事件协定接口
 * Created by androidjp on 16-6-30.
 */
public interface IEvent<T> {

    /**
     * 是否自己做 这件事？
     * @param obj 事件对象
     * @return true 表示自己做， false 表示自己不做，给别人做
     */
    public boolean onEvent(@NonNull T obj);

}
