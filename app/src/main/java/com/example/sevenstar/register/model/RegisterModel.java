package com.example.sevenstar.register.model;

import com.example.sevenstar.api.MyApi;
import com.example.sevenstar.model.IModel;
import com.example.sevenstar.register.bean.RegisterBean;
import com.example.sevenstar.utils.RetrofitManager;

import io.reactivex.Observable;

/**
 * Created by 子非鱼 on 2018/2/24.
 */

public class RegisterModel implements IModel {
    public Observable<RegisterBean> register(String nickName, String email, String phone
            , String password, String passwordTwo, String check) {
        MyApi myApi = RetrofitManager.getDefault().create(MyApi.class);
        return myApi.register(nickName, email, phone, password, passwordTwo, check);
    }
}
