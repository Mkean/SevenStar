package com.example.sevenstar.fragment.addressBook.contacts;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sevenstar.R;
import com.example.sevenstar.fragment.BaseFragment;

/**
 * Created by j on 18.2.25.
 * 这是通讯录里的第一个Fragment手机通讯录
 */

public class ContactsFragment extends BaseFragment {

    private boolean isPrepared;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            onVisible();
        }
    }

    @Override
    public void initView(View view) {
        super.initView(view);
    }

    @Override
    public void initData() {
        super.initData();
        isPrepared = true;
        onVisible();
    }

    @Override
    protected void onVisible() {
        if (!isPrepared || !isVisible) {
            return;
        }
        Bundle bundle = getArguments();
        String userId = bundle.getString("userId");
        String sessionId = bundle.getString("sessionId");
    }

    @Override
    public void setListener() {
        super.setListener();
    }


    @Override
    protected int getLayout() {
        return R.layout.ab_fragment1;
    }

}
