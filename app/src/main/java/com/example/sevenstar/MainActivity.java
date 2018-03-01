package com.example.sevenstar;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.sevenstar.activity.SplashActivity;
import com.example.sevenstar.app.MyApp;
import com.example.sevenstar.constant.APPConfig;
import com.example.sevenstar.fragment.addressBook.AddressBookFragment;
import com.example.sevenstar.fragment.scienceCircle.ScienceCircleFragment;

import com.example.sevenstar.fragment.userSelf.MyFragment;

import com.example.sevenstar.fragment.consult.ConsultFragment;

import com.example.sevenstar.login.LoginActivity;
import com.example.sevenstar.utils.SharedPreferencesUtils;
import com.hjm.bottomtabbar.BottomTabBar;
import com.hyphenate.chat.EMClient;

public class MainActivity extends FragmentActivity {

    private BottomTabBar bottomTabBar;
    private Bundle bundle;
    private RadioButton mBtConsult;
    private RadioButton mBtAddressBook;
    private RadioButton mBtUserSelf;
    private RadioButton mBtScienceCircle;
    private RadioGroup mRg;
    private FragmentManager manager;
    private ConsultFragment consultFragment;
    private ScienceCircleFragment scienceCircleFragment;
    private AddressBookFragment addressBookFragment;
    private MyFragment myFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (!MyApp.isLogin) {
//            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//            startActivity(intent);
//            finish();
//            return;
//        }
        setContentView(R.layout.activity_main);
        initView();
        initData();
        bottomTabBar.init(getSupportFragmentManager())    //bottomTabBar是找到的控件的名字
                .setImgSize(50, 50)
                .setFontSize(8)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("咨询", R.drawable.zx, ConsultFragment.class)
                .addTabItem("科技圈", R.drawable.kjq, ScienceCircleFragment.class)
                .addTabItem("通讯录", R.drawable.txl, AddressBookFragment.class)
                .addTabItem("我的", R.drawable.wode, MyFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                    }

                });
    }

    private void initData() {

        String userId = (String) SharedPreferencesUtils.getParam(MainActivity.this, APPConfig.USER_ID, "");
        String sessionId = (String) SharedPreferencesUtils.getParam(MainActivity.this, APPConfig.SESSION_ID, "");

        SharedPreferences preferences = getSharedPreferences("parameter", 0);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("userId", userId);
        edit.putString("sessionId", sessionId);
        edit.commit();



       /* //定义底部标签图片大小
        Drawable drawableSelf = getResources().getDrawable(R.drawable.wode);
        drawableSelf.setBounds(0, 0, 70, 70);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        mBtUserSelf.setCompoundDrawables(null, drawableSelf, null, null);//只放上面
        //定义底部标签图片大小
        Drawable drawableConsult = getResources().getDrawable(R.drawable.zx);
        drawableConsult.setBounds(0, 0, 50, 50);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        mBtConsult.setCompoundDrawables(null, drawableConsult, null, null);//只放上面
        //定义底部标签图片大小
        Drawable drawableScienceCircle = getResources().getDrawable(R.drawable.kjq);
        drawableScienceCircle.setBounds(0, 0, 50, 50);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        mBtScienceCircle.setCompoundDrawables(null, drawableScienceCircle, null, null);//只放上面
        //定义底部标签图片大小
        Drawable drawableAddressBook = getResources().getDrawable(R.drawable.txl);
        drawableAddressBook.setBounds(0, 0, 50, 50);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        mBtAddressBook.setCompoundDrawables(null, drawableAddressBook, null, null);//只放上面


        consultFragment = new ConsultFragment();
        scienceCircleFragment = new ScienceCircleFragment();
        addressBookFragment = new AddressBookFragment();
        myFragment = new MyFragment();
        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frame, consultFragment).commit();
*/
    }

    public void initView() {
       /* mRg = (RadioGroup) findViewById(R.id.rg);
        mBtConsult = (RadioButton) findViewById(R.id.bt_Consult);
        mBtAddressBook = (RadioButton) findViewById(R.id.bt_AddressBook);
        mBtUserSelf = (RadioButton) findViewById(R.id.bt_userSelf);
        mBtScienceCircle = (RadioButton) findViewById(R.id.bt_ScienceCircle);*/

        bottomTabBar = (BottomTabBar) findViewById(R.id.bottomTabBar);

    }


}
