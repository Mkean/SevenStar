package com.example.sevenstar.fragment.addressBook.friends;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sevenstar.R;
import com.example.sevenstar.activity.BaseActivity;
/*
    李少奇
    18.2.27
    这是新朋友界面点击添加跳转过来的页面
 */
public class AddFriendsActivity extends BaseActivity implements View.OnClickListener{

    private ImageView back;
    private TextView titleName;
    private LinearLayout phoneAndqqq;

    @Override
    protected int getLayout() {
        return R.layout.activity_add_friends;
    }

    @Override
    public void initView() {
        super.initView();
        back = (ImageView) findViewById(R.id.back);
        titleName = (TextView) findViewById(R.id.title_name);
        phoneAndqqq = (LinearLayout) findViewById(R.id.phoneAndqq);
    }

    @Override
    public void initData() {
        super.initData();
        titleName.setText("添加");
        back.setVisibility(View.VISIBLE);
    }

    @Override
    public void setListener() {
        super.setListener();
        back.setOnClickListener(this);
        phoneAndqqq.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.back:
                this.finish();
                break;
            case R.id.phoneAndqq:
                $startActivity(SelectFriendsActivity.class);
                break;
        }
    }
}
