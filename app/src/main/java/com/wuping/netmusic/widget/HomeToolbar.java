package com.wuping.netmusic.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.wuping.netmusic.R;

public class HomeToolbar extends Toolbar {
    private ImageView mNavigation;
    private ImageView mDiscover;
    private ImageView mMusic;
    private ImageView mVideo;
    private ImageView mSearch;
    private Drawable mNavigationIcon;
    private Drawable mDiscoverIcon;
    private Drawable mDiscoverSelectedIcon;
    private Drawable mMusicIcon;
    private Drawable mMusicSelectedIcon;
    private Drawable mVideoIcon;
    private Drawable mVideoSelectedIcon;
    private Drawable mSearchIcon;
    private View mChildView;
    private boolean discoverIsSelected = false;
    private boolean musicIsSelected = true;
    private boolean videoIsSelected = false;

    public HomeToolbar(Context context) {
        this(context, null);
    }

    public HomeToolbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @SuppressLint("RestrictedApi")
    public HomeToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs, R.styleable.HomeToolbar, defStyleAttr, 0);
        mNavigationIcon = a.getDrawable(R.styleable.HomeToolbar_leftButtonIcon);
        mDiscoverIcon = a.getDrawable(R.styleable.HomeToolbar_discoverIcon);
        mDiscoverSelectedIcon = a.getDrawable(R.styleable.HomeToolbar_discoverSelectedIcon);
        mMusicIcon = a.getDrawable(R.styleable.HomeToolbar_musicIcon);
        mMusicSelectedIcon = a.getDrawable(R.styleable.HomeToolbar_musicSelectedIcon);
        mVideoIcon = a.getDrawable(R.styleable.HomeToolbar_videoIcon);
        mVideoSelectedIcon = a.getDrawable(R.styleable.HomeToolbar_videoSelectedIcon);
        mSearchIcon = a.getDrawable(R.styleable.HomeToolbar_rightButtonIcon);
        a.recycle();

        initView();

        initListener();

    }

    private void initView() {
        setContentInsetsRelative(40, 40);
        if (mChildView == null) {
            mChildView = LayoutInflater.from(getContext()).inflate(R.layout.toolbar_home, null);
            mNavigation = mChildView.findViewById(R.id.navigation);
            mDiscover = mChildView.findViewById(R.id.discover);
            mMusic = mChildView.findViewById(R.id.music);
            mVideo = mChildView.findViewById(R.id.video);
            mSearch = mChildView.findViewById(R.id.search);

            addView(mChildView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            if (mNavigationIcon != null) {
                mNavigation.setImageDrawable(mNavigationIcon);
            }
            if (mDiscoverIcon != null) {
                mDiscover.setImageDrawable(mDiscoverIcon);
            }
            if (mMusicIcon != null) {
                mMusic.setImageDrawable(mMusicSelectedIcon);
            }
            if (mVideoIcon != null) {
                mVideo.setImageDrawable(mVideoIcon);
            }
            if (mSearchIcon != null) {
                mSearch.setImageDrawable(mSearchIcon);
            }
        }
    }

    private void initListener() {
        mNavigation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onLeftButtonClickListener != null) {
                    onLeftButtonClickListener.onClick();
                }
            }
        });
        mDiscover.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!discoverIsSelected) {
                    discoverIsSelected = true;
                    musicIsSelected = false;
                    videoIsSelected = false;
                    mDiscover.setImageDrawable(mDiscoverSelectedIcon);
                    mMusic.setImageDrawable(mMusicIcon);
                    mVideo.setImageDrawable(mVideoIcon);
                    if (onDisCoverClickListener != null) {
                        onDisCoverClickListener.onClick();
                    }
                }


            }
        });
        mMusic.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!musicIsSelected) {
                    discoverIsSelected = false;
                    musicIsSelected = true;
                    videoIsSelected = false;
                    mDiscover.setImageDrawable(mDiscoverIcon);
                    mMusic.setImageDrawable(mMusicSelectedIcon);
                    mVideo.setImageDrawable(mVideoIcon);
                    if (onMusicClickListener != null) {
                        onMusicClickListener.onClick();
                    }
                }


            }
        });
        mVideo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!videoIsSelected) {
                    discoverIsSelected = false;
                    musicIsSelected = false;
                    videoIsSelected = true;
                    mDiscover.setImageDrawable(mDiscoverIcon);
                    mMusic.setImageDrawable(mMusicIcon);
                    mVideo.setImageDrawable(mVideoSelectedIcon);
                    if (onVideoClickListener != null) {
                        onVideoClickListener.onClick();
                    }
                }


            }
        });
        mSearch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onRightButtonClickListener != null) {
                    onRightButtonClickListener.onClick();
                }
            }
        });
    }

    public interface OnLeftButtonClickListener {
        void onClick();
    }

    public interface OnRightButtonClickListener {
        void onClick();

    }

    public interface OnDisCoverClickListener {
        void onClick();
    }

    public interface OnMusicClickListener {
        void onClick();
    }

    public interface OnVideoClickListener {
        void onClick();
    }

    private OnLeftButtonClickListener onLeftButtonClickListener;
    private OnRightButtonClickListener onRightButtonClickListener;
    private OnDisCoverClickListener onDisCoverClickListener;
    private OnMusicClickListener onMusicClickListener;
    private OnVideoClickListener onVideoClickListener;


    public void setOnLeftButtonClickListener(OnLeftButtonClickListener listener) {
        onLeftButtonClickListener = listener;
    }

    public void setOnRightButtonClickListener(OnRightButtonClickListener listener) {
        onRightButtonClickListener = listener;
    }

    public void setOnDisCoverClickListener(OnDisCoverClickListener listener) {
        onDisCoverClickListener = listener;
    }

    public void setOnMusicClickListener(OnMusicClickListener listener) {
        onMusicClickListener = listener;
    }

    public void setOnVideoClickListener(OnVideoClickListener listener) {
        onVideoClickListener = listener;
    }


}
