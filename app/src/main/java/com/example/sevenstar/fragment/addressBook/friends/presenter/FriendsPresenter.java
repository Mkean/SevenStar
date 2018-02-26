package com.example.sevenstar.fragment.addressBook.friends.presenter;

import com.example.sevenstar.fragment.addressBook.friends.bean.FriendsBean;
import com.example.sevenstar.fragment.addressBook.friends.model.FriendsModel;
import com.example.sevenstar.fragment.addressBook.friends.view.FriendsView;
import com.example.sevenstar.presenter.IPresenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 子非鱼 on 2018/2/26.
 */

public class FriendsPresenter extends IPresenter<FriendsView> {

    private FriendsModel model;

    public FriendsPresenter(FriendsView view) {
        super(view);
    }

    @Override
    protected void init() {
        model = new FriendsModel();
    }

    public void findFriends(String sessionId, String userId) {
        Observable<FriendsBean> friends = model.findFriends(sessionId, userId);
        friends.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FriendsBean>() {
                    @Override
                    public void accept(FriendsBean friendsBean) throws Exception {
                        view.get().findSuccess(friendsBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.get().findFailed(throwable);
                    }
                });
    }
}
