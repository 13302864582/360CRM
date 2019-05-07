package com.lantel.app.com.lantel.personmess.fragment.model;

import com.lantel.app.com.app.Config;
import com.xiao360.baselibrary.base.BaseModel;

public class ItemRemarkModel extends BaseModel {
    private boolean isGroupTop;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isGroupTop() {
        return isGroupTop;
    }

    public void setGroupTop(boolean groupTop) {
        isGroupTop = groupTop;
    }

    public ItemRemarkModel(String title) {
        super(Config.PERSON_ITEM_REMARK, title);
        isGroupTop = true;
    }
}
