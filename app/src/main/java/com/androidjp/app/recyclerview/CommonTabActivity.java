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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;


/**
 * 默认使用Tablayout + recyclerView + cardView
 * <p>
 * 构成的首页
 * <p>
 * Created by androidjp on 16-7-7.
 */

public class CommonTabActivity extends LogFragmentActivity {


    PagerAdapter mPagerAdapter;
    ViewPager mViewPager;
    TabLayout mTabLayout;

//    RecListFragment dogFragment;
//    RecListFragment catFragment;

    HashMap<String, RecListFragment> fragmentMap;


    private String[] titles = {
            "我的狗", "我的猫"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commontab);
        initView();

    }


    /***
     * 专属Fragment的配置工作
     */
    public void setFragmentParams(String[] titles, List<Class<? extends RecListFragment>> clazzList){
        if (titles==null || titles.length<=0 || clazzList==null || clazzList.size()!=titles.length)
            return;

        for (Class<?> clazz:clazzList){

        }

    }

    /**
     * 专属ViewPager的配置工作
     */
    private void resetView(){
        //TODO
    }


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
