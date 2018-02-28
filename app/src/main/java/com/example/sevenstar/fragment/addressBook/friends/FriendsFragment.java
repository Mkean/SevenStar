package com.example.sevenstar.fragment.addressBook.friends;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sevenstar.R;
import com.example.sevenstar.fragment.BaseFragment;
import com.example.sevenstar.fragment.addressBook.friends.bean.FriendsBean;
import com.example.sevenstar.fragment.addressBook.friends.presenter.FriendsPresenter;
import com.example.sevenstar.fragment.addressBook.friends.view.FriendsView;
import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.EaseUI;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.easeui.widget.EaseContactList;

import java.util.ArrayList;
import java.util.List;

import static com.hyphenate.easeui.utils.EaseUserUtils.getUserInfo;

/**
 * Created by j on 18.2.25.
 * 这是通讯录里的第2个Fragment我的好友
 */

public class FriendsFragment extends BaseFragment implements FriendsView {

    private EaseContactList mEaseList;
    private FriendsPresenter friendsPresenter;
    private boolean isPrepared;
    private EaseUI easeUI;

    @Override
    public void initView(View view) {
        super.initView(view);
        mEaseList = view.findViewById(R.id.contact_list);
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            onVisible();
        }
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
        friendsPresenter = new FriendsPresenter(this);
        friendsPresenter.findFriends(sessionId, userId);
    }

    @Override
    public void setListener() {
        super.setListener();
    }


    @Override
    protected int getLayout() {
        return R.layout.ab_fragment2;
    }

    @Override
    public void findSuccess(FriendsBean friendsBean) {
        if (friendsBean.getStatus().equals("0000")) {

            mEaseList.refresh();
        } else {
            $toast(friendsBean.getMessage());
        }
    }

    @Override
    public void findFailed(Throwable e) {
        $Log(e.getMessage());
        $toast("网络出错！");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (friendsPresenter != null) {
            friendsPresenter.detach();
        }
    }


}
