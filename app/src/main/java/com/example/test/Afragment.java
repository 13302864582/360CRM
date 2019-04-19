package com.example.test;

import android.util.Log;
import android.widget.TextView;

import com.example.baselibrary.base.BaseFragment;
import com.example.moudletest.R;

import androidx.navigation.Navigation;

import butterknife.OnClick;

public class Afragment extends BaseFragment {
    @Override
    protected int getLayoutResource() {
        return R.layout.a_main;
    }

    @Override
    protected void initView() {

    }

    @OnClick(R.id.texta)
    public void onViewClicked() {
        Log.d("tabhost","a=======");
        Navigation.findNavController(rootView).navigate(R.id.action_page2);
    }
}
