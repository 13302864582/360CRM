package com.lantel.app.mvp;

import com.xiao360.baselibrary.base.BaseActivityPresenter;
import com.xiao360.baselibrary.mvp.BaseView;

public interface AppContract {
    interface View extends BaseView {

        void navigate(int action_page01);
    }

    abstract class Presenter extends BaseActivityPresenter<View, AppModel> {

    }
}
