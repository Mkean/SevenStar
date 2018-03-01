package com.example.sevenstar.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.sevenstar.MainActivity;
import com.example.sevenstar.R;
import com.example.sevenstar.constant.APPConfig;
import com.example.sevenstar.login.LoginActivity;
import com.example.sevenstar.utils.SharedPreferencesUtils;

public class SplashActivity extends AppCompatActivity {
    private final Handler mShowHandler = new Handler();
    private final Runnable mShowRunnable = new Runnable() {
        @Override
        public void run() {
            show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setFullScreen(true);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        delayedShow(2000);
    }

    private void delayedShow(int i) {
        mShowHandler.postDelayed(mShowRunnable, i);
    }

    private void setFullScreen(boolean b) {
        if (b) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        } else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        }
    }

    private void show() {
        String username = (String) SharedPreferencesUtils.getParam(SplashActivity.this, APPConfig.USER_NAME, "");
        Log.e("TAG", username);
        if (username.equals("") || username.equals("null")) {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            intent.putExtra("userName", username);
            startActivity(intent);
        }

        finish();
    }
}
