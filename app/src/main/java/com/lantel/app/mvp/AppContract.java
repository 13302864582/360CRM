package com.lantel.app.mvp;

import com.example.baselibrary.base.BaseActivityPresenter;
import com.example.baselibrary.mvp.BaseView;

public interface AppContract {
    interface View extends BaseView {

    }

    abstract class Presenter extends BaseActivityPresenter<View, AppModel> {

    }
}
