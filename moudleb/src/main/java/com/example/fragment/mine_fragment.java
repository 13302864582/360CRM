package com.example.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.baselibrary.lifecycle.LifeCycleFragmentFactory;
import com.example.baselibrary.mvp.BaseFragment;
import com.example.moudleb.R;
import com.example.mvp.BContract;
import com.example.mvp.BModel;
import com.example.mvp.BPresenter;

import androidx.annotation.Nullable;


public class mine_fragment extends BaseFragment<BPresenter, BModel> implements BContract.View {
    private static final String TAG = "home_fragment";
    private TextView txt;

    @Override
    protected BModel getModel() {
        return FindModel(BModel.class,new LifeCycleFragmentFactory(this));
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.moudle_mine;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    protected void initView() {
       txt = rootView.findViewById(R.id.fza);
    }

    @Override
    public void show(String msg) {
        Log.d(TAG, "====="+msg);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.load();
    }
}
