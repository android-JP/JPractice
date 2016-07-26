package com.androidjp.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidjp.app.R;
import com.androidjp.lib_four_components.fragments.LogFragment;

/**
 * Created by androidjp on 16-7-25.
 */
public class MyFragmentB extends LogFragment{


    public MyFragmentB() {
        Log.e("MyFragmentB","构造方法");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(tag(),"onCreateView()");
        return inflater.inflate(R.layout.fragment_test2, container,false);
    }
}
