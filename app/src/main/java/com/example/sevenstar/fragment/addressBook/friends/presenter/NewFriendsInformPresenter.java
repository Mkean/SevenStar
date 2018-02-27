package com.example.sevenstar.fragment.addressBook.friends.presenter;

import com.example.sevenstar.fragment.addressBook.friends.bean.FriendsBean;
import com.example.sevenstar.fragment.addressBook.friends.bean.NewFriendInformBean;
import com.example.sevenstar.fragment.addressBook.friends.model.FriendsModel;
import com.example.sevenstar.fragment.addressBook.friends.view.FriendsView;
import com.example.sevenstar.fragment.addressBook.friends.view.NewFriendsInformView;
import com.example.sevenstar.presenter.IPresenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 子非鱼 on 2018/2/26.
 */

public class NewFriendsInformPresenter extends IPresenter<NewFriendsInformView> {

    private FriendsModel model;

    public NewFriendsInformPresenter(NewFriendsInformView view) {
        super(view);
    }

    @Override
    protected void init() {
        model = new FriendsModel();
    }

    public void newFriendsInform(String sessionId, String userId) {
        Observable<NewFriendInformBean> friends = model.NewFriendsInform(sessionId, userId);
        friends.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NewFriendInformBean>() {
                    @Override
                    public void accept(NewFriendInformBean friendsBean) throws Exception {
                        view.get().newFriendsInformSuccess(friendsBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.get().newFriendsInformFailed(throwable);
                    }
                });
    }
}
