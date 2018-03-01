package com.example.sevenstar.fragment.addressBook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sevenstar.R;
import com.example.sevenstar.custom.BanViewPager;
import com.example.sevenstar.fragment.BaseFragment;
import com.example.sevenstar.fragment.addressBook.contacts.ContactsFragment;
import com.example.sevenstar.fragment.addressBook.friends.FriendsFragment;
import com.example.sevenstar.fragment.addressBook.friends.bean.FriendsBean;
import com.example.sevenstar.fragment.addressBook.friends.presenter.FriendsPresenter;
import com.example.sevenstar.fragment.addressBook.friends.view.FriendsView;
import com.example.sevenstar.fragment.addressBook.group.GroupFragment;
import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.easeui.ui.EaseContactListFragment;
import com.hyphenate.exceptions.HyphenateException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by j on 18.2.24.
 */

public class AddressBookFragment extends BaseFragment {

    private boolean isPrepared;
    private TextView addressBookTitleName;
    private TabLayout tabLayout;
    private BanViewPager viewPager;
    ArrayList<Fragment> fragmentList;
    ArrayList<String> titleList;
    private LinearLayout neeFriend;
    private String userId;
    private String sessionId;
    private ContactsFragment contactsFragment;
    private FriendsFragment friendsFragment;
    private GroupFragment groupFragment;
    private FriendsPresenter friendsPresenter;


    @Override
    protected void onVisible() {
        if (!isPrepared || !isVisible) {
            return;
        }

    }

    private void initContent() {
        fragmentList = new ArrayList<Fragment>();
        contactsFragment = new ContactsFragment();
        friendsFragment = new FriendsFragment();
        groupFragment = new GroupFragment();
        fragmentList.add(contactsFragment);
        fragmentList.add(friendsFragment);
        fragmentList.add(groupFragment);
        titleList = new ArrayList<String>();
        titleList.add("手机通讯录");
        titleList.add("我的好友");
        titleList.add("我的群组");
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        isPrepared = true;
        addressBookTitleName = view.findViewById(R.id.title_name);
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewpager);
        neeFriend = view.findViewById(R.id.newfriend);
        //对tabBar的数据进行
        initContent();
    }

    @Override
    public void initData() {
        //设置标题头
        addressBookTitleName.setText(R.string.addressbook_title_name);
        //设置TabLayout
        MPagerAdapter mPagerAdapter = new MPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(mPagerAdapter);
        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.GRAVITY_CENTER);
        //让tabLayout和Viewpager关联;
        tabLayout.setupWithViewPager(viewPager);

        neeFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到新朋友界面
            }
        });

        SharedPreferences parameter = getContext().getSharedPreferences("parameter", 0);
        userId = parameter.getString("userId", "");
        sessionId = parameter.getString("sessionId", "");


    }


    @Override
    protected int getLayout() {
        return R.layout.address_book_fragment;
    }


    class MPagerAdapter extends FragmentPagerAdapter {

        public MPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            bundle.putString("userId", userId);
            bundle.putString("sessionId", sessionId);
            Fragment fragment = fragmentList.get(position);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        //需要重写个返回标题的方法;
        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }
}
