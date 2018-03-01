package com.example.sevenstar.fragment.consult.presenter;

import com.example.sevenstar.fragment.consult.bean.NewsTypeBean;
import com.example.sevenstar.fragment.consult.model.NewsTypeModel;
import com.example.sevenstar.fragment.consult.view.NewsTypeView;
import com.example.sevenstar.presenter.IPresenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 子非鱼 on 2018/2/28.
 */

public class NewsTypePresenter extends IPresenter<NewsTypeView> {

    private NewsTypeModel model;

    public NewsTypePresenter(NewsTypeView view) {
        super(view);
    }

    @Override
    protected void init() {
        model = new NewsTypeModel();
    }

    public void getNewsType() {
        Observable<NewsTypeBean> newsType = model.getNewsType();
        newsType.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NewsTypeBean>() {
                    @Override
                    public void accept(NewsTypeBean newsTypeBean) throws Exception {
                        view.get().getTypeSuccess(newsTypeBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.get().getTypeFailed(throwable);
                    }
                });
    }
}
