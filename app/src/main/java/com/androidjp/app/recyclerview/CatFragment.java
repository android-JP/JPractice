package com.androidjp.app.recyclerview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Toast;

import com.androidjp.app.recyclerview.bean.Cat;
import com.androidjp.app.recyclerview.bean.Dog;
import com.androidjp.app.recyclerview.viewholder.CatViewHolder;
import com.androidjp.lib_custom_view.listview.rec.BaseRecAdapter;
import com.androidjp.lib_custom_view.listview.rec.BaseViewHolder;

import java.util.LinkedList;
import java.util.List;

/**
 * 猫的列表
 * Created by androidjp on 16-7-26.
 */
public class CatFragment extends RecListFragment<Cat> {
    @Override
    protected boolean initData() {
        List< Cat > catList = new LinkedList<>();
        for (int i=0;i<10;i++){
            catList.add(new Cat("小猫"+(i+1)));
        }
        if(getAdapter()!=null){
            getAdapter().setmOnItemClickListener(this);
            getAdapter().refreshData(catList);
        }
        return true;
    }

    @Override
    protected RecyclerView.LayoutManager onSetLayoutManager() {
        return new GridLayoutManager(getActivity(), 2);
    }

    @Override
    protected BaseRecAdapter<Cat> onSetAdapter() {
        return new BaseRecAdapter<Cat>() {
            @Override
            protected int onGetItemViewType(int position) {
                return 0;
            }

            @Override
            protected BaseViewHolder createViewHolder(Context context, ViewGroup parent, int type) {
                return new CatViewHolder(context,parent);
            }
        };
    }


    @Override
    public void onItemClick(Cat itemValue, int viewID, int position) {
        Toast.makeText(getActivity(),"我是"+itemValue.name+" 编号:"+ position, Toast.LENGTH_SHORT).show();

    }
}
