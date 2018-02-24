package com.example.sevenstar.login.model;

import com.example.sevenstar.api.MyApi;
import com.example.sevenstar.constant.mConstant;
import com.example.sevenstar.login.bean.LoginBean;
import com.example.sevenstar.model.IModel;
import com.example.sevenstar.utils.RetrofitManager;

import io.reactivex.Observable;

/**
 * Created by 子非鱼 on 2018/2/24.
 */

public class LoginModel implements IModel {
    public Observable<LoginBean> login(String phone, String password, String vaildate) {
        MyApi myApi = RetrofitManager.getDefault().create(MyApi.class);
        return myApi.login(phone, password, vaildate);
    }
}
