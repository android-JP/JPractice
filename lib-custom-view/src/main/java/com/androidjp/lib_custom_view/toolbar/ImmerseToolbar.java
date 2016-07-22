package com.androidjp.lib_custom_view.toolbar;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

import com.androidjp.lib_custom_view.titlebar.ImmerseAdapter;

/**
 * Created by androidjp on 16-7-22.
 */
public class ImmerseToolbar extends Toolbar {

    public ImmerseToolbar(Context context) {
        this(context, null);
    }

    public ImmerseToolbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.toolbarStyle);
    }

    public ImmerseToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (context instanceof Activity){
            ImmerseAdapter.setImmerseStyle((Activity)context);
        }
    }
}
