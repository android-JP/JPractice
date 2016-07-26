package com.androidjp.app.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Toast;

import com.androidjp.app.recyclerview.viewholder.DogViewHolder;
import com.androidjp.app.recyclerview.bean.Dog;
import com.androidjp.app.recyclerview.viewholder.OldDogViewHolder;
import com.androidjp.lib_custom_view.listview.rec.BaseRecAdapter;
import com.androidjp.lib_custom_view.listview.rec.BaseViewHolder;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 和狗有关的列表
 * Created by androidjp on 16-7-26.
 */
public class DogFragment extends RecListFragment<Dog> {




    @Override
    protected boolean initData() {
        List< Dog > dogList = new LinkedList<>();
        for (int i=0;i<10;i++){
            dogList.add(new Dog("小狗"+(i+1),(10+i)));
        }
        if(getAdapter()!=null){
            getAdapter().setmOnItemClickListener(this);
            getAdapter().refreshData(dogList);
        }
        return true;
    }

    @Override
    protected RecyclerView.LayoutManager onSetLayoutManager() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        return llm;
    }

    @Override
    protected BaseRecAdapter<Dog> onSetAdapter() {
        return new BaseRecAdapter<Dog>() {
            @Override
            protected int onGetItemViewType(int position) {
                if (getDataList().get(position).age > 15) {
                    return 1;
                }
                return 0;
            }

            @Override
            protected BaseViewHolder createViewHolder(Context context, ViewGroup parent, int type) {
                switch (type) {
                    case 0:
                    default:
                        return new DogViewHolder(context, parent);
                    case 1:
                        return new OldDogViewHolder(context, parent);
                }
            }
        };
    }


    @Override
    public void onItemClick(Dog itemValue, int viewID, int position) {
        Toast.makeText(getActivity(),"我是"+itemValue.name+" 编号:"+ position, Toast.LENGTH_SHORT).show();
    }
}
