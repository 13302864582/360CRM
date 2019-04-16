package com.example.moudlea.mvp;

import com.example.moudlea.api.ApiService;
import com.example.moudlea.bean.TestBean;
import com.httpsdk.http.Constans;
import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.trello.rxlifecycle2.components.support.RxFragment;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;

public class AModel extends ViewModel {
    public Observable<TestBean> getmes(RxFragment context) {
        ApiService service = Http.getInstance().createRequest(ApiService.class);
        return service.getAll(Constans.appid, Constans.key, "1");
    }
}
