package com.example.test;

import android.util.Log;

import com.xiao360.baselibrary.base.BaseFragment;
import com.example.moudletest.R;

import androidx.navigation.Navigation;
import butterknife.OnClick;

public class Bfragment extends BaseFragment {
    @Override
    protected int getLayoutResource() {
        return R.layout.b_main;
    }

    @Override
    protected void initView() {

    }

    @OnClick(R.id.textb)
    public void onViewClicked() {
        Log.d("tabhost","b=======");
        Navigation.findNavController(rootView).navigate(R.id.action_home);
    }
}
