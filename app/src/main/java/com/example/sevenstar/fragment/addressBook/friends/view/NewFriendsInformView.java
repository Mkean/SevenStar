package com.example.sevenstar.fragment.addressBook.friends.view;

import com.example.sevenstar.fragment.addressBook.friends.bean.FriendsBean;
import com.example.sevenstar.fragment.addressBook.friends.bean.NewFriendInformBean;
import com.example.sevenstar.view.IView;

/**
 * Created by j on 18.2.27.
 */

public interface NewFriendsInformView extends IView{
    void newFriendsInformSuccess(NewFriendInformBean bean);

    void newFriendsInformFailed(Throwable e);
}
