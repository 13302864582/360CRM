package com.lantel.app.com.lantel.personmess.mvp;

import com.lantel.app.com.app.Config;
import com.lantel.app.com.lantel.list.listview.model.DayTitleModel;
import com.lantel.app.com.lantel.list.listview.model.ListItemModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.ArrayList;

public class PersonPresenter extends PersonContract.Presenter {
    @Override
    public void onCrete() {
        LogUtils.d( "ListPresenter====onCrete: ");
    }

    @Override
    public void onStart() {

    }

    private void loadData() {

    }

    @Override
    public void onResume() {
        LogUtils.d( "ListPresenter====onResume: ");
    }

    @Override
    public void onPause() {
        LogUtils.d( "ListPresenter====onPause: ");
    }

    @Override
    public void onStop() {
        LogUtils.d( "ListPresenter====onStop: ");
    }

    @Override
    public void onDestroy() {
        LogUtils.d( "ListPresenter====onDestroy: ");
    }

}
