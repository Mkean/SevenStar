package com.example.sevenstar.register.presenter;

import com.example.sevenstar.presenter.IPresenter;
import com.example.sevenstar.register.bean.RegisterBean;
import com.example.sevenstar.register.model.RegisterModel;
import com.example.sevenstar.register.view.RegisterView;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 子非鱼 on 2018/2/24.
 */

public class RegisterPresenter extends IPresenter<RegisterView> {

    private RegisterModel model;

    public RegisterPresenter(RegisterView view) {
        super(view);
    }

    @Override
    protected void init() {
        model = new RegisterModel();
    }

    public void register(String nickName, String email, String phone
            , String password, String passwordTwo, String check) {
        Observable<RegisterBean> register = model.register(nickName, email, phone, password, passwordTwo, check);
        register.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegisterBean>() {
                    @Override
                    public void accept(RegisterBean registerBean) throws Exception {
                        view.get().registerSuccess(registerBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.get().registerFailed(throwable);
                    }
                });
    }
}
