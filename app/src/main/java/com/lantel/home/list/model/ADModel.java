package com.lantel.home.list.model;

import com.lantel.AppConfig;
import com.lantel.app.mvp.AppPresenter;
import com.lantel.home.list.adpter.HomeRecycleViewAdapter;
import com.xiao360.baselibrary.base.BaseModel;

import java.util.ArrayList;

public class ADModel extends BaseModel{
    //图标
    private ArrayList<Object> img;

    public ADModel(ArrayList img) {
        super(AppConfig.TYPE_AD,"");
        this.img = img;
    }

    public ArrayList<Object> getIcon() {
        return img;
    }

}
