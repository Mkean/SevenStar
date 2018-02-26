package com.example.sevenstar.view;

import com.example.sevenstar.bean.SMSBean;

/**
 * Created by 子非鱼 on 2018/2/24.
 */

public interface SMSView extends IView {
    void SMSSuccess(SMSBean smsBean);

    void SMSFailed(Throwable e);
}
