package com.wuping.netmusic.music.recommend;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wuping.netmusic.BaseFragment;
import com.wuping.netmusic.R;
import com.wuping.netmusic.data.LocalData;
import com.youth.banner.Banner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RecommendFragment extends BaseFragment {

    @BindView(R.id.r_banner)
    Banner banner;
    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        View view = inflater.inflate(R.layout.fragment_home_music_recommend, container, false);
        unbinder = ButterKnife.bind(this, view);
        initBanner();
        return view;
    }

    private void initBanner() {
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(LocalData.getBannerImages());
        banner.start();
    }

    @Override
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
