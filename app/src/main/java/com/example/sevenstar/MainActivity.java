package com.example.sevenstar;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.sevenstar.addressbook.fragment.AddressBookFragment;
import com.example.sevenstar.addressbook.fragment.MyFragment;
import com.example.sevenstar.addressbook.fragment.ScienceCircleFragment;
import com.example.sevenstar.addressbook.fragment.ConsultFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends FragmentActivity {

    private BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        bottomTabBar.init(getSupportFragmentManager())    //bottomTabBar是找到的控件的名字
                .setImgSize(50,50)
                .setFontSize(8)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("咨询", R.drawable.zx,ConsultFragment.class)
                .addTabItem("科技圈",R.drawable.kjq, ScienceCircleFragment.class)
                .addTabItem("通讯录",R.drawable.txl, AddressBookFragment.class)
                .addTabItem("我的",R.drawable.wode, MyFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }

    public void initView() {
        bottomTabBar = (BottomTabBar) findViewById(R.id.bottomTabBar);
    }


}
