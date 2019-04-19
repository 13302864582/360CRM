package com.lantel.mine.mvp;

import com.example.baselibrary.base.BaseFragmentPresenter;
import com.example.baselibrary.mvp.BaseView;
import com.lantel.mine.list.MenuItem;

import java.util.ArrayList;
import java.util.List;

public interface MineContract {
    interface View extends BaseView {
        void setData(List list);

        void notifyData(ArrayList<MenuItem> list);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, MineModel> {

    }
}
