package com.androidjp.lib_four_components.fragments.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by androidjp on 16-7-7.
 */
public class RecViewHolder extends RecyclerView.ViewHolder{

    ///组件集合

    View itemView;

    //数据
    Object data;
    int type;


    public RecViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }



    public void bindTo(Object data, int type){
        this.data = data;
        this.type = type;
        //根据data的数据来赋值组件
        this.itemView.setBackgroundColor(Color.YELLOW);

        //（可选）根据传入的type不同，设置不同的组件内容（注意：这里只是组件内容，而不是更换这个View布局本身）

        ///为组件设置点击事件
    }


}
