package com.wuping.netmusic.music.friend;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wuping.netmusic.BaseFragment;
import com.wuping.netmusic.R;

public class FriendFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static FriendFragment newInstance(){
        Bundle bundle = new Bundle();
        FriendFragment friendFragment = new FriendFragment();
        friendFragment.setArguments(bundle);
        return friendFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_home_music_friend,container,false);
        return view;
    }
}
