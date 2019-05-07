package com.lantel.app.com.lantel.personmess.activity.mvp;

import com.xiao360.baselibrary.base.BaseModel;

import androidx.lifecycle.ViewModel;

public class PersonModel extends ViewModel {
    BaseModel model;

    public BaseModel getModel() {
        return model;
    }

    public void setModel(BaseModel model) {
        this.model = model;
    }
}
