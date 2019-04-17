package com.example.baselibrary.moudle.activity;

import android.os.Bundle;
import android.view.ViewTreeObserver;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;

public abstract class MoudleManagerActivity extends RxAppCompatActivity {
    private ActivityMoudleManager moudleManager;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().getRootView().getViewTreeObserver()
                .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        if(moudleManager == null){
                            moudleManager =new ActivityMoudleManager();
                            moudleManager.initMoudles(savedInstanceState,MoudleManagerActivity.this,moduleConfig());
                        }
                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        moudleManager.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        moudleManager.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        moudleManager.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        moudleManager.onDestroy();
    }

    protected abstract ArrayMap<String, ArrayList<Integer>> moduleConfig();
}
