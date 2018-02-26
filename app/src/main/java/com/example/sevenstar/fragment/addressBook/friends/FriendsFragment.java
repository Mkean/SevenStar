package com.example.sevenstar.fragment.addressBook.friends;

import android.view.View;

import com.example.sevenstar.R;
import com.example.sevenstar.fragment.BaseFragment;
import com.example.sevenstar.fragment.addressBook.friends.bean.FriendsBean;
import com.example.sevenstar.fragment.addressBook.friends.presenter.FriendsPresenter;
import com.example.sevenstar.fragment.addressBook.friends.view.FriendsView;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.easeui.widget.EaseContactList;

import java.util.List;

/**
 * Created by j on 18.2.25.
 * 这是通讯录里的第2个Fragment我的好友
 */

public class FriendsFragment extends BaseFragment implements FriendsView {

    private EaseContactList mEaseList;
    private FriendsPresenter friendsPresenter;

    @Override
    public void initView(View view) {
        super.initView(view);
        mEaseList = view.findViewById(R.id.contact_list);
    }

    @Override
    public void initData() {
        super.initData();
        friendsPresenter = new FriendsPresenter(this);
        //初始化时需要传入联系人list
        List<EaseUser> contactList;
//        mEaseList.init();
        //刷新列表
        mEaseList.refresh();

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

    }

    @Override
    public void findFailed(Throwable e) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (friendsPresenter != null) {
            friendsPresenter.detach();
        }
    }
}