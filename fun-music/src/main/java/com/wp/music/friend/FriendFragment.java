package com.wp.music.friend;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wp.base.BaseFragment;
import com.wp.base.util.LogUtil;
import com.wp.music.R;



public class FriendFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d("FriendFragment-onCreate");


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
        View view  = inflater.inflate(R.layout.fragment_friend,container,false);
        return view;
    }
}
