package com.example.sevenstar.forgetPassword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sevenstar.R;
import com.example.sevenstar.activity.BaseActivity;
import com.example.sevenstar.bean.SMSBean;
import com.example.sevenstar.forgetPassword.bean.ForgetBean;
import com.example.sevenstar.forgetPassword.presenter.ForgetPresenter;
import com.example.sevenstar.forgetPassword.view.ForgetView;
import com.example.sevenstar.login.LoginActivity;
import com.example.sevenstar.presenter.SMSPresenter;
import com.example.sevenstar.view.SMSView;

public class ForgetActivity extends BaseActivity implements View.OnClickListener, SMSView, ForgetView {

    private Button mBtCheck;
    private Button mForget;
    private EditText mPass;
    private EditText mPwd;
    private EditText mCheck;
    private EditText mPhone;
    private TextView mTitleName;
    private SMSPresenter smsPresenter;
    private ForgetPresenter forgetPresenter;

    @Override
    public void initData() {
        super.initData();
        mTitleName.setText(R.string.forget_title_name);

        smsPresenter = new SMSPresenter(this);
        forgetPresenter = new ForgetPresenter(this);
    }

    @Override
    public void initView() {
        super.initView();
        mTitleName = (TextView) findViewById(R.id.title_name);
        mPhone = (EditText) findViewById(R.id.forget_et_userName);
        mCheck = (EditText) findViewById(R.id.forget_et_verification);
        mPass = (EditText) findViewById(R.id.forget_et_pass);
        mPwd = (EditText) findViewById(R.id.forget_et_pwd);
        mForget = (Button) findViewById(R.id.bt_forget);
        mBtCheck = (Button) findViewById(R.id.forget_bt_verification);

    }

    @Override
    public void setListener() {
        super.setListener();
        mBtCheck.setOnClickListener(this);
        mForget.setOnClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_forget;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_forget:
                setPassword();
                break;
            case R.id.forget_bt_verification:
                getCheckCode();
                break;
            default:
                break;
        }
    }

    private void getCheckCode() {
        String mPhone = this.mPhone.getText().toString();
        if (mPhone.equals("")) {
            $toast("请填写手机号！");
            return;
        }
        smsPresenter.SMS(mPhone, "2");
    }

    private void setPassword() {
        String mPhone = this.mPhone.getText().toString();
        String mCheck = this.mCheck.getText().toString();
        String mPass = this.mPass.getText().toString();
        String mPwd = this.mPwd.getText().toString();
        if (mPhone.equals("") || mCheck.equals("") || mPass.equals("") || mPwd.equals("")) {
            $toast("请填写完整！");
            return;
        }
        forgetPresenter.forget(mPhone, mCheck, mPass, mPwd);
    }

    @Override
    public void forgetSuccess(ForgetBean forgetBean) {
        if (forgetBean.getStatus().equals("0000")) {
            $toast("修改成功");
            $startActivity(LoginActivity.class);
        } else {
            $toast(forgetBean.getMessage());
        }
    }

    @Override
    public void forgetFailed(Throwable e) {
        $Log(e.getMessage());
        $toast("网络出错");
    }

    @Override
    public void SMSSuccess(SMSBean smsBean) {
        $toast(smsBean.getMessage());
    }

    @Override
    public void SMSFailed(Throwable e) {
        $Log(e.getMessage());
        $toast("网络出错");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (forgetPresenter != null) {
            forgetPresenter.detach();
        }
        if (smsPresenter != null) {
            smsPresenter.detach();
        }
    }
}
