package com.example.sevenstar.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by 子非鱼 on 2018/2/23.
 */

public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        initData();
        setListener();
    }

    //监听
    public void setListener() {

    }

    //初始化数据
    public void initData() {

    }

    //初始化控件
    public void initView() {
    }

    //布局文件
    protected abstract int getLayout();

    //不传值跳转
    public void $startActivity(Class<?> clazz) {
        $startActivity(clazz, null);
    }

    //传值跳转
    public void $startActivity(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    //toast
    public void $toast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    //toast
    public void $toast(int resId) {
        Toast.makeText(this, resId + "", Toast.LENGTH_SHORT).show();
    }

    //log
    protected void $Log(String msg) {
        Log.e(this.getClass().getName(), msg);
    }
}
