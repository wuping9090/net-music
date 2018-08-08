package com.wp.music.recommend;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wp.base.BaseFragment;
import com.wp.base.util.LogUtil;
import com.wp.music.R;

public class RecommendFragment extends BaseFragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d("RecommendFragment-onCreate");
    }

    public static RecommendFragment newInstance() {
        Bundle bundle = new Bundle();
        RecommendFragment recommendFragment = new RecommendFragment();
        recommendFragment.setArguments(bundle);
        return recommendFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
