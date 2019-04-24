package com.lantel.Splash.mvp;

import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.List;

public interface SplashContract {
    interface View extends BaseView {
        void setData(List list);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, SplashModel> {

    }
}
