package com.wp.music.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wp.music.friend.FriendFragment;
import com.wp.music.radio.RadioFragment;
import com.wp.music.recommend.RecommendFragment;


public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return RecommendFragment.newInstance();
            case 1:
                return FriendFragment.newInstance();
            case 2:
                return RadioFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "推荐";
            case 1:
                return "朋友";
            case 2:
                return "电台";
            default:
                return "Net";
        }
    }
}
