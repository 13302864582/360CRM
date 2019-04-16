package com.example.baselibrary.mvp;

import android.content.Context;

public abstract class BaseActivityPresenter<T,E> extends BasePresenter<T,E> {
    protected Context context;
}
