package com.androidjp.lib_four_components.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidjp.lib_four_components.R;
import com.androidjp.lib_four_components.fragments.adapters.RecListAdapter;

/**
 * 用RecyclerView作为列表的Fragment
 * Created by androidjp on 16-7-7.
 */
public class RecListFragment extends Fragment{

    View rootLayout;
    RecyclerView mRecView;

    RecListAdapter mListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootLayout==null){
            rootLayout = inflater.inflate(R.layout.fragment_reclist,container);
            mRecView = (RecyclerView) rootLayout.findViewById(R.id.recview);
        }
        return rootLayout;

    }


    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        if (getActivity().getIntent()!=null){
            if (getActivity().getIntent().getIntExtra("list_type",RecListAdapter.ALMOST_TYPE.SHOUYE.ordinal())==RecListAdapter.ALMOST_TYPE.SHOUYE.ordinal()){
                LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
                llm.setOrientation(LinearLayoutManager.VERTICAL);
                mRecView.setLayoutManager(llm);
            }else{
                GridLayoutManager glm = new GridLayoutManager(view.getContext(),2);
                mRecView.setLayoutManager(glm);
            }
            mListAdapter = new RecListAdapter(getActivity(),getActivity().getIntent().getIntExtra("list_type",RecListAdapter.ALMOST_TYPE.SHOUYE.ordinal()));
            mRecView.setAdapter(mListAdapter);
        }
    }
}
