package com.lantel.app.com.lantel.personmess.activity.mvp;

import com.xiao360.baselibrary.base.BaseActivityPresenter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface PersonContract {
    interface View extends BaseView {
        void navigate(int action_page01);
    }

    abstract class Presenter extends BaseActivityPresenter<View, PersonModel> {

    }
}
