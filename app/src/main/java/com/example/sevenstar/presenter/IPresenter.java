package com.example.sevenstar.presenter;

import com.example.sevenstar.view.IView;

import java.lang.ref.WeakReference;

/**
 * Created by 子非鱼 on 2018/2/24.
 */

public abstract class IPresenter<T extends IView> {
    protected WeakReference<T> view;

    public IPresenter(T view) {
        this.view = new WeakReference<>(view);
        init();
    }

    protected abstract void init();

    public void detach() {
        if (view != null) {
            view.clear();
        }
    }
}
