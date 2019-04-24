package com.lantel.Splash.mvp;

import android.os.Bundle;

import com.xiao360.baselibrary.util.LogUtils;

public class SplashPresenter extends SplashContract.Presenter{
    @Override
    public void onCrete(Bundle savedInstanceState) {
        LogUtils.d("onCrete: ");
    }

    //onActivityCreated
    @Override
    public void onCrete() {
        LogUtils.d("onActivityCreated: ");
    }

    @Override
    public void onStart() {
        LogUtils.d("onStart: ");
       /* ArrayList<MenuItem> list = new ArrayList();
        for(int i=0;i<5;i++){
            MenuItem menuItem = new MenuItem();
            menuItem.setText("这是第"+i+"条数据");
            list.add(menuItem);
        }
        mView.notifyData(list);*/
    }

    @Override
    public void onResume() {
        LogUtils.d("onResume: ");
    }

    @Override
    public void onPause() {
        LogUtils.d("onPause: ");
    }

    @Override
    public void onStop() {
        LogUtils.d("onStop: ");
    }

    @Override
    public void onDestroy() {
        LogUtils.d("onCrete: ");
    }
}
