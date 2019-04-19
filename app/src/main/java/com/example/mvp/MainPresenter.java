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
        Log.d(TAG1, "onCrete: ");
    }

    @Override
    public void onStart() {
        Log.d(TAG1, "onStart: ");
        load();
    }

    @Override
    public void onResume() {
        Log.d(TAG1, "onResume: ");
    }

    @Override
    public void onPause() {
        Log.d(TAG1, "onPause: ");
    }

    @Override
    public void onStop() {
        Log.d(TAG1, "onStop: ");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG1, "onDestroy: ");
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        menuItem.setChecked(true);
        Log.d(TAG1, "onNavigationItemSelected=====:"+menuItem.getTitle());
        return false;
    }
}
