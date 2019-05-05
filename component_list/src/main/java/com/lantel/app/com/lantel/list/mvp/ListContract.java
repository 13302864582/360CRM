package com.lantel.app.com.lantel.list.mvp;

import com.xiao360.baselibrary.base.BaseActivityPresenter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface ListContract {
    interface View extends BaseView {
        void refreshListData(ArrayList<BaseModel> data);

        void loadMoreListData(ArrayList<BaseModel> data);

        void refreshTabData(ArrayList<BaseModel> data);

        void filterListData(CharSequence data);
    }

    abstract class Presenter extends BaseActivityPresenter<View, ListModel> {

    }
}
