package com.androidjp.app.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidjp.app.R;
import com.androidjp.app.recyclerview.bean.Dog;
import com.androidjp.lib_custom_view.listview.rec.BaseRecAdapter;
import com.androidjp.lib_custom_view.listview.rec.OnItemClickListener;
import com.androidjp.lib_four_components.fragments.LogFragment;

import java.util.LinkedList;
import java.util.List;


/**
 * 用RecyclerView作为列表的Fragment
 * Created by androidjp on 16-7-7.
 */
public abstract class RecListFragment<V> extends LogFragment implements OnItemClickListener<V>{

    View rootLayout;
    RecyclerView mRecView;
    BaseRecAdapter mListAdapter;

    TextView tvEmpty;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(tag(),"onCreateView()");
        if (rootLayout == null) {
            rootLayout = inflater.inflate(R.layout.fragment_reclist, null);
            mRecView = (RecyclerView) rootLayout.findViewById(R.id.recview);
            tvEmpty = (TextView) rootLayout.findViewById(R.id.tv_emptylist);
            tvEmpty.setOnClickListener(v -> {
                if(initData()){
                    tvEmpty.setVisibility(View.GONE);
                }

            });
        }

        mRecView.setLayoutManager(onSetLayoutManager());

        return rootLayout;

    }


    protected abstract boolean initData();


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListAdapter = onSetAdapter();
        mRecView.setAdapter(mListAdapter);

    }


    public BaseRecAdapter getAdapter(){
        return this.mListAdapter;
    }

    //==========================================================================

    /**
     * 设置RecyclerView是整体列表布局形式
     *
     * @return LayoutManager对象（LinearLayoutManager、GridLayoutManager等）
     */
    protected abstract RecyclerView.LayoutManager onSetLayoutManager();


    /**
     * 设置RecyclerView的Adapter
     */
    protected abstract BaseRecAdapter<V> onSetAdapter();


}
