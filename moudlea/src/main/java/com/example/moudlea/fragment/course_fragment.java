package com.example.moudlea.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.baselibrary.lifecycle.LifeCycleFragmentFactory;
import com.example.baselibrary.mvp.BaseFragment;
import com.example.moudlea.R;
import com.example.moudlea.mvp.AContract;
import com.example.moudlea.mvp.AModel;
import com.example.moudlea.mvp.APresenter;

import androidx.annotation.Nullable;


public class course_fragment extends BaseFragment<APresenter, AModel> implements AContract.View {
    private static final String TAG = "home_fragment";
    private TextView txt;

    @Override
    protected AModel getModel() {
        return FindModel(AModel.class,new LifeCycleFragmentFactory(this));
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.moudle_course;
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
