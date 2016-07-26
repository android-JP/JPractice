package com.androidjp.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import com.androidjp.app.R;

/**
 * Created by androidjp on 16-7-25.
 */
public class FragActivity extends FragmentActivity {

    //    private FrameLayout rootLayout;
    MyFragmentA fragmentA;
    MyFragmentB fragmentB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Log.i("FragActivity", "onCreate()");
    }

    private void initFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        fragmentA = new MyFragmentA();
        fragmentA.getView().setBackgroundResource(android.R.color.holo_blue_light);
        fragmentB = new MyFragmentB();
//        fragmentA.getView().setBackgroundResource(android.R.color.holo_blue_light);
        ft.add(R.id.frame_root_fragment, fragmentB);
        ft.replace(R.id.frame_root_fragment, fragmentA);
        ft.addToBackStack("tag");
        ft.commit();

    }

    public void addFragment(View v) {
        fragmentA = new MyFragmentA();
//        fragmentA.getView().setBackgroundResource(android.R.color.holo_blue_light);
        fragmentB = new MyFragmentB();
//        onAddFragment(fragmentA);
//        onAddFragment(fragmentB);
        onAddFragments(new Fragment[]{
                fragmentA, fragmentB
        });
    }


    /***
     * 方式一：单个Fragment 做下记录到backStack
     *
     * @param baseFragment
     */
    public void onAddFragment(Fragment baseFragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_root_fragment, baseFragment, "tag1");
        ft.addToBackStack("tag1");
        ft.commit();
    }

    /**
     * 方式二：多个Fragment同时addToBackStack
     *
     * @param fragmentList
     */
    public void onAddFragments(Fragment[] fragmentList) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        int pos = 0;
        for (Fragment item : fragmentList) {
            pos += 1;
            ft.replace(R.id.frame_root_fragment, item, "tag" + pos);
            ft.addToBackStack("tag" + pos);
        }
        ft.commit();
    }

}
