package com.lantel.mine.mvp;

import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface MineContract {
    interface View extends BaseView {
        void notifyData(ArrayList<BaseModel> list);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, MineModel> {

    }
}
