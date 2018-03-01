package com.example.sevenstar.fragment.consult.view;

import com.example.sevenstar.fragment.consult.bean.NewsTypeBean;
import com.example.sevenstar.view.IView;

/**
 * Created by 子非鱼 on 2018/2/28.
 */

public interface NewsTypeView extends IView {
    void getTypeSuccess(NewsTypeBean newsTypeBean);

    void getTypeFailed(Throwable e);
}
