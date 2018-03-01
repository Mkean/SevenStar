package com.example.sevenstar.fragment.consult;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sevenstar.R;
import com.example.sevenstar.fragment.BaseFragment;

/**
 * Created by 子非鱼 on 2018/2/28.
 */

@SuppressLint("ValidFragment")
public class NewsFragment extends BaseFragment {
    private String Content;
    private String id;
    private RecyclerView mLv;

    public NewsFragment() {
    }

    public NewsFragment(String content, String id) {
        Content = content;
        this.id = id;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        mLv = view.findViewById(R.id.consult_lv);
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void setListener() {
        super.setListener();
    }

    @Override
    protected void onVisible() {

    }

    @Override
    protected int getLayout() {
        return R.layout.news_fragment;
    }
}
