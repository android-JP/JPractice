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
public class MyFragmentA extends LogFragment{


    public MyFragmentA() {
        Log.e("MyFragmentA","构造方法");
    }
    Button btnGoto;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(tag(),"onCreateView()");

        return inflater.inflate(R.layout.fragment_test, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnGoto = (Button) view.findViewById(R.id.btn_goto);
        btnGoto.setOnClickListener(v->{
            Log.d("MyFragmentA.btn","onClick()");
            getActivity().startActivityForResult(new Intent(getActivity(), Main2Activity.class),123);
        });
    }


}
