package com.lantel.app.com.lantel.personmess.activity;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.cangwang.core.IBaseClient;
import com.cangwang.core.ModuleEvent;
import com.example.component_list.R;
import com.gyf.immersionbar.BarHide;
import com.lantel.app.com.app.Config;
import com.lantel.app.com.lantel.personmess.activity.mvp.PersonContract;
import com.lantel.app.com.lantel.personmess.activity.mvp.PersonModel;
import com.lantel.app.com.lantel.personmess.activity.mvp.PersonPresenter;
import com.xiao360.baselibrary.base.BaseMVPActivity;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.LogUtils;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;

/**
 * 个人信息公用组件
 */
@Route(path = "/lantel/360/personalmess")
public class PersonalMessActivity extends BaseMVPActivity<PersonPresenter, PersonModel> implements PersonContract.View{
    private NavHostFragment navHost;
    private NavController mNavController;
    private int type = Config.PERSON_TYPE_MESS;

    @Override
    protected BarHide hideBar() {
        return BarHide.FLAG_SHOW_BAR;
    }

    @Override
    protected int getStateBarviewID() {
        return -1;
    }

    @Override
    protected PersonModel getModel() {
        return FindModel(PersonModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.personal_mess;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    public void initView() {
        attchIntent();
        navHost = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.person_nav_host_fragment);
        mNavController = navHost.getNavController();
        mModel.setModel(new BaseModel(type,"fz"));
        //navigate(R.id.);
    }

    /**
     * 接受传递过来的相关数据
     */
    private void attchIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            //tab标题
            type = bundle.getInt(Config.PERSON_TYPE,Config.PERSON_TYPE_MESS);
        }
    }

    @Override
    public void navigate(int actionId) {
        NavOptions.Builder builder = new NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setEnterAnim(R.anim.nav_default_enter_anim)
                .setExitAnim(R.anim.nav_default_exit_anim)
                .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
                .setPopExitAnim(R.anim.nav_default_pop_exit_anim);
        NavOptions options = builder.build();
        mNavController.navigate(actionId,null,options);
    }

    @ModuleEvent(coreClientClass = IBaseClient.class)
    public void onback(String tag) {
       switch (tag){
           case "add":
               LogUtils.d("onback====add");
               break;
           case "show":
               LogUtils.d("onback====show");
               break;
           case "edit":
               LogUtils.d("onback====edit");
               break;
       }
    }
}
