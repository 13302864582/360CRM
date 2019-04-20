package com.example.test;

import android.util.Log;

import com.example.baselibrary.base.BaseFragment;
import com.example.moudletest.R;

import androidx.navigation.Navigation;
import butterknife.OnClick;

public class Dfragment extends BaseFragment {
    @Override
    protected int getLayoutResource() {
        return R.layout.d_main;
    }

    @Override
    protected void initView() {

    }

    @OnClick(R.id.textd)
    public void onViewClicked() {
        Log.d("tabhost","d=======");
        Navigation.findNavController(rootView).navigate(R.id.action_page1);
    }
}
