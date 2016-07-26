package com.androidjp.app.recyclerview.viewholder;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidjp.app.R;
import com.androidjp.app.recyclerview.bean.Dog;
import com.androidjp.lib_custom_view.listview.rec.BaseViewHolder;
import com.androidjp.lib_custom_view.listview.rec.OnItemClickListener;

import butterknife.Bind;

/**
 * Created by androidjp on 16-7-24.
 */
public class DogViewHolder extends BaseViewHolder<Dog>{
    @Bind(R.id.container_cardview)
    CardView cardView;
    @Bind(R.id.tv_msg)
    TextView tvMsg;

    /**
     * 新的自定义的基类构造方法：
     *
     * @param context   ViewHolder所在上下文
     * @param root      依附的RecyclerView
     */
    public DogViewHolder(Context context, ViewGroup root) {
        super(context, root, R.layout.item_layout_dog);
    }

    @Override
    protected void bindData(Dog itemValue, int position, OnItemClickListener listener) {
        if (itemValue!=null)
            tvMsg.setText(itemValue.name);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener ==null)
                    return;
                listener.onItemClick(itemValue,v.getId(),position);
            }
        });
    }
}
