package com.lantel.home.mvp;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import com.example.moudletest.R;
import com.lantel.home.list.model.ADModel;
import com.lantel.home.list.model.HeaderBean;
import com.lantel.home.list.model.MenuModel;
import com.lantel.mine.list.model.MenuItemModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.ArrayList;

public class HomePresenter extends HomeContract.Presenter {
    @Override
    public void onCrete(Bundle savedInstanceState) {
        LogUtils.d("HomePresenter=======onCrete: ");
    }

    //onActivityCreated
    @Override
    public void onCrete() {
        LogUtils.d("HomePresenter======onActivityCreated: ");
    }

    @Override
    public void onStart() {
        LogUtils.d("HomePresenter=======onStart: ");
        loadMenu();
    }

    @Override
    public void onResume() {
        LogUtils.d("HomePresenter======onResume: ");
    }

    @Override
    public void onPause() {
        LogUtils.d("HomePresenter=======onPause: ");
    }

    @Override
    public void onStop() {
        LogUtils.d("HomePresenter======onStop: ");
    }

    @Override
    public void onDestroy() {
        LogUtils.d("HomePresenter======onCrete: ");
    }

    public void loadMenu() {
        Resources resource = context.getResources();

        ArrayList<BaseModel> list = new ArrayList<>();

        //添加头部数据
        HeaderBean headModel = new HeaderBean();
        headModel.setPersonal_img("http://img5.duitang.com/uploads/item/201506/07/20150607110911_kY5cP.jpeg");
        headModel.setUser_name("李晓晓");
        headModel.setUser_area("龙华区阳光小学");
        headModel.setScheldue_txt("9");
        headModel.setHomework_txt("54");
        headModel.setRenew_txt("4");
        list.add(headModel);

        //添加菜单数据
        String[] titles = resource.getStringArray(R.array.home_menu_title);
        TypedArray icons = resource.obtainTypedArray(R.array.home_menu_icon);
        int[] actions = resource.getIntArray(R.array.home_menu_action);
        MenuModel model =new MenuModel();

        ArrayList<MenuItemModel> menulist = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            MenuItemModel TextImgIntModel = new MenuItemModel(icons.getResourceId(i, 0),actions[i],titles[i]);
            menulist.add(TextImgIntModel);
        }

        model.setItems(menulist);
        list.add(model);

        //AD数据
        ArrayList<Object> imgs = new ArrayList<>();
        imgs.add("https://t1.hddhhn.com/uploads/tu/201812/622/484.jpg");
        imgs.add("http://img5.duitang.com/uploads/item/201506/07/20150607110911_kY5cP.jpeg");
        imgs.add(R.mipmap.banner);

        ADModel adModel = new ADModel(imgs);
        list.add(adModel);

        mView.notifyData(list);
    }
}
