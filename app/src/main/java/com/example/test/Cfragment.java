package com.example.test;

import android.util.Log;

import com.xiao360.baselibrary.base.BaseFragment;
import com.example.moudletest.R;

import androidx.navigation.Navigation;
import butterknife.OnClick;

public class Cfragment extends BaseFragment {
    @Override
    protected int getLayoutResource() {
        return R.layout.c_main;
    }

    @Override
    protected void initView() {

    }

    @OnClick(R.id.textc)
    public void onViewClicked() {
        Navigation.findNavController(rootView).navigate(R.id.action_home);
    }
}
