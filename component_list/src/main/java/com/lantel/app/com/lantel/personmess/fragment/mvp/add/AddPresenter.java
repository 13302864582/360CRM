package com.lantel.app.com.lantel.personmess.fragment.mvp.add;

import android.os.Bundle;
import android.util.ArraySet;

import com.lantel.app.com.lantel.personmess.activity.mvp.PersonModel;
import com.lantel.app.com.lantel.personmess.fragment.model.ItemStarModel;
import com.lantel.app.com.lantel.personmess.fragment.model.ItemTextModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;

import androidx.lifecycle.ViewModelProviders;

public class AddPresenter extends AddContract.Presenter {
    @Override
    public void onCrete(Bundle savedInstanceState) {

    }

    @Override
    public void onCrete() {
        LogUtils.d( "ListPresenter====onCrete: ");
    }

    @Override
    public void onStart() {
        PersonModel personModel =  ViewModelProviders.of(context.getActivity()).get(PersonModel.class);
        LogUtils.d("model==="+personModel.getModel().getType()+"===="+personModel.getModel().getTitle());

        ArrayList<BaseModel> models = new ArrayList<>();
        for(int i=0;i<20;i++){
            ItemTextModel model1 = new ItemTextModel("=="+i);
            model1.setGroupTop(true);
            models.add(model1);
            ItemTextModel model2 = new ItemTextModel("=="+i);
            model2.setGroupTop(false);
            models.add(model2);
        }
        models.add(new ItemStarModel("=="));
        mView.refreshList(models);
    }

    @Override
    public void onResume() {
        LogUtils.d( "ListPresenter====onResume: ");
    }

    @Override
    public void onPause() {
        LogUtils.d( "ListPresenter====onPause: ");
    }

    @Override
    public void onStop() {
        LogUtils.d( "ListPresenter====onStop: ");
    }

    @Override
    public void onDestroy() {
        LogUtils.d( "ListPresenter====onDestroy: ");
    }
}
