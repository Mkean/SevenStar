package com.example.sevenstar.fragment.addressBook.friends.presenter;

import com.example.sevenstar.fragment.addressBook.friends.bean.NewFriendInformBean;
import com.example.sevenstar.fragment.addressBook.friends.bean.SelectFriendsBean;
import com.example.sevenstar.fragment.addressBook.friends.model.FriendsModel;
import com.example.sevenstar.fragment.addressBook.friends.view.SelectFriendsView;
import com.example.sevenstar.presenter.IPresenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by j on 18.2.28.
 */

public class SelectFriendsPresenter extends IPresenter<SelectFriendsView>{

    private FriendsModel model;

    public SelectFriendsPresenter(SelectFriendsView view) {
        super(view);
    }

    @Override
    protected void init() {
        model = new FriendsModel();
    }

    public void selectFriends(String sessionId, String userId,String phone) {
        Observable<SelectFriendsBean> friends = model.SelectFriends(sessionId, userId,phone);
        friends.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SelectFriendsBean>() {
                    @Override
                    public void accept(SelectFriendsBean friendsBean) throws Exception {
                        view.get().SelectFriendsSuccess(friendsBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.get().SelectFriendsFailed(throwable);
                    }
                });
    }
}
