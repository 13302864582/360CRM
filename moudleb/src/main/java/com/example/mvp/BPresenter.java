package com.example.mvp;

import android.os.Bundle;
import android.util.Log;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.example.moudleb.TestBean;
import com.httpsdk.http.RxHelper;

public class BPresenter extends BContract.Presenter {
    private static final String TAG1 = "APresenter";

    @Override
    public void load() {
        if (mModel != null && mView != null) {
            mModel.getmes()
                    .compose(RxHelper.<TestBean>observableIO2Main(context))
                    .subscribe(new BaseRxObserver<TestBean>() {
                        @Override
                        public void onSuccess(TestBean testBean) {
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

    }

    @Override
    public void onStart () {
        load();
    }

    @Override
    public void onResume () {

    }

    @Override
    public void onPause () {
    }

    @Override
    public void onStop () {

    }

    @Override
    public void onDestroy () {

    }

    @Override
    public void onCrete(Bundle savedInstanceState) {

    }
}
