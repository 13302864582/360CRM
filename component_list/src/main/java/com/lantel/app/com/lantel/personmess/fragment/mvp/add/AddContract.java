package com.lantel.app.com.lantel.personmess.fragment.mvp.add;

import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface AddContract {
    interface View extends BaseView {
        void refreshList(ArrayList<BaseModel> list);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, AddModel> {

    }
}
