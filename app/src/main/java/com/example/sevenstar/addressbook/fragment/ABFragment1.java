package com.example.sevenstar.addressbook.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sevenstar.R;
import com.example.sevenstar.addressbook.adapter.MyPhoneAddressBookAdapter;

/**
 * Created by j on 18.2.25.
 * 这是通讯录里的第一个Fragment手机通讯录
 */

public class ABFragment1 extends Fragment{

    private View view;
    private RecyclerView recycleView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.ab_fragment1, null);

        initView();

        initData();

        return view;
    }

    private void initData() {
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recycleView.setAdapter(new MyPhoneAddressBookAdapter());
    }

    private void initView() {
        recycleView = view.findViewById(R.id.xrecyclerview);

    }
}
