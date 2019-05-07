package com.lantel.app.com.lantel.personmess.fragment.model;

import com.lantel.app.com.app.Config;
import com.xiao360.baselibrary.base.BaseModel;

public class ItemStarModel extends BaseModel {
    public boolean isGroupTop() {
        return isGroupTop;
    }

    public void setGroupTop(boolean groupTop) {
        isGroupTop = groupTop;
    }

    private boolean isGroupTop;
    public ItemStarModel(String title) {
        super(Config.PERSON_ITEM_STAR, title);
        isGroupTop = false;
    }
}
