package com.wp.music;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wp.base.BaseFragment;
import com.wp.base.util.LogUtil;
import com.wp.music.adapter.MyFragmentPagerAdapter;

public class MusicFragment extends BaseFragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d("MusicFragment-onCreate");
    }

    public static MusicFragment newInstance(){
        Bundle bundle = new Bundle();
        MusicFragment musicFragment = new MusicFragment();
        musicFragment.setArguments(bundle);
        return musicFragment;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_music,container,false);
        initView(view);
        initContent();
        return view;
    }

    private void initView(View root) {
        viewPager = root.findViewById(R.id.viewPager);
        tabLayout = root.findViewById(R.id.tabLayout);
    }

    private void initContent() {

        viewPager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

    }
}
