package com.xiao360.baselibrary.base;

public class BaseModel {
    private String title;

    private int type;

    public BaseModel() {
    }

    public BaseModel(int type, String title) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
