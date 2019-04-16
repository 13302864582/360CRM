package com.example.baselibrary.mvp;

import com.trello.rxlifecycle2.components.support.RxFragment;

public abstract class BaseFragmentPresenter<T,E> extends BasePresenter<T,E> {
    protected RxFragment context;
}
