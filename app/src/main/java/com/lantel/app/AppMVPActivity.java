package com.lantel.app;

import android.graphics.Color;
import android.util.Log;
import android.view.View;

import com.cangwang.core.IBaseClient;
import com.cangwang.core.ModuleEvent;
import com.xiao360.baselibrary.base.BaseMVPActivity;
import com.example.moudletest.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lantel.app.mvp.AppContract;
import com.lantel.app.mvp.AppModel;
import com.lantel.app.mvp.AppPresenter;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import butterknife.BindView;


public class AppMVPActivity extends BaseMVPActivity<AppPresenter, AppModel> implements AppContract.View {
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;

    private NavController mNavController;
    private NavHostFragment navHost;

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


        bottomNavigation.setItemIconTintList(null);
        bottomNavigation.setOnNavigationItemSelectedListener(mPresenter);

        navHost = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.my_nav_host_fragment);
        mNavController = navHost.getNavController();
        navigate(R.id.action_mine);


        this.getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        setFullScreen(false);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
    }

    @ModuleEvent(coreClientClass = IBaseClient.class)
    public void funfz(boolean FullScreen) {
        Log.d("SplashFragment", "setFullScreen====");
        //setFullScreen(FullScreen);
        setFullScreen(false);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @Override
    public void navigate(int action_id) {
        mNavController.navigate(action_id);
    }

 /*   @OnClick(R.id.button)
    public void onViewClicked(View view) {
        int visable = bottomNavigation.getVisibility();
        if(View.GONE == visable){
            bottomNavigation.setVisibility(View.VISIBLE);
        }else {
            bottomNavigation.setVisibility(View.GONE);
        }
    }*/
}
