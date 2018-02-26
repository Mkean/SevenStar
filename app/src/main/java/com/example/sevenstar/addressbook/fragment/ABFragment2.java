package com.example.sevenstar.addressbook.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sevenstar.R;

/**
 * Created by j on 18.2.25.
 *  这是通讯录里的第2个Fragment我的好友
 */

public class ABFragment2 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.ab_fragment2, null);


        return view;
    }
}
