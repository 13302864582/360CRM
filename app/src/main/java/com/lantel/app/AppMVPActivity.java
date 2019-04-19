package com.lantel.app;

import com.example.baselibrary.base.BaseMVPActivity;
import com.example.moudletest.R;
import com.lantel.app.mvp.AppContract;
import com.lantel.app.mvp.AppModel;
import com.lantel.app.mvp.AppPresenter;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;
import butterknife.BindView;


public class AppMVPActivity extends BaseMVPActivity<AppPresenter, AppModel> implements AppContract.View {
    private NavController mNavController;
    /*@BindView(R.id.my_nav_host_fragment)
    Fragment myNavHostFragment;*/

    @Override
    protected boolean isFitsSystemWindows() {
        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的padding
        return true;
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
       /* Fragment fragment = findViewById(R.id.my_nav_host_fragment);
        mNavController = ((NavHostFragment)).getNavController();*/
        mNavController.getGraph().setStartDestination(R.id.page1Fragment);

    }

}
