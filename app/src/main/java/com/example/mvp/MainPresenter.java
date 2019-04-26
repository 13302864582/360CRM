package com.example.mvp;

import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;

public class MainPresenter extends MainContract.Presenter implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static final String TAG1 = "APresenter";

    @Override
    public void load() {
        if(mModel!= null && mView!=null){
           /* mModel.getmes()
                    .compose(RxHelper.observableIO2Main(context))
                    .subscribe(new Observer() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            Log.d(TAG1, "onSubscribe: ");
                        }

                        @Override
                        public void onNext(Object o) {
                            Log.d(TAG1, "onNext: "+o.toString());
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d(TAG1, "onError: ");
                        }

                        @Override
                        public void onComplete() {
                            Log.d(TAG1, "onComplete: ");
                        }
                    });*/
        }
    }

    @Override
    public void onCrete() {

    }

    @Override
    public void onStart() {

        load();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        menuItem.setChecked(true);
        return false;
    }
}
