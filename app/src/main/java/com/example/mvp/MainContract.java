package com.example.mvp;

import com.xiao360.baselibrary.base.BaseActivityPresenter;
import com.xiao360.baselibrary.mvp.BaseView;

public interface MainContract {
    interface View extends BaseView {
        void show(String msg);
    }

    abstract class Presenter extends BaseActivityPresenter<View, MainModel> {
        public abstract void load();
    }
}
