package com.example.mvp;

import com.example.moudleb.ApiService;
import com.example.moudleb.TestBean;
import com.httpsdk.http.Constans;
import com.httpsdk.http.Http;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;


public class BModel extends ViewModel {
    LifecycleProvider<ActivityEvent> provider;

    public BModel(LifecycleProvider<ActivityEvent> provider) {
        this.provider = provider;
    }

    public Observable<TestBean> getmes() {
        ApiService service = Http.getInstance().createRequest(ApiService.class);
        return service.getPage(Constans.appid,Constans.key,"1");
    }
}
