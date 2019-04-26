package com.lantel.home.list.model;

import com.lantel.AppConfig;
import com.lantel.home.list.adpter.HomeRecycleViewAdapter;
import com.lantel.mine.list.model.MenuItemModel;
import com.xiao360.baselibrary.base.BaseModel;

import java.util.ArrayList;

/**
 * Created by 冯支.
 * function:
 * Date: 2019/4/26
 * Time: 14:34
 */
public class MenuModel extends BaseModel {
    private ArrayList<MenuItemModel> items;

    public MenuModel() {
        super(AppConfig.TYPE_ITEM, "");
    }

    public ArrayList<MenuItemModel> getItems() {
        return items;
    }

    public void setItems(ArrayList<MenuItemModel> positions) {
        this.items = positions;
    }
}
