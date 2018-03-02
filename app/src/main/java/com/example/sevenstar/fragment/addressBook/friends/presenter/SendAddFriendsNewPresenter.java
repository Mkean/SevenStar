package com.example.sevenstar.fragment.addressBook.friends.presenter;

import com.example.sevenstar.fragment.addressBook.friends.bean.FriendsBean;
import com.example.sevenstar.fragment.addressBook.friends.bean.SendAddFriendsNewsBean;
import com.example.sevenstar.fragment.addressBook.friends.model.FriendsModel;
import com.example.sevenstar.fragment.addressBook.friends.view.SendAddFriendsNewView;
import com.example.sevenstar.presenter.IPresenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by j on 18.3.1.
 */

public class SendAddFriendsNewPresenter extends IPresenter<SendAddFriendsNewView> {

    private FriendsModel model;

    public SendAddFriendsNewPresenter(SendAddFriendsNewView view) {
        super(view);
    }

    @Override
    protected void init() {
        model = new FriendsModel();
    }


    public void sendAddFriendsNews(String sessionId, String userId,String friendId) {
        Observable<SendAddFriendsNewsBean> friends = model.sendAddFriendsNews(sessionId, userId,friendId);
        friends.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SendAddFriendsNewsBean>() {
                    @Override
                    public void accept(SendAddFriendsNewsBean friendsBean) throws Exception {
                        view.get().sendAddFriendsNewsSuccess(friendsBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.get().sendAddFriendsNewsFailed(throwable);
                    }
                });
    }
}
