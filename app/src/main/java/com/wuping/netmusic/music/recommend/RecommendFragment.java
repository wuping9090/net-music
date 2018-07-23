package com.wuping.netmusic.music.recommend;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wuping.netmusic.BaseFragment;
import com.wuping.netmusic.R;

public class RecommendFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static RecommendFragment newInstance(){
        Bundle bundle = new Bundle();
        RecommendFragment recommendFragment = new RecommendFragment();
        recommendFragment.setArguments(bundle);
        return recommendFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_home_music_recommend,container,false);
        return view;
    }
}
