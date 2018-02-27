package com.example.sevenstar.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.sevenstar.MainActivity;
import com.example.sevenstar.R;
import com.example.sevenstar.activity.BaseActivity;
import com.example.sevenstar.forgetPassword.ForgetActivity;
import com.example.sevenstar.login.bean.LoginBean;
import com.example.sevenstar.login.presenter.LoginPresenter;
import com.example.sevenstar.login.view.LoginView;
import com.example.sevenstar.register.RegisterActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginView {

    public static final String IMG = "http://www.bwstudent.com/kjbd/user/getImgCheck?ak=1";
    private EditText et_userName;
    private EditText et_password;
    private EditText et_verification;
    private ImageView img_verification;
    private TextView bt_forgetPassword;
    private TextView bt_register;
    private Button bt_login;
    private TextView mTitleName;
    private LoginPresenter loginPresenter;

    @Override
    public void initData() {
        super.initData();
        loginPresenter = new LoginPresenter(this);
        mTitleName.setText(R.string.title_name);
        checkoutImg();
    }

    @Override
    public void setListener() {
        super.setListener();
        bt_register.setOnClickListener(this);
        bt_login.setOnClickListener(this);
        bt_forgetPassword.setOnClickListener(this);
        img_verification.setOnClickListener(this);
    }

    @Override
    public void initView() {
        super.initView();
        mTitleName = (TextView) findViewById(R.id.title_name);
        et_userName = (EditText) findViewById(R.id.login_et_userName);
        et_password = (EditText) findViewById(R.id.login_et_password);
        et_verification = (EditText) findViewById(R.id.login_et_verification);
        img_verification = (ImageView) findViewById(R.id.login_img_verification);
        bt_forgetPassword = (TextView) findViewById(R.id.login_bt_forgetPassword);
        bt_register = (TextView) findViewById(R.id.login_bt_register);
        bt_login = (Button) findViewById(R.id.bt_login);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_bt_forgetPassword:
                $startActivity(ForgetActivity.class);
                break;
            case R.id.login_bt_register:
                register();
                break;
            case R.id.bt_login:
                login();
                break;
            case R.id.login_img_verification:
                checkoutImg();
                break;
            default:
                break;
        }
    }

    private void checkoutImg() {
        Glide.with(this).load(IMG)
                //设置内存禁止内存缓存
                .skipMemoryCache(true)
                //禁止磁盘缓存
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(img_verification);
    }


    private void register() {
        $startActivity(RegisterActivity.class);
    }

    private void login() {
        String mUserName = et_userName.getText().toString();
        String mPassword = et_password.getText().toString();
        String mVerification = et_verification.getText().toString();
        if (mUserName.equals("") || mPassword.equals("") || mVerification.equals("")) {
            $toast("请检查是否填写完整！");
            return;
        }
        loginPresenter.login(mUserName, mPassword, mVerification);
    }

    @Override
    public void LoginSuccess(LoginBean loginBean) {
        if (loginBean.getStatus().equals("0000")) {
            $toast(loginBean.getMessage());
            Bundle bundle = new Bundle();
            bundle.putString("sessionId", loginBean.getResult().getSessionId());
            bundle.putString("userId", loginBean.getResult().getUserId());
            $startActivity(MainActivity.class, bundle);
            finish();
        } else {
            checkoutImg();
            $toast(loginBean.getMessage());
        }
    }

    @Override
    public void LoginFailed(Throwable e) {
        checkoutImg();
        $Log(e.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (loginPresenter != null) {
            loginPresenter.detach();
        }
    }
}
