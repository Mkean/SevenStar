package com.example.sevenstar.fragment.consult;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.TextView;

import com.example.sevenstar.R;
import com.example.sevenstar.custom.BanViewPager;
import com.example.sevenstar.fragment.BaseFragment;
import com.example.sevenstar.fragment.consult.bean.NewsTypeBean;
import com.example.sevenstar.fragment.consult.presenter.NewsTypePresenter;
import com.example.sevenstar.fragment.consult.view.NewsTypeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j on 18.2.25.
 */

public class ConsultFragment extends BaseFragment implements NewsTypeView {

    private TabLayout mTabLayout;
    private TextView mAdd;
    private BanViewPager mViewPager;
    private NewsTypePresenter newsTypePresenter;
    private ArrayList<Fragment> fragmentList;
    private TextView mTitleName;

    @Override
    public void initView(View view) {
        super.initView(view);
        mTitleName = (TextView) view.findViewById(R.id.title_name);
        mTabLayout = (TabLayout) view.findViewById(R.id.consult_tabLayout);
        mAdd = (TextView) view.findViewById(R.id.consult_add);
        mViewPager = (BanViewPager) view.findViewById(R.id.consult_viewpager);
    }

    @Override
    public void initData() {
        super.initData();
        mTitleName.setText(R.string.consult_title_name);
        newsTypePresenter = new NewsTypePresenter(this);
        newsTypePresenter.getNewsType();
        fragmentList = new ArrayList<>();
    }

    @Override
    protected void onVisible() {

    }

    @Override
    public void setListener() {
        super.setListener();
    }

    @Override
    protected int getLayout() {
        return R.layout.consult_fragment;
    }

    @Override
    public void getTypeSuccess(NewsTypeBean newsTypeBean) {
        if (newsTypeBean.getStatus().equals("0000")) {
            if (newsTypeBean.getNewsTypes() != null) {
                for (int i = 0; i < newsTypeBean.getNewsTypes().size(); i++) {
                    fragmentList.add(new NewsFragment(newsTypeBean.getNewsTypes().get(i).getName(), newsTypeBean.getNewsTypes().get(i).getId()));
                }
                setAdapter(newsTypeBean.getNewsTypes());
            }
        } else {
            $toast(newsTypeBean.getMessage());
        }
    }

    private void setAdapter(final List<NewsTypeBean.NewsTypesBean> newsTypes) {
        mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return newsTypes != null ? newsTypes.size() : 0;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return newsTypes.get(position).getName();
            }

        });

        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void getTypeFailed(Throwable e) {
        $toast("网络出错");
        $Log(e.getMessage());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (newsTypePresenter != null) {
            newsTypePresenter.detach();
        }
    }
}
