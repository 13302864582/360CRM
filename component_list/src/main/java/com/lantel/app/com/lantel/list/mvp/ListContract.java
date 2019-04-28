package com.lantel.app.com.lantel.list.mvp;

import com.xiao360.baselibrary.base.BaseActivityPresenter;
import com.xiao360.baselibrary.mvp.BaseView;

public interface ListContract {
    interface View extends BaseView {

    }

    abstract class Presenter extends BaseActivityPresenter<View, ListModel> {

    }
}
