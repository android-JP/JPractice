package com.androidjp.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.androidjp.app.R;
import com.androidjp.lib_four_components.activities.LogFragmentActivity;

/**
 * Created by androidjp on 16-7-25.
 */
public class FragActivity extends LogFragmentActivity {

    //    private FrameLayout rootLayout;
    MyFragmentA fragmentA;
    MyFragmentB fragmentB;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);


//        fragmentA = new MyFragmentA();
//        getSupportFragmentManager().beginTransaction().add(R.id.frame_root_fragment,fragmentA);///执行代码①
//        getSupportFragmentManager().beginTransaction().add(R.id.frame_root_fragment,fragmentA).commit();//执行代码②
    }

    @Override
    protected void onStart() {
        super.onStart();
//        fragmentA.getView().setBackgroundResource(android.R.color.holo_blue_light);
    }

    public void addFragment(View v) {
        fragmentA = new MyFragmentA();
//        fragmentA.getView().setBackgroundResource(android.R.color.holo_blue_light);
        fragmentB = new MyFragmentB();
        //方式一：Transaction一对一加载Fragment的

        onAddFragment(fragmentA);
        onAddFragment(fragmentB);
        ///方式二：Transaction一对多加载Fragment列表
//        onAddFragments(new Fragment[]{
//                fragmentA, fragmentB
//        });
    }


    /***
     * 方式一：单个Fragment 做下记录到backStack
     *
     * @param baseFragment
     */
    public void onAddFragment(Fragment baseFragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_root_fragment, baseFragment, "tag");
        ft.addToBackStack("tag");
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (fragmentA!=null)
            fragmentA.onActivityResult(requestCode,resultCode,data);

        if (fragmentB!=null)
            fragmentB.onActivityResult(requestCode,resultCode,data);
    }
}
