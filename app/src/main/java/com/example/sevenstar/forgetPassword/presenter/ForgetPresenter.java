package com.example.sevenstar.forgetPassword.presenter;

import com.example.sevenstar.forgetPassword.bean.ForgetBean;
import com.example.sevenstar.forgetPassword.model.ForgetModel;
import com.example.sevenstar.forgetPassword.view.ForgetView;
import com.example.sevenstar.presenter.IPresenter;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 子非鱼 on 2018/2/24.
 */

public class ForgetPresenter extends IPresenter<ForgetView> {

    private ForgetModel model;

    public ForgetPresenter(ForgetView view) {
        super(view);
    }

    @Override
    protected void init() {
        model = new ForgetModel();
    }

    public void forget(String phone, String check, String password, String passwordTwo) {
        Observable<ForgetBean> forget = model.forget(phone, check, password, passwordTwo);
        forget.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ForgetBean>() {
                    @Override
                    public void accept(ForgetBean forgetBean) throws Exception {
                        view.get().forgetSuccess(forgetBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.get().forgetFailed(throwable);
                    }
                });
    }
}
