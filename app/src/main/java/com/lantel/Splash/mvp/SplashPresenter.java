package com.lantel.Splash.mvp;

import android.os.Bundle;

import com.example.baselibrary.util.LogUtils;
import com.lantel.mine.list.MenuItem;

import java.util.ArrayList;

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

    public void loadData(int size) {
        ArrayList<MenuItem> list = new ArrayList();
        for(int i=0;i<size;i++){
            MenuItem menuItem = new MenuItem();
            menuItem.setText("这是第"+i+"条数据");
            list.add(menuItem);
        }
        mView.setData(list);
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
