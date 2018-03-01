package com.example.sevenstar.fragment.consult.model;

import com.example.sevenstar.api.MyApi;
import com.example.sevenstar.fragment.consult.bean.NewsTypeBean;
import com.example.sevenstar.model.IModel;
import com.example.sevenstar.utils.RetrofitManager;

import io.reactivex.Observable;

/**
 * Created by 子非鱼 on 2018/2/28.
 */

public class NewsTypeModel implements IModel {
    public Observable<NewsTypeBean> getNewsType() {
        MyApi myApi = RetrofitManager.getDefault().create(MyApi.class);
        return myApi.NewsType();
    }
}
