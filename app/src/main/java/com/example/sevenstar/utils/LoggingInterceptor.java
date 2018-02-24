package com.example.sevenstar.utils;

import android.os.Build;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 作者：王庆
 * 时间：2018/1/19
 */

public class LoggingInterceptor implements Interceptor {
    private static final String UA = "User-Agent";

    //拦截的方法
    @Override
    public Response intercept(Chain chain) throws IOException {
        //获取到请求
        Request request = chain.request();
        Request ak = request.newBuilder()
                .addHeader("ak", "001002003")
                .build();
        return chain.proceed(ak);
    }

    private String makeUA() {
        String s = Build.BRAND + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE;
        return Build.BRAND + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE;
    }
}
