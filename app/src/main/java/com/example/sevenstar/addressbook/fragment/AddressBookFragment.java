package com.example.sevenstar.addressbook.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sevenstar.R;
import com.example.sevenstar.custom.BanViewPager;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by j on 18.2.24.
 */

public class AddressBookFragment extends Fragment {

    private View view;
    private TextView addressBookTitleName;
    private TabLayout tabLayout;
    private BanViewPager viewPager;
    ArrayList<Fragment> fragmentList;
    ArrayList<String> titleList;
    private LinearLayout neeFriend;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.address_book_fragment, null);
        //初始化View
        initView();
        //对tabBar的数据进行
        initContent();
        //对控件进行赋值
        initData();

        return view;
    }

    private void initContent() {
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new ABFragment1());
        fragmentList.add(new ABFragment2());
        fragmentList.add(new ABFragment3());
        titleList = new ArrayList<String>();
        titleList.add("手机通讯录");
        titleList.add("我的好友");
        titleList.add("我的群组");
    }

    private void initData() {
        //设置标题头
        addressBookTitleName.setText(R.string.addressbook_title_name);
        //设置TabLayout
        MPagerAdapter mPagerAdapter = new MPagerAdapter(getActivity().getSupportFragmentManager());
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

    }

    private void initView() {
        addressBookTitleName = view.findViewById(R.id.title_name);
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewpager);
        neeFriend = view.findViewById(R.id.newfriend);
    }

    class MPagerAdapter extends FragmentPagerAdapter {

        public MPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
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
