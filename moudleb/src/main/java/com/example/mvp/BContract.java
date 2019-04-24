package com.example.mvp;

import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.mvp.BaseView;

public interface BContract {
    interface View extends BaseView {
        void show(String msg);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, BModel> {
        public abstract void load();
    }
}
