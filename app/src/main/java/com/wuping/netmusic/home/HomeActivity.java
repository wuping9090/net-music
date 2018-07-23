package com.wuping.netmusic.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ContainerDrawerItem;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.wuping.netmusic.BaseActivity;
import com.wuping.netmusic.R;
import com.wuping.netmusic.widget.HomeToolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    HomeToolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initToolbar();
        initDrawer();
        initContent();

    }

    private void initContent() {

        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initDrawer() {
        View view = LayoutInflater.from(this).inflate(R.layout.buttom_drawer, null, false);
        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.bg_draw_header)
                .addProfiles(
                        new ProfileDrawerItem().withName("Wu Ping").withEmail("wupingnine@gmail.com").withIcon(ContextCompat.getDrawable(this, R.drawable.profile))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();
        drawer = new DrawerBuilder().withActivity(this)
                .withAccountHeader(headerResult)
                .withSelectedItem(-1)
//                .withToolbar(null)
                .addDrawerItems(
                        new SecondaryDrawerItem().withSelectable(false).withName("我的消息").withIcon(ContextCompat.getDrawable(this, R.drawable.my_message)),
                        new SecondaryDrawerItem().withSelectable(false).withName("会员中心").withIcon(ContextCompat.getDrawable(this, R.drawable.vip_center)),
                        new SecondaryDrawerItem().withSelectable(false).withName("商城").withIcon(ContextCompat.getDrawable(this, R.drawable.shop)),
                        new SecondaryDrawerItem().withSelectable(false).withName("游戏推荐").withIcon(ContextCompat.getDrawable(this, R.drawable.game_recommend)),
                        new SecondaryDrawerItem().withSelectable(false).withName("在线听歌免流量").withIcon(ContextCompat.getDrawable(this, R.drawable.my_message)),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withSelectable(false).withName("我的好友").withIcon(ContextCompat.getDrawable(this, R.drawable.my_friends)),
                        new SecondaryDrawerItem().withSelectable(false).withName("附近的人").withIcon(ContextCompat.getDrawable(this, R.drawable.position)),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withSelectable(false).withName("个性换肤").withIcon(ContextCompat.getDrawable(this, R.drawable.my_message)),
                        new SecondaryDrawerItem().withSelectable(false).withName("听歌识曲").withIcon(ContextCompat.getDrawable(this, R.drawable.vip_center)),
                        new SecondaryDrawerItem().withSelectable(false).withName("定时停止播放").withIcon(ContextCompat.getDrawable(this, R.drawable.my_message)),
                        new SecondaryDrawerItem().withSelectable(false).withName("扫一扫").withIcon(ContextCompat.getDrawable(this, R.drawable.vip_center)),
                        new SecondaryDrawerItem().withSelectable(false).withName("音乐闹钟").withIcon(ContextCompat.getDrawable(this, R.drawable.my_message)),
                        new SecondaryDrawerItem().withSelectable(false).withName("驾驶模式").withIcon(ContextCompat.getDrawable(this, R.drawable.vip_center)),
                        new SecondaryDrawerItem().withSelectable(false).withName("音乐云盘").withIcon(ContextCompat.getDrawable(this, R.drawable.my_message)),
                        new SecondaryDrawerItem().withSelectable(false).withName("优惠券").withIcon(ContextCompat.getDrawable(this, R.drawable.vip_center))

                )
                .addStickyDrawerItems(new ContainerDrawerItem().withView(view).withDivider(false))
                .build();
    }

    private void initToolbar() {
        toolbar.setOnLeftButtonClickListener(new HomeToolbar.OnLeftButtonClickListener() {
            @Override
            public void onClick() {
                if (!drawer.isDrawerOpen()) {
                    drawer.openDrawer();
                }

            }
        });
        toolbar.setOnDisCoverClickListener(new HomeToolbar.OnDisCoverClickListener() {
            @Override
            public void onClick() {

            }
        });
        toolbar.setOnMusicClickListener(new HomeToolbar.OnMusicClickListener() {
            @Override
            public void onClick() {

            }
        });
        toolbar.setOnVideoClickListener(new HomeToolbar.OnVideoClickListener() {
            @Override
            public void onClick() {

            }
        });
        toolbar.setOnRightButtonClickListener(new HomeToolbar.OnRightButtonClickListener() {
            @Override
            public void onClick() {

            }
        });
    }


}
