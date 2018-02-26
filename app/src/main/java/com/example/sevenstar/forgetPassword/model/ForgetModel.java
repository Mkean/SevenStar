package com.example.sevenstar.forgetPassword.model;

import com.example.sevenstar.api.MyApi;
import com.example.sevenstar.forgetPassword.bean.ForgetBean;
import com.example.sevenstar.model.IModel;
import com.example.sevenstar.utils.RetrofitManager;

import io.reactivex.Observable;

/**
 * Created by 子非鱼 on 2018/2/24.
 */

public class ForgetModel implements IModel {
    public Observable<ForgetBean> forget(String phone, String check, String password, String passwordTwo) {
        MyApi myApi = RetrofitManager.getDefault().create(MyApi.class);
        return myApi.forget(phone, check, password, passwordTwo);
    }
}
