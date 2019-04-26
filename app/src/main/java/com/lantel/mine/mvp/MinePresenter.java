package com.lantel.mine.mvp;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;

import com.lantel.mine.list.adpter.MineRecycleViewAdapter;
import com.lantel.mine.list.model.HeaderBean;
import com.lantel.mine.list.model.MenuItemModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.LogUtils;
import com.example.moudletest.R;
import java.util.ArrayList;

import static com.lantel.AppConfig.TYPE_ITEM;

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

        //模拟数据
        ArrayList<String> positions = new ArrayList<>();
        for(int i=1;i<13;i++){
            positions.add("师"+i);
            positions.add("任课老师"+i);
            positions.add("任师"+i);
        }

        //添加头部数据
        BaseModel headModel = new HeaderBean("李晓晓", "龙华区阳光小学", "http://img5.duitang.com/uploads/item/201506/07/20150607110911_kY5cP.jpeg", positions);
        list.add(headModel);

        //添加菜单数据
        String[] titles = resource.getStringArray(R.array.mine_menu_title);
        int[] actions = resource.getIntArray(R.array.mine_menu_action);
        TypedArray icons = resource.obtainTypedArray(R.array.mine_menu_icon);
        for (int i = 0; i < titles.length; i++) {
            MenuItemModel TextImgIntModel = new MenuItemModel(icons.getResourceId(i, 0),actions[i],titles[i],TYPE_ITEM);
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
