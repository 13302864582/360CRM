package com.lantel.mine.list.model;

import com.lantel.AppConfig;
import com.lantel.mine.list.adpter.MineRecycleViewAdapter;
import com.xiao360.baselibrary.base.BaseModel;

import java.util.ArrayList;

/**
 * Created by 冯支.
 * function:
 * Date: 2019/4/24
 * Time: 14:36
 */
public class HeaderBean extends BaseModel{
    private String personal_name;
    private String personal_area;
    private String personal_img;
    private ArrayList<String> positions;

    public HeaderBean(String personal_name, String personal_area, String personal_img, ArrayList<String> positions) {
        super(AppConfig.TYPE_HEAD,"我的");
        this.personal_name = personal_name;
        this.personal_area = personal_area;
        this.personal_img = personal_img;
        this.positions = positions;
    }
    public HeaderBean(String title,String personal_name, String personal_area, String personal_img, ArrayList<String> positions) {
        super(AppConfig.TYPE_HEAD,title);
        this.personal_name = personal_name;
        this.personal_area = personal_area;
        this.personal_img = personal_img;
        this.positions = positions;
    }


    public String getPersonal_name() {
        return personal_name;
    }

    public void setPersonal_name(String personal_name) {
        this.personal_name = personal_name;
    }

    public String getPersonal_area() {
        return personal_area;
    }

    public void setPersonal_area(String personal_area) {
        this.personal_area = personal_area;
    }

    public String getPersonal_img() {
        return personal_img;
    }

    public void setPersonal_img(String personal_img) {
        this.personal_img = personal_img;
    }

    public ArrayList<String> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<String> positions) {
        this.positions = positions;
    }
}
