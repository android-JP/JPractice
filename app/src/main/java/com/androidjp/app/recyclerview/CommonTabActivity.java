package com.androidjp.app.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.androidjp.app.Main2Activity;
import com.androidjp.app.R;
import com.androidjp.lib_custom_view.titlebar.ImmerseTitleBar;
import com.androidjp.lib_four_components.activities.LogFragmentActivity;

import java.util.HashMap;
import java.util.LinkedHashMap;


/**
 * 默认使用Tablayout + recyclerView + cardView
 * <p>
 * 构成的首页
 * <p>
 * Created by androidjp on 16-7-7.
 */

public class CommonTabActivity extends LogFragmentActivity {


    /**
     *  ViewPager的适配器
     */
    PagerAdapter mPagerAdapter;
    /**
     * ViewPager对象
     */
    ViewPager mViewPager;
    /**
     * Tablayout对象
     */
    TabLayout mTabLayout;
    /**
     * fragment集合Map对象（Title的名称为键）
     */
    HashMap<String, RecListFragment> fragmentMap;

    /**
     * title 数组
     */
    private String[] titles = {
            "我的狗", "我的猫"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commontab);
        initView();

    }

    /**
     * 初始化控件
     */
    private void initView() {
        ImmerseTitleBar titlebar = (ImmerseTitleBar) findViewById(R.id.titlebar);
        titlebar.setRightBtnText("跳转Activity").setRightBtnListener(() -> startActivity(new Intent(CommonTabActivity.this, Main2Activity.class)));

        fragmentMap = new LinkedHashMap<>();

        mTabLayout = (TabLayout) findViewById(R.id.tl_main);
        mViewPager = (ViewPager) findViewById(R.id.vp_main);

        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                    default:
                        if(!fragmentMap.containsKey(titles[0]))
                            fragmentMap.put(titles[0],new DogFragment());
                        return fragmentMap.get(titles[0]);
                    case 1:

                        if(!fragmentMap.containsKey(titles[1]))
                            fragmentMap.put(titles[1],new CatFragment());
                        return fragmentMap.get(titles[1]);
                }
            }

            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        };

        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }


}
