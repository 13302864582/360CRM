package com.lantel.app.com.lantel.personmess;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.component_list.R;
import com.lantel.app.com.lantel.personmess.mvp.PersonContract;
import com.lantel.app.com.lantel.personmess.mvp.PersonModel;
import com.lantel.app.com.lantel.personmess.mvp.PersonPresenter;
import com.xiao360.baselibrary.base.BaseMVPActivity;
import com.xiao360.baselibrary.base.BaseModel;
import java.util.ArrayList;

/**
 * 个人信息公用组件
 */
@Route(path = "/lantel/360/personalmess")
public class PersonalMessActivity extends BaseMVPActivity<PersonPresenter, PersonModel> implements PersonContract.View{
    /**
     * 状态栏id
     */
    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }


    @Override
    protected PersonModel getModel() {
        return FindModel(PersonModel.class);
    }

    /**
     * 布局文件
     */
    @Override
    public int getLayoutId() {
        //TODO 整理lauout内部，searchview
        return R.layout.personal_mess;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {

    }

    /**
     * 接受传递过来的相关数据
     */
    private void attchIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

        }
    }

    @Override
    public void refreshListData(ArrayList<BaseModel> data) {

    }
}
