package com.androidjp.lib_four_components.fragments.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidjp.lib_four_components.R;
import com.androidjp.lib_four_components.fragments.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by androidjp on 16-7-7.
 */
public class RecListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<Item> datas;
    private Activity mActivity;
    private int mType;

    public enum ALMOST_TYPE{
        SHOUYE, SHOUCANG
    }


    public enum ITEM_TYPE {
        BLUE_ITEM,
        YELLOW_ITEM
    }


    public RecListAdapter(Activity activity,int type) {
        this.mActivity = activity;
        this.mType = type;
        datas = new ArrayList<Item>();
    }

    //---------------------------------------------------------------
    //自定义方法
    //---------------------------------------------------------------

    public void setItems(ArrayList<Item> items) {
        datas = items;
        notifyDataSetChanged();
    }

    public void addItem(Item item) {
        datas.add(item);
        notifyItemInserted(datas.size() + 1);
    }

    public void removeItem(Item item) {
        datas.remove(item);
        notifyDataSetChanged();
    }


    //----------------------------------------------------------------
    //实现方法
    //----------------------------------------------------------------

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == ITEM_TYPE.BLUE_ITEM.ordinal()){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reclist_item,parent,false);
            return new RecViewHolder(view);
        }
        else{
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reclist_item,parent,false);
            return new RecViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof RecViewHolder){
            ((RecViewHolder)holder).bindTo(datas.get(position),0);
        }else if (holder instanceof RecViewHolder2){
            ((RecViewHolder2)holder).bindTo(datas.get(position),0);
        }
    }



    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (datas.get(position).name.equals("小明")){
            return ITEM_TYPE.YELLOW_ITEM.ordinal();
        }else {
            return ITEM_TYPE.BLUE_ITEM.ordinal();
        }
    }
}
