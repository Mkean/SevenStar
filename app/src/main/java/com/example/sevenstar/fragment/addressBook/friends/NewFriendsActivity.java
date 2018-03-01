package com.example.sevenstar.fragment.addressBook.friends;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sevenstar.R;
import com.example.sevenstar.activity.BaseActivity;
import com.example.sevenstar.fragment.adapter.NewFriendsInfromAdapter;
import com.example.sevenstar.fragment.addressBook.friends.bean.NewFriendInformBean;
import com.example.sevenstar.fragment.addressBook.friends.presenter.FriendsPresenter;
import com.example.sevenstar.fragment.addressBook.friends.presenter.NewFriendsInformPresenter;
import com.example.sevenstar.fragment.addressBook.friends.view.NewFriendsInformView;
import com.example.sevenstar.login.view.LoginView;

import java.util.List;

public class NewFriendsActivity extends BaseActivity implements View.OnClickListener,NewFriendsInformView{

    private RecyclerView recyclerView;
    private ImageView back;
    private TextView titleName;
    private TextView operation;
    private NewFriendsInformPresenter nFIPresenter;

    @Override
    protected int getLayout() {
        return R.layout.activity_new_friends;
    }

    @Override
    public void initView() {
        super.initView();
        //Persenter的对象
        nFIPresenter = new NewFriendsInformPresenter(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyerview);
        back = (ImageView) findViewById(R.id.back);
        titleName = (TextView) findViewById(R.id.title_name);
        operation = (TextView) findViewById(R.id.operation);
    }

    @Override
    public void initData() {
        super.initData();
        //设置标题头
        titleName.setText(R.string.addressbook_new_friends);
        back.setVisibility(View.VISIBLE);
        operation.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SharedPreferences parameter = getSharedPreferences("parameter", 0);
        String userId = parameter.getString("userId", "");
        String sessionId = parameter.getString("sessionId", "");
        nFIPresenter.newFriendsInform(sessionId,userId);
    }
    //点击事件监听
    @Override
    public void setListener() {
        super.setListener();
        back.setOnClickListener(this);
        operation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.back:
                //点击返回按钮销毁本页面
                this.finish();
                break;
            case R.id.operation:
                //跳转
                break;
        }
    }

    @Override
    public void newFriendsInformSuccess(NewFriendInformBean bean) {

        List<NewFriendInformBean.ResultBean> result = bean.getResult();

        recyclerView.setAdapter(new NewFriendsInfromAdapter(result,this));

    }

    @Override
    public void newFriendsInformFailed(Throwable e) {

    }
}
