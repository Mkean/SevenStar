package com.example.sevenstar.fragment.scienceCircle;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sevenstar.MainActivity;
import com.example.sevenstar.R;
import com.example.sevenstar.fragment.BaseFragment;

/**
 * Created by j on 18.2.25.
 */

public class ScienceCircleFragment extends BaseFragment {

    private String userId;
    private String sessionId;
    private TextView mTitleName;

    @Override
    public void initView(View view) {
        super.initView(view);
        mTitleName = view.findViewById(R.id.title_name);

    }

    @Override
    public void initData() {
        super.initData();
        mTitleName.setText(R.string.science_title_name);
        SharedPreferences parameter = getContext().getSharedPreferences("parameter", 0);
        userId = parameter.getString("userId", "");
        sessionId = parameter.getString("sessionId", "");
    }

    @Override
    protected void onVisible() {

    }

    @Override
    public void setListener() {
        super.setListener();
    }

    @Override
    protected int getLayout() {
        return R.layout.science_sircle_fraent;
    }
}
