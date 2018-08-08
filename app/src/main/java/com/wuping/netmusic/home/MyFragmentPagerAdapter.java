package com.wuping.netmusic.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wp.discover.DiscoverFragment;
import com.wp.music.MusicFragment;
import com.wp.video.VideoFragment;


public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return DiscoverFragment.newInstance();
            case 1:
                return MusicFragment.newInstance();
            case 2:
                return VideoFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

}
