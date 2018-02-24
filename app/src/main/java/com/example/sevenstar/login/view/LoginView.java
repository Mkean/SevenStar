package com.example.sevenstar.login.view;

import com.example.sevenstar.login.bean.LoginBean;
import com.example.sevenstar.view.IView;

/**
 * Created by 子非鱼 on 2018/2/24.
 */

public interface LoginView extends IView {
    void LoginSuccess(LoginBean loginBean);

    void LoginFailed(Throwable e);
}
