package com.lantel.app.com.lantel.personmess.fragment;

import com.example.component_list.R;
import com.xiao360.baselibrary.base.BaseMVPFragment;

import androidx.lifecycle.ViewModel;

public class ShowMessFragment extends BaseMVPFragment {
    @Override
    protected int getStateBarviewID() {
        return 0;
    }

    @Override
    protected ViewModel getModel() {
        return null;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.person_add_mess;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

    }
}
