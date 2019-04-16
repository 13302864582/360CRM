package com.example.mvp;

import com.example.baselibrary.mvp.BaseFragmentPresenter;
import com.example.baselibrary.mvp.BasePresenter;
import com.example.baselibrary.mvp.BaseView;

public interface BContract {
    interface View extends BaseView {
        void show(String msg);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, BModel> {
        public abstract void load();
    }
}
