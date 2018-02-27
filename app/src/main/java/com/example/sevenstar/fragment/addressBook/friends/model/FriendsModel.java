package com.example.sevenstar.fragment.addressBook.friends.model;

import com.example.sevenstar.api.MyApi;
import com.example.sevenstar.fragment.addressBook.friends.bean.FriendsBean;
import com.example.sevenstar.fragment.addressBook.friends.bean.NewFriendInformBean;
import com.example.sevenstar.model.IModel;
import com.example.sevenstar.utils.RetrofitManager;

import io.reactivex.Observable;

/**
 * Created by 子非鱼 on 2018/2/26.
 */

public class FriendsModel implements IModel {

    //获取好友列表
    public Observable<FriendsBean> findFriends(String sessionId, String userId) {
        MyApi myApi = RetrofitManager.getDefault().create(MyApi.class);
        return myApi.findFriends(sessionId, userId);
    }
    //获取新好友消息
    public Observable<NewFriendInformBean> NewFriendsInform(String sessionId, String userId) {
        MyApi myApi = RetrofitManager.getDefault().create(MyApi.class);
        return myApi.NewFriendsInfrom(sessionId, userId);
    }
}
