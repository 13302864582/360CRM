package com.lantel.mine.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class MenuItemModel extends BaseModel{
    //图标
    private int icon;
    //跳转ACTION标志
    private int flag_action = 0;

    public MenuItemModel(int icon, int flag_action, String title, int type) {
        super(type,title);
        this.icon = icon;
        this.flag_action = flag_action;
    }

    public int getIcon() {
        return icon;
    }

    public int getFlag_action() {
        return flag_action;
    }
}
