package com.example.moudlea.mvp;

import com.example.baselibrary.mvp.BaseFragmentPresenter;
import com.example.baselibrary.mvp.BasePresenter;
import com.example.baselibrary.mvp.BaseView;

public interface AContract {
    interface View extends BaseView {
        void show(String msg);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, AModel> {
        public abstract void load();
    }
}
