package com.lantel.app.com.lantel.personmess.fragment.model;

import com.lantel.app.com.app.Config;
import com.xiao360.baselibrary.base.BaseModel;

public class ItemTextModel extends BaseModel {
    private boolean isNeccessary = false;
    private String value = "";
    private int action_type = Config.ACTION_EDIT_TEXT;

    public boolean isGroupTop() {
        return isGroupTop;
    }

    public void setGroupTop(boolean groupTop) {
        isGroupTop = groupTop;
    }

    private boolean isGroupTop;


    public ItemTextModel(String title) {
        super(Config.PERSON_ITEM_TEXT, title);
    }

    public boolean isNeccessary() {
        return isNeccessary;
    }

    public void setNeccessary(boolean neccessary) {
        isNeccessary = neccessary;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getAction_type() {
        return action_type;
    }

    public void setAction_type(int action_type) {
        this.action_type = action_type;
    }
}
