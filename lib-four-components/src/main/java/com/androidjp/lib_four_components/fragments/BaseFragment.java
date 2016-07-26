package com.androidjp.lib_four_components.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * 用newInstance()函数对Fragment进行复用(同时可进行Activity与Fragment之间的数据传输)
 *
 * Created by androidjp on 16-7-25.
 */
public class BaseFragment extends LogFragment{

    public static final int REQUEST_DETAIL = 0x110;
    private String mArgument;

    public static final String ARGUMENT = "argument";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null)
            mArgument = bundle.getString(ARGUMENT);
    }


    /**
     * 传入需要的参数，设置给arguments
     * setArguments方法必须在fragment创建以后，添加给Activity前完成。千万不要，首先调用了add，然后设置arguments
     * @param argument
     * @return
     */
    public static BaseFragment newInstance(String argument){
        Bundle bundle = new Bundle();
        bundle.putString(ARGUMENT, argument);
        BaseFragment baseFragment = new BaseFragment();
        baseFragment.setArguments(bundle);
        return baseFragment;
    }


    /**
     * 另外，Fragment没有setResult()方法，所以需要引用到父Activity的setResult方法，如下：
     * getActivity().setResult(BaseFragment.REQUEST_DETAIL , intent);
     */



}
