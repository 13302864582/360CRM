package com.lantel.app.com.lantel.list.listview.model;

import com.lantel.app.com.app.Config;
import com.xiao360.baselibrary.base.BaseModel;

public class DayTitleModel extends BaseModel {
    private String date;

    public DayTitleModel(String title, String date) {
        super(Config.DAY_ITEM, title);
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
