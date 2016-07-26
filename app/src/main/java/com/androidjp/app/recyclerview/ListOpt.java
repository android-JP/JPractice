package com.androidjp.app.recyclerview;

import java.util.List;

/**
 * Created by androidjp on 16-7-24.
 */
public interface ListOpt<T> {

    public void initList(List<T> list);
    public void addItem(T item);
    public void deleteItem(T item);

}
