package com.example.baselibrary.base;

import android.os.Bundle;

import com.example.baselibrary.mvp.BasePresenter;
import com.trello.rxlifecycle2.components.support.RxFragment;

public abstract class BaseFragmentPresenter<T,E> extends BasePresenter<T,E> {
    protected RxFragment context;

    public abstract void onCrete(Bundle savedInstanceState);
}
