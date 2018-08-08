package com.wp.discover;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wp.base.BaseFragment;


public class DiscoverFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static DiscoverFragment newInstance(){
        Bundle bundle = new Bundle();
        DiscoverFragment discoverFragment = new DiscoverFragment();
        discoverFragment.setArguments(bundle);
        return discoverFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_discover,container,false);
        return view;
    }
}
