package com.example.sevenstar.fragment.addressBook.friends;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.sevenstar.R;
import com.example.sevenstar.activity.BaseActivity;
import com.example.sevenstar.fragment.addressBook.friends.bean.SelectFriendsBean;
import com.example.sevenstar.fragment.addressBook.friends.bean.SendAddFriendsNewsBean;
import com.example.sevenstar.fragment.addressBook.friends.presenter.SelectFriendsPresenter;
import com.example.sevenstar.fragment.addressBook.friends.presenter.SendAddFriendsNewPresenter;
import com.example.sevenstar.fragment.addressBook.friends.view.SelectFriendsView;
import com.example.sevenstar.fragment.addressBook.friends.view.SendAddFriendsNewView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/*
    李少奇
    18.2.27
    这是查找好友页面
 */
public class SelectFriendsActivity extends BaseActivity implements SelectFriendsView,SendAddFriendsNewView{

    private EditText selectFriends;
    private SelectFriendsPresenter myPresenter;
    private ImageView headImg;
    private TextView phone,nickName,email;
    private LinearLayout ll1,ll2,ll3,ll4,ll5;
    private List<LinearLayout> linearLayouts;
    private Button addFriend,cancle;
    private SendAddFriendsNewPresenter mySendPresenter;
    private String userId;
    private String sessionId;

    @Override
    protected int getLayout() {
        return R.layout.activity_select_friends;
    }

    @Override
    public void initView() {
        super.initView();
        myPresenter = new SelectFriendsPresenter(this);
        mySendPresenter = new SendAddFriendsNewPresenter(this);
        selectFriends = (EditText) findViewById(R.id.edit_select_friends);
        //接口并未写头像接口不操作
        ll1 = (LinearLayout) findViewById(R.id.ll1);
        ll2 = (LinearLayout) findViewById(R.id.ll2);
        ll3 = (LinearLayout) findViewById(R.id.ll3);
        ll4 = (LinearLayout) findViewById(R.id.ll4);
        ll5 = (LinearLayout) findViewById(R.id.ll5);
        linearLayouts = new ArrayList<>();
        linearLayouts.add(ll1);
        linearLayouts.add(ll2);
        linearLayouts.add(ll3);
        linearLayouts.add(ll4);
        linearLayouts.add(ll5);

        addFriend = (Button) findViewById(R.id.add_friend);
        cancle = (Button) findViewById(R.id.cancle);
        headImg = (ImageView) findViewById(R.id.head_img);
        email = (TextView) findViewById(R.id.email);
        phone = (TextView) findViewById(R.id.phone);
        nickName = (TextView) findViewById(R.id.nick_name);

    }

    @Override
    public void initData() {
        super.initData();
        SharedPreferences parameter = getSharedPreferences("parameter", 0);
        final String userId = parameter.getString("userId", "");
        final String sessionId = parameter.getString("sessionId", "");
        showKeyboard();
        selectFriends.setImeOptions(EditorInfo.IME_ACTION_SEND);
        //设置EditText的回车监听事件
        selectFriends.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //这里注意要作判断处理，ActionDown、ActionUp都会回调到这里，不作处理的话就会调用两次
                if (KeyEvent.KEYCODE_ENTER == keyCode && KeyEvent.ACTION_DOWN == event.getAction()) {
                    //处理事件
                    //手机号
                    String phone = selectFriends.getText().toString();
                    myPresenter.selectFriends(sessionId,userId,phone);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void setListener() {
        super.setListener();
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectFriendsActivity.this.finish();
            }
        });
    }

    private void showKeyboard(){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(selectFriends, 0);
    }


    @Override
    public void SelectFriendsSuccess(SelectFriendsBean friendsBean) {
//        Log.e("TAG",friendsBean.getStatus()+"===="+friendsBean.getMessage());
        SelectFriendsBean.ResultBean result1 = friendsBean.getResult();
        if(result1==null){
            gone();
            $toast("未查询到好友");
        }else{
            visible();
            final SelectFriendsBean.ResultBean result = friendsBean.getResult();
            email.setText(result.getEmail()+"");
            phone.setText(result.getPhone()+"");
            nickName.setText(result.getNickName()+"");
            SharedPreferences parameter = getSharedPreferences("parameter", 0);
            userId = parameter.getString("userId", "");
            sessionId = parameter.getString("sessionId", "");
            addFriend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //点击发送添加好友请求
                    mySendPresenter.sendAddFriendsNews(sessionId, userId,result.getId()+"");
                }
            });

        }
    }

    @Override
    public void SelectFriendsFailed(Throwable e) {

    }

    public void gone(){
        for (int i = 0; i < linearLayouts.size(); i++){
            linearLayouts.get(i).setVisibility(View.GONE);
        }
    }

    public void visible(){
        for (int i = 0; i < linearLayouts.size(); i++){
            linearLayouts.get(i).setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void sendAddFriendsNewsSuccess(SendAddFriendsNewsBean friendsBean) {
        Toast.makeText(this, ""+friendsBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sendAddFriendsNewsFailed(Throwable e) {

    }
}
