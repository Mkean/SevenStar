package com.example.sevenstar.forgetPassword.view;

import com.example.sevenstar.forgetPassword.bean.ForgetBean;
import com.example.sevenstar.view.IView;

/**
 * Created by 子非鱼 on 2018/2/24.
 */

public interface ForgetView extends IView {
    void forgetSuccess(ForgetBean forgetBean);

    void forgetFailed(Throwable e);
}
