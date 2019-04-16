package com.example.mvp;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import androidx.lifecycle.ViewModel;

public class MainModel extends ViewModel {
    LifecycleProvider<ActivityEvent> provider;

    public MainModel(LifecycleProvider<ActivityEvent> provider) {
        this.provider = provider;
    }

  /*  public Observable<String>getmes(BaseObserver<String> baseObserver) {
        ApiService service = Http.getInstance().createRequest(ApiService.class);
        return service.getAll(Constans.appid, Constans.key, "1");
    }*/
}
