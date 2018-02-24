package com.example.sevenstar.register.view;

import com.example.sevenstar.register.bean.RegisterBean;
import com.example.sevenstar.view.IView;

/**
 * Created by 子非鱼 on 2018/2/24.
 */

public interface RegisterView extends IView {
    void registerSuccess(RegisterBean registerBean);

    void registerFailed(Throwable e);
}
