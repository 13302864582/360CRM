package com.lantel.home.list.model;

import com.lantel.AppConfig;
import com.lantel.home.list.adpter.HomeRecycleViewAdapter;
import com.xiao360.baselibrary.base.BaseModel;


/**
 * Created by 冯支.
 * function:
 * Date: 2019/4/24
 * Time: 14:36
 */
public class HeaderBean extends BaseModel{
    public String personal_img;
    private String user_name;
    private String user_area;
    private String scheldue_txt;
    private String homework_txt;
    private String renew_txt;

    public HeaderBean() {
        super(AppConfig.TYPE_HEAD,"主页");
    }

    public HeaderBean(String title) {
        super(AppConfig.TYPE_HEAD,title);
    }

    public String getPersonal_img() {
        return personal_img;
    }

    public void setPersonal_img(String personal_img) {
        this.personal_img = personal_img;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_area() {
        return user_area;
    }

    public void setUser_area(String user_area) {
        this.user_area = user_area;
    }

    public String getScheldue_txt() {
        return scheldue_txt;
    }

    public void setScheldue_txt(String scheldue_txt) {
        this.scheldue_txt = scheldue_txt;
    }

    public String getHomework_txt() {
        return homework_txt;
    }

    public void setHomework_txt(String homework_txt) {
        this.homework_txt = homework_txt;
    }

    public String getRenew_txt() {
        return renew_txt;
    }

    public void setRenew_txt(String renew_txt) {
        this.renew_txt = renew_txt;
    }

}
