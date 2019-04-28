package com.lantel.app;

import android.view.View;
import com.cangwang.core.IBaseClient;
import com.cangwang.core.ModuleEvent;
import com.example.moudletest.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.lantel.app.mvp.AppContract;
import com.lantel.app.mvp.AppModel;
import com.lantel.app.mvp.AppPresenter;
import com.xiao360.baselibrary.base.BaseMVPActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;
import butterknife.BindView;

/**
 * app启动activity
 * */
public class AppMVPActivity extends BaseMVPActivity<AppPresenter, AppModel> implements AppContract.View {
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;
    private NavController mNavController;
    private NavHostFragment navHost;
    private int mLastNavId = -1;

    @Override
    protected int getStateBarviewID() {
        return -1;
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

        bottomNavigation.setItemIconTintList(null);
        bottomNavigation.setOnNavigationItemSelectedListener(mPresenter);

        navHost = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.my_nav_host_fragment);
        mNavController = navHost.getNavController();
        navigate(R.id.action_mine);
        bottomNavigation.setSelectedItemId(R.id.item_mine);

        //初始化状态栏
        ImmersionBar.with(this)
                .hideBar(BarHide.FLAG_SHOW_BAR)
                .init();

    }

    @ModuleEvent(coreClientClass = IBaseClient.class)
    public void funfz(boolean FullScreen) {
        int visable = bottomNavigation.getVisibility();
        if(View.GONE == visable){
            bottomNavigation.setVisibility(View.VISIBLE);
        }else {
            bottomNavigation.setVisibility(View.GONE);
        }
    }

    @Override
    public void navigate(int action_id) {
        if(action_id == mLastNavId)
            return;
        mLastNavId = action_id;
        NavOptions.Builder builder = new NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setEnterAnim(R.anim.nav_default_enter_anim)
                .setExitAnim(R.anim.nav_default_exit_anim)
                .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
                .setPopExitAnim(R.anim.nav_default_pop_exit_anim);
        NavOptions options = builder.build();
        mNavController.navigate(action_id,null,options);
    }

}
