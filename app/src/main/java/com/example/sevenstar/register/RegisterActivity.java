package com.example.sevenstar.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sevenstar.MainActivity;
import com.example.sevenstar.R;
import com.example.sevenstar.activity.BaseActivity;
import com.example.sevenstar.bean.SMSBean;
import com.example.sevenstar.login.LoginActivity;
import com.example.sevenstar.presenter.SMSPresenter;
import com.example.sevenstar.register.bean.RegisterBean;
import com.example.sevenstar.register.presenter.RegisterPresenter;
import com.example.sevenstar.register.view.RegisterView;
import com.example.sevenstar.view.SMSView;

public class RegisterActivity extends BaseActivity implements View.OnClickListener, RegisterView, SMSView {

    private TextView mTitleName;
    private EditText mEtUserName;
    private EditText mEtVerification;
    private Button mBtVerification;
    private EditText mEtPass;
    private EditText mEtPwd;
    private EditText mEtName;
    private EditText mEtEmail;
    private Button mBtRegister;
    private RegisterPresenter registerPresenter;
    private SMSPresenter presenter;

    @Override
    public void initData() {
        super.initData();
        mTitleName.setText(R.string.register_title_name);
        registerPresenter = new RegisterPresenter(this);
        presenter = new SMSPresenter(this);
    }

    @Override
    public void setListener() {
        super.setListener();
        mBtVerification.setOnClickListener(this);
        mBtRegister.setOnClickListener(this);
    }

    @Override
    public void initView() {
        super.initView();
        mTitleName = (TextView) findViewById(R.id.title_name);
        mEtUserName = (EditText) findViewById(R.id.register_et_userName);
        mEtVerification = (EditText) findViewById(R.id.register_et_verification);
        mBtVerification = (Button) findViewById(R.id.register_bt_verification);
        mEtPass = (EditText) findViewById(R.id.register_et_pass);
        mEtPwd = (EditText) findViewById(R.id.register_et_pwd);
        mEtName = (EditText) findViewById(R.id.register_et_name);
        mEtEmail = (EditText) findViewById(R.id.register_et_email);
        mBtRegister = (Button) findViewById(R.id.bt_register);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_bt_verification:
                getVerificationCode();
                break;
            case R.id.bt_register:
                register();
                break;
            default:
                break;
        }
    }

    private void getVerificationCode() {
        String mUserName = mEtUserName.getText().toString();

        if (mUserName.equals("")) {
            $toast("请填写手机号！");
            return;
        }
        presenter.SMS(mUserName, "1");
    }

    private void register() {
        String mUserName = mEtUserName.getText().toString();
        String mVerification = mEtVerification.getText().toString();
        String mPass = mEtPass.getText().toString();
        String mPwd = mEtPwd.getText().toString();
        String mNickName = mEtName.getText().toString();
        String mEmail = mEtEmail.getText().toString();
        if (mUserName.equals("") || mVerification.equals("") || mPass.equals("") || mPwd.equals("") || mNickName.equals("") || mEmail.equals("")) {
            $toast("请检查是否填写完整！");
            return;
        }
        registerPresenter.register(mNickName, mEmail, mUserName, mPass, mPwd, mVerification);
    }

    @Override
    public void registerSuccess(RegisterBean registerBean) {
        if (registerBean.getStatus().equals("0000")) {
            $toast(registerBean.getMessage());
            $startActivity(LoginActivity.class);
        } else {
            $toast(registerBean.getMessage());
        }
    }

    @Override
    public void registerFailed(Throwable e) {
        $toast("网络错误");
        $Log(e.getMessage());
    }

    @Override
    public void SMSSuccess(SMSBean smsBean) {
        $toast(smsBean.getMessage());
    }

    @Override
    public void SMSFailed(Throwable e) {
        $toast("网络错误");
        $Log(e.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (registerPresenter != null) {
            registerPresenter.detach();
        }
        if (presenter != null) {
            presenter.detach();
        }
    }


}
