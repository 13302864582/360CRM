package com.lantel.mine.mvp;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;

import com.lantel.mine.list.adpter.MineRecycleViewAdapter;
import com.lantel.mine.list.model.MenuItemModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.LogUtils;
import com.example.moudletest.R;
import java.util.ArrayList;

public class MinePresenter extends MineContract.Presenter {
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
        loadMenu();
    }

    public void loadMenu() {
        Resources resource = context.getResources();

        ArrayList<BaseModel> list = new ArrayList<>();

        //添加头部数据
        BaseModel headModel = new BaseModel(MineRecycleViewAdapter.TYPE_HEAD,"头部局");
        list.add(headModel);

        //添加菜单数据
        String[] titles = resource.getStringArray(R.array.mine_menu_title);
        TypedArray icons = resource.obtainTypedArray(R.array.mine_menu_icon);
        for (int i = 0; i < titles.length; i++) {
            MenuItemModel TextImgIntModel = new MenuItemModel(icons.getResourceId(i, 0),i,titles[i],MineRecycleViewAdapter.TYPE_ITEM);
            list.add(TextImgIntModel);
        }

        for (int i = 0; i < 30; i++) {
            MenuItemModel TextImgIntModel = new MenuItemModel(icons.getResourceId(0, 0),i,titles[0],MineRecycleViewAdapter.TYPE_ITEM);
            list.add(TextImgIntModel);
        }

        mView.notifyData(list);
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
