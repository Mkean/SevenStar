package com.example.sevenstar.api;

import com.example.sevenstar.constant.mConstant;
import com.example.sevenstar.login.bean.LoginBean;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 子非鱼 on 2018/2/24.
 */

public interface MyApi {
    @GET(mConstant.Login)
    Observable<LoginBean> login(@Query("phone") String phone, @Query("password") String password, @Query("vaildate") String vaildate);
}
