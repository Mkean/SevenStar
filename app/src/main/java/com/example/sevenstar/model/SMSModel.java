package com.example.sevenstar.model;

import com.example.sevenstar.api.MyApi;
import com.example.sevenstar.bean.SMSBean;
import com.example.sevenstar.utils.RetrofitManager;

import io.reactivex.Observable;

/**
 * Created by 子非鱼 on 2018/2/24.
 */

public class SMSModel implements IModel {
    public Observable<SMSBean> SMS(String phone, String type) {
        MyApi myApi = RetrofitManager.getDefault().create(MyApi.class);
        return myApi.SMS(phone, type);
    }
}
