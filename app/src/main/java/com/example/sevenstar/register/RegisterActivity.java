package com.example.sevenstar.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sevenstar.R;
import com.example.sevenstar.activity.BaseActivity;

public class RegisterActivity extends BaseActivity {

    private TextView mTitleName;
    private EditText mEtUserName;
    private EditText mEtVerification;
    private Button mBtVerification;
    private EditText mEtPass;
    private EditText mEtPwd;
    private EditText mEtName;
    private EditText mEtEmail;
    private Button mBtRegister;

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
}
