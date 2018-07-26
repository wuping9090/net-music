package com.wuping.netmusic.data;

import com.wuping.netmusic.R;

import java.util.ArrayList;

public class LocalData {

    //banner图片
    public static ArrayList<Integer> getBannerImages(){
        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.banner1);
        images.add(R.drawable.banner2);
        images.add(R.drawable.banner3);
        images.add(R.drawable.banner4);
        images.add(R.drawable.banner5);
        return images;
    }
}
