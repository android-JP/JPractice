package com.androidjp.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidjp.app.Main2Activity;
import com.androidjp.app.R;
import com.androidjp.lib_four_components.fragments.LogFragment;

/**
 * Created by androidjp on 16-7-25.
 */
public class MyFragmentB extends LogFragment{
    Button btnGoto;

    public MyFragmentB() {
        Log.e("MyFragmentB","构造方法");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(tag(),"onCreateView()");
        return inflater.inflate(R.layout.fragment_test2, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnGoto = (Button) view.findViewById(R.id.btn_goto2);
        btnGoto.setOnClickListener(v->{
            Log.d("MyFragmentB.btn","onClick()");
            startActivityForResult(new Intent(getActivity(), Main2Activity.class),123);
        });
    }

}
