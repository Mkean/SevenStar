package com.example.sevenstar.api;

import com.example.sevenstar.constant.mConstant;
import com.example.sevenstar.login.bean.LoginBean;
import com.example.sevenstar.register.bean.RegisterBean;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 子非鱼 on 2018/2/24.
 */

public interface MyApi {
    //登录
    @GET(mConstant.Login)
    Observable<LoginBean> login(@Query("phone") String phone, @Query("password") String password, @Query("vaildate") String vaildate);

    //注册
    @FormUrlEncoded
    @POST
    Observable<RegisterBean> register(@Field("nickName") String nickName, @Field("email") String email
            , @Field("phone") String phone, @Field("password") String password, @Field("passwordTwo") String passwordTwo
            , @Field("check") String check);
}
