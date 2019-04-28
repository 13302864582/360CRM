package com.lantel.app.com.app.mvp;

import com.xiao360.baselibrary.base.BaseActivityPresenter;
import com.xiao360.baselibrary.mvp.BaseView;

public interface AppContract {
    interface View extends BaseView {

    }

    abstract class Presenter extends BaseActivityPresenter<View, AppModel> {

    }
}
