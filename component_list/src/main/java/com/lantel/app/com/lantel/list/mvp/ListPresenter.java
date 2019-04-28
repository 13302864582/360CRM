package com.lantel.app.com.lantel.list.mvp;

import com.xiao360.baselibrary.util.LogUtils;

public class ListPresenter extends ListContract.Presenter {
    @Override
    public void onCrete() {
        LogUtils.d( "ListPresenter====onCrete: ");
    }

    @Override
    public void onStart() {
        LogUtils.d( "ListPresenter====onStart: ");
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
