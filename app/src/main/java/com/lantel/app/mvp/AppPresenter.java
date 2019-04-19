package com.lantel.app.mvp;

import android.util.Log;

public class AppPresenter extends AppContract.Presenter{
    private static final String TAG1 = "APresenter";

    @Override
    public void onCrete() {
        Log.d(TAG1, "onCrete: ");
    }

    @Override
    public void onStart() { }

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
}
