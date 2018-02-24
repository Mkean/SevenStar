package com.example.sevenstar.presenter;

import com.example.sevenstar.bean.SMSBean;
import com.example.sevenstar.model.SMSModel;
import com.example.sevenstar.view.SMSView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 子非鱼 on 2018/2/24.
 */

public class SMSPresenter extends IPresenter<SMSView> {

    private SMSModel model;

    public SMSPresenter(SMSView view) {
        super(view);
    }

    @Override
    protected void init() {
        model = new SMSModel();
    }

    public void SMS(String phone, String type) {
        final Observable<SMSBean> sms = model.SMS(phone, type);
        sms.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SMSBean>() {
                    @Override
                    public void accept(SMSBean smsBean) throws Exception {
                        view.get().SMSSuccess(smsBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.get().SMSFailed(throwable);
                    }
                });
    }
}
