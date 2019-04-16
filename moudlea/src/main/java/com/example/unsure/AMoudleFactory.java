package com.example.unsure;


import com.example.moudlea.mvp.AModel;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

//TODO  暂时不确定是否需要
public class AMoudleFactory extends ViewModelProvider.NewInstanceFactory {
  /*  private LifecycleProvider<ActivityEvent> provider;

    public AMoudleFactory(LifecycleProvider<ActivityEvent> provider) {
        this.provider = provider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new AModel(provider);
    }*/
}
