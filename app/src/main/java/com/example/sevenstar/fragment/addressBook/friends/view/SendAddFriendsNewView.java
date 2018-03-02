package com.example.sevenstar.fragment.addressBook.friends.view;

import com.example.sevenstar.fragment.addressBook.friends.bean.SelectFriendsBean;
import com.example.sevenstar.fragment.addressBook.friends.bean.SendAddFriendsNewsBean;
import com.example.sevenstar.view.IView;

/**
 * Created by j on 18.3.1.
 */

public interface SendAddFriendsNewView extends IView{
    void  sendAddFriendsNewsSuccess(SendAddFriendsNewsBean friendsBean);

    void sendAddFriendsNewsFailed(Throwable e);
}
