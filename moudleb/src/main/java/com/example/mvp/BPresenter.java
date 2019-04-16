package com.example.mvp;

import android.util.Log;

import com.example.baselibrary.mvp.BaseObserver;
import com.example.moudleb.TestBean;
import com.httpsdk.http.RxHelper;

public class BPresenter extends BContract.Presenter {
    private static final String TAG1 = "APresenter";

    @Override
    public void load() {
        if (mModel != null && mView != null) {
            mModel.getmes()
                    .compose(RxHelper.<TestBean>observableIO2Main(context))
                    .subscribe(new BaseObserver<TestBean>() {
                        @Override
                        public void onSuccess(TestBean testBean) {
                            Log.d(TAG1, "onNext: ");
                            mView.show(testBean.getShowapi_res_body().getPagebean().getContentlist().get(0).getImg());
                        }

                        @Override
                        public void onFailure(Throwable e) {

                        }
                    });
        }
    }

    @Override
    public void onCrete () {
        Log.d(TAG1, "onCrete: ");
    }

    @Override
    public void onStart () {
        load();
    }

    @Override
    public void onResume () {
        Log.d(TAG1, "onResume: ");
    }

    @Override
    public void onPause () {
        Log.d(TAG1, "onPause: ");
    }

    @Override
    public void onStop () {
        Log.d(TAG1, "onStop: ");
    }

    @Override
    public void onDestroy () {
        Log.d(TAG1, "onDestroy: ");
    }
}
