package com.example.sevenstar.login.presenter;

import com.example.sevenstar.login.bean.LoginBean;
import com.example.sevenstar.login.model.LoginModel;
import com.example.sevenstar.login.view.LoginView;
import com.example.sevenstar.presenter.IPresenter;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 子非鱼 on 2018/2/24.
 */

public class LoginPresenter extends IPresenter<LoginView> {

    private LoginModel model;

    public LoginPresenter(LoginView view) {
        super(view);
    }

    @Override
    protected void init() {
        model = new LoginModel();
    }

    public void login(String phone, String password, String vaildate) {
        final Observable<LoginBean> login = model.login(phone, password, vaildate);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        view.get().LoginSuccess(loginBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.get().LoginFailed(throwable);
                    }
                });
    }
}
