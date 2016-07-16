package com.androidjp.lib_four_components.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.androidjp.lib_four_components.R;
import com.androidjp.lib_four_components.fragments.EmptyFragment;

/**
 *
 * 默认使用Tablayout + recyclerView + cardView
 *
 * 构成的首页
 *
 * Created by androidjp on 16-7-7.
 */

public class CommonTabActivity extends FragmentActivity{


    PagerAdapter mPagerAdapter;
    ViewPager mViewPager;
    TabLayout mTabLayout;


    public static Intent actionView(Context context , int type){
        Intent intent = new Intent(context,CommonTabActivity.class);
        intent.putExtra("list_type", type);
        return intent;
    }

    private static  final String[] TITLES = {
            "首页","收藏"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commontab);

        initView();
    }

    private void initView() {


//        mTabLayout = (TabLayout) findViewById(R.id.tl_main);
        mViewPager = (ViewPager) findViewById(R.id.vp_main);

        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new EmptyFragment();
            }

            @Override
            public int getCount() {
                return TITLES.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return TITLES[position];
            }
        };

        mViewPager.setAdapter(mPagerAdapter);

//        mTabLayout.setupWithViewPager(mViewPager);

    }


}
