package com.example.sevenstar.api;

import com.example.sevenstar.bean.SMSBean;
import com.example.sevenstar.constant.mConstant;
import com.example.sevenstar.forgetPassword.bean.ForgetBean;
import com.example.sevenstar.fragment.addressBook.friends.bean.FriendsBean;
import com.example.sevenstar.fragment.addressBook.friends.bean.NewFriendInformBean;
import com.example.sevenstar.login.bean.LoginBean;
import com.example.sevenstar.register.bean.RegisterBean;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
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
    @POST(mConstant.Register)
    Observable<RegisterBean> register(@Field("nickName") String nickName, @Field("email") String email
            , @Field("phone") String phone, @Field("password") String password, @Field("passwordTwo") String passwordTwo
            , @Field("check") String check);

    //发送验证码
    @GET(mConstant.SMS)
    Observable<SMSBean> SMS(@Query("phone") String phone, @Query("type") String type);

    //忘记密码（修改密码）
    @GET(mConstant.Forget)
    Observable<ForgetBean> forget(@Query("phone") String phone, @Query("check") String check, @Query("password") String password, @Query("passwordTwo") String passwordTwo);

    //查询好友列表
    @GET(mConstant.findFriends)
    Observable<FriendsBean> findFriends(@Header("sessionId") String sessionId, @Header("userId") String userId);

    //好友消息
    @GET(mConstant.NewFriendsInform)
    Observable<NewFriendInformBean> NewFriendsInfrom(@Header("sessionId") String sessionId, @Header("userId") String userId);


}
