package com.example.sevenstar.fragment.userSelf;


import android.view.View;
import android.widget.TextView;

import com.example.sevenstar.R;
import com.example.sevenstar.fragment.BaseFragment;

/**
 * Created by j on 18.2.25.
 */

public class MyFragment extends BaseFragment {

    private TextView mTitleName;

    @Override
    public void initView(View view) {
        super.initView(view);
        mTitleName = (TextView) view.findViewById(R.id.title_name);
    }

    @Override
    public void initData() {
        super.initData();
        mTitleName.setText(R.string.self_title_name);
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
        return R.layout.my_fragment;
    }
}
