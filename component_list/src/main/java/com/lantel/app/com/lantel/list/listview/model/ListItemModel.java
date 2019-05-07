package com.lantel.app.com.lantel.list.listview.model;

import com.example.component_list.R;
import com.lantel.app.com.app.Config;
import com.xiao360.baselibrary.base.BaseModel;

public class ListItemModel extends BaseModel {
    //个人头像
    public String imgUrl;
    //用户名
    public String name;
    //电话号码
    public String phone;
    //状态
    public int state;
    //状态对应的字
    public int state_txt;
    //状态对应的颜色
    public int state_color;
    //备注
    public String remarks;

    public ListItemModel() {
        super(Config.MESS_ITEM, "");
    }

    public String getImg() {
        return imgUrl;
    }

    public void setImg(String img) {
        this.imgUrl = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getState() {
        return state;
    }

    public int getState_txt() {
        return state_txt;
    }

    public int getState_color() {
        return state_color;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setState(int state) {
        this.state = state;
        switch (state) {
            case Config.STATE_NOT_DEAL:
                state_txt = R.string.not_finish_yet;
                state_color = R.color.list_item_state_not_deal;
                break;
            case Config.STATE_WAIT_WAIT_CONFIM:
                state_txt = R.string.wait_confirm;
                state_color = R.color.list_item_state_wait_confirm;
                break;
            case Config.STATE_COMPLETED:
                state_txt = R.string.finished;
                state_color = R.color.list_item_state_completed;
                break;
            case Config.STATE_AUDITIONED:
                state_txt = R.string.auditioned;
                state_color = R.color.list_item_state_Auditioned;
                break;
            case Config.STATE_NOT_COMING_DOOR:
                state_txt = R.string.not_coming_door;
                state_color = R.color.list_item_state_not_coming_door;
                break;
            case Config.STATE_HAS_VISITED:
                state_txt = R.string.has_visited;
                state_color = R.color.list_item_state_has_visited;
                break;
        }
    }
}
