package com.lantel.app.com.lantel.list.mvp;

import com.lantel.app.com.app.Config;
import com.lantel.app.com.lantel.list.listview.model.DayTitleModel;
import com.lantel.app.com.lantel.list.listview.model.ListItemModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;

public class ListPresenter extends ListContract.Presenter {
    @Override
    public void onCrete() {
        LogUtils.d( "ListPresenter====onCrete: ");
    }

    @Override
    public void onStart() {
        LogUtils.d( "ListPresenter====onStart: ");
        loadData();
    }

    private void loadData() {
        ArrayList<BaseModel> data = new ArrayList();
        for (int i = 0; i < 100; i++) {
            data.add(new DayTitleModel("星期"+i,"2019-04-26==="+i));
            ListItemModel listItemModel = new ListItemModel();
            listItemModel.setImg("http://img5.duitang.com/uploads/item/201506/07/20150607110911_kY5cP.jpeg");
            listItemModel.setName("fz");
            listItemModel.setPhone("110");
            listItemModel.setState(Config.STATE_NOT_DEAL);
            listItemModel.setRemarks("well down");

            ListItemModel listItemMode2 = new ListItemModel();
            listItemMode2.setImg("");
            listItemMode2.setName("冯工");
            listItemMode2.setPhone("110");
            listItemMode2.setState(Config.STATE_COMPLETED);
            listItemMode2.setRemarks("well down");
            data.add(listItemModel);
            data.add(listItemMode2);
        }
        mView.refreshListData(data);

        ArrayList<BaseModel> titles = new ArrayList();
        for (int i = 0; i < 4; i++) {
            BaseModel model = new BaseModel();
            model.setTitle("1"+i);
            titles.add(model);
        }
        mView.refreshTabData(titles);
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
