package com.example.sevenstar.fragment.addressBook.friends;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.sevenstar.R;
import com.example.sevenstar.activity.UserInfoActivity;
import com.example.sevenstar.fragment.BaseFragment;
import com.example.sevenstar.fragment.addressBook.friends.bean.FriendsBean;
import com.example.sevenstar.fragment.addressBook.friends.presenter.FriendsPresenter;
import com.example.sevenstar.fragment.addressBook.friends.view.FriendsView;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.easeui.ui.EaseContactListFragment;
import com.hyphenate.easeui.widget.EaseContactList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by j on 18.2.25.
 * 这是通讯录里的第2个Fragment我的好友
 */

public class FriendsFragment extends BaseFragment implements FriendsView {

    private FriendsPresenter friendsPresenter;
    private boolean isPrepared;
    private EaseContactListFragment contactListFragment;

    @Override
    public void initView(View view) {
        super.initView(view);
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

    private Map<String, EaseUser> getContactsMap(FriendsBean friendsBean) {
        Map<String, EaseUser> map = new HashMap<>();
        List<FriendsBean.ResultBean> list = friendsBean.getResult();
        if (list == null) {
            return null;
        } else {
            for (int i = 0; i < list.size(); i++) {
                EaseUser easeUser = new EaseUser(list.get(i).getPhone());
                easeUser.setAvatar(list.get(i).getImg());
                easeUser.setNickname(list.get(i).getPhone());
                easeUser.setNick(list.get(i).getNickName());
                map.put(String.valueOf(list.get(i).getId()), easeUser);
            }
        }
        return map;
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
            setEaseList(friendsBean);
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void setEaseList(FriendsBean friendsBean) {

        contactListFragment = new EaseContactListFragment();
        contactListFragment.hideTitleBar();
        contactListFragment.setContactsMap(getContactsMap(friendsBean));
        contactListFragment.setContactListItemClickListener(new EaseContactListFragment.EaseContactListItemClickListener() {
            @Override
            public void onListItemClicked(EaseUser user) {
                Bundle bundle = new Bundle();
                bundle.putInt(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_SINGLE);//聊天类型
                bundle.putString(EaseConstant.EXTRA_USER_ID, user.getUsername());//和谁聊天
                $startActivity(UserInfoActivity.class, bundle);
            }
        });

        getActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.contact_list, contactListFragment).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (friendsPresenter != null) {
            friendsPresenter.detach();
        }
    }


}
