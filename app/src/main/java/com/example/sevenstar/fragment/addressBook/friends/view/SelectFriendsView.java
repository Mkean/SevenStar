package com.example.sevenstar.fragment.addressBook.friends.view;

import com.example.sevenstar.fragment.addressBook.friends.bean.FriendsBean;
import com.example.sevenstar.fragment.addressBook.friends.bean.SelectFriendsBean;
import com.example.sevenstar.view.IView;

/**
 * Created by 子非鱼 on 2018/2/26.
 */

public interface SelectFriendsView extends IView {
    void SelectFriendsSuccess(SelectFriendsBean friendsBean);

    void SelectFriendsFailed(Throwable e);
}
