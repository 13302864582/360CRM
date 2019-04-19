package com.example.mvp;

import com.example.baselibrary.base.BaseActivityPresenter;
import com.example.baselibrary.mvp.BaseView;

public interface MainContract {
    interface View extends BaseView {
        void show(String msg);
    }

    abstract class Presenter extends BaseActivityPresenter<View, MainModel> {
        public abstract void load();
    }
}
