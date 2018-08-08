package com.wp.music.radio;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wp.base.BaseFragment;
import com.wp.base.util.LogUtil;
import com.wp.music.R;


public class RadioFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d("RadioFragment-onCreate");
    }

    public static RadioFragment newInstance(){
        Bundle bundle = new Bundle();
        RadioFragment radioFragment = new RadioFragment();
        radioFragment.setArguments(bundle);
        return radioFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_radio,container,false);
        return view;
    }
}
