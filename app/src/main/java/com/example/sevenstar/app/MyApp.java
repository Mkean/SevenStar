package com.example.sevenstar.app;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.multidex.MultiDex;
import android.widget.Toast;

import com.example.sevenstar.MainActivity;
import com.example.sevenstar.db.Constant;
import com.example.sevenstar.db.HxEaseuiHelper;
import com.hyphenate.EMConnectionListener;
import com.hyphenate.EMError;
import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.EaseUI;
import com.hyphenate.util.EMLog;

import java.util.Iterator;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by 子非鱼 on 2018/2/23.
 */

public class MyApp extends Application {
    private static MyApp instance;
    public static  boolean isLogin;

    @Override
    public void onCreate() {
        super.onCreate();
        EaseUI.getInstance().init(this, null);
        EMClient.getInstance().setDebugMode(true);
        initHuanXin();
    }

    public static MyApp getInstance() {
        return instance;
    }

    private void initHuanXin() {

        HxEaseuiHelper.getInstance().init(this);
        //设置全局监听
        setGlobalListeners();
    }

    private String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = this.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pID) {
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
                // Log.d("Process", "Error>> :"+ e.toString());
            }
        }
        return processName;
    }

    EMConnectionListener connectionListener;

    /**
     * 设置一个全局的监听
     */
    protected void setGlobalListeners() {


        // create the global connection listener
        connectionListener = new EMConnectionListener() {
            @Override
            public void onDisconnected(int error) {
                EMLog.d("global listener", "onDisconnect" + error);
                if (error == EMError.USER_REMOVED) {// 显示帐号已经被移除
                    onUserException(Constant.ACCOUNT_REMOVED);
                } else if (error == EMError.USER_LOGIN_ANOTHER_DEVICE) {// 显示帐号在其他设备登录
                    onUserException(Constant.ACCOUNT_CONFLICT);
                    EMClient.getInstance().logout(true);//退出登录
                    Toast.makeText(getApplicationContext(), "退出成功", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else if (error == EMError.SERVER_SERVICE_RESTRICTED) {//
                    onUserException(Constant.ACCOUNT_FORBIDDEN);
                }
            }

            @Override
            public void onConnected() {
                // in case group and contact were already synced, we supposed to notify sdk we are ready to receive the events

            }
        };

        //register connection listener
        EMClient.getInstance().addConnectionListener(connectionListener);
    }

    /**
     * user met some exception: conflict, removed or forbidden
     */
    protected void onUserException(String exception) {
        EMLog.e(TAG, "onUserException: " + exception);
        Toast.makeText(getApplicationContext(), exception, Toast.LENGTH_LONG).show();
//        Intent intent = new Intent(getBaseContext(), UserQrCodeActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.putExtra(exception, true);
//        this.startActivity(intent);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
