package com.lantel.app.mvp;

import android.util.Log;
import android.view.MenuItem;
import com.example.moudletest.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;

public class AppPresenter extends AppContract.Presenter implements BottomNavigationView.OnNavigationItemSelectedListener {
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.item_home:
                mView.navigate(R.id.action_home);
                break;
            case R.id.item_classes:
                mView.navigate(R.id.action_classes);
                break;
            case R.id.item_student:
                mView.navigate(R.id.action_student);
                break;
            case R.id.item_mine:
                mView.navigate(R.id.action_mine);
                break;
        }
        return true;
    }
}
