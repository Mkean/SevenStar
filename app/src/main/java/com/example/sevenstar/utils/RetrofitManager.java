package com.example.sevenstar.utils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：王庆
 * 时间：2018/1/19
 */

public class RetrofitManager {
    public static final String DEFAULT_BASE_URL = "http://www.bwstudent.com/";
    private static Retrofit mRetrofit;
    private static RetrofitManager mRetrofitManager;

    //一种单例模式
    private static class SingleHolder {
        private static final RetrofitManager _instance = new RetrofitManager(DEFAULT_BASE_URL);
    }
    //使用默认的单例RetrofitManager，是默认的baseUrl
    public static RetrofitManager getDefault() {
        return SingleHolder._instance;
    }

    private RetrofitManager(String baseUrl) {
        mRetrofit = new Retrofit.Builder()
                .client(OkHttpUtils.getInstance())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }

    public static RetrofitManager getInstance(String baseUrl) {
            if (mRetrofitManager == null) {
                synchronized (RetrofitManager.class) {
                    mRetrofitManager = new RetrofitManager(baseUrl);
                }
            }
        return mRetrofitManager;
    }


    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }
}
