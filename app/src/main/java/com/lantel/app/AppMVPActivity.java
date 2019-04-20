package com.lantel.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cangwang.core.IBaseClient;
import com.cangwang.core.ModuleEvent;
import com.example.baselibrary.base.BaseMVPActivity;
import com.example.baselibrary.util.SpCache;
import com.example.moudletest.R;
import com.lantel.app.mvp.AppContract;
import com.lantel.app.mvp.AppModel;
import com.lantel.app.mvp.AppPresenter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.ItemTouchHelper;

public class AppMVPActivity extends BaseMVPActivity<AppPresenter, AppModel> implements AppContract.View {
    private NavController mNavController;

    @Override
    protected boolean setStatusBar() {
        return false;
    }

    @Override
    protected boolean isFitsSystemWindows() {
        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的padding
        return false;
    }

    @Override
    protected AppModel getModel() {
        return FindModel(AppModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.app;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        setFullScreen(true);
        getWindow().getDecorView().setSystemUiVisibility(View.INVISIBLE);

        NavHostFragment finalHost = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.my_nav_host_fragment);
        mNavController=finalHost.getNavController();
        Bundle bundle = new Bundle();
        bundle.putString("tag","this is fz");
        mNavController.navigate(R.id.action_page1,bundle);
    }

    @ModuleEvent(coreClientClass = IBaseClient.class)
    public void funfz(boolean FullScreen) {
        Log.d("SplashFragment","setFullScreen====");
       //setFullScreen(FullScreen);
        setFullScreen(false);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
}
