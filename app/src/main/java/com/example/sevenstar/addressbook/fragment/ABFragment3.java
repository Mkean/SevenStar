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
 *  这是通讯录里的第3个Fragment我的群组
 */

public class ABFragment3 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.ab_fragment3, null);


        return view;
    }
}
