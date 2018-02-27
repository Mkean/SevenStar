package com.example.sevenstar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by 子非鱼 on 2018/2/26.
 */

public abstract class BaseFragment extends Fragment {
    protected boolean isVisible;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        initView(view);
        initData();
        setListener();
        return view;

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
        }
    }

    protected abstract void onVisible();

    public void setListener() {

    }

    public void initData() {

    }

    public void initView(View view) {

    }

    protected abstract int getLayout();

    //不传值跳转
    public void $startActivity(Class<?> clazz) {
        $startActivity(clazz, null);
    }

    //传值跳转
    public void $startActivity(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(getContext(), clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    //toast
    public void $toast(CharSequence msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    //toast
    public void $toast(int resId) {
        Toast.makeText(getContext(), resId + "", Toast.LENGTH_SHORT).show();
    }

    //log
    protected void $Log(String msg) {
        Log.e(this.getClass().getName(), msg);
    }

}
