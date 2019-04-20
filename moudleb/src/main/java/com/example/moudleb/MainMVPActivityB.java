package com.example.moudleb;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.baselibrary.base.BaseMVPActivity;

import androidx.lifecycle.ViewModel;

@Route(path = "/apptwo/moudleB/activityB")
public class MainMVPActivityB extends BaseMVPActivity {

    @Override
    protected boolean setStatusBar() {
        return true;
    }

    @Override
    protected boolean isFitsSystemWindows() {
        return false;
    }

    @Override
    protected ViewModel getModel() {
        return null;
        //return FindModel(BModel.class,new AMoudleFactory(this));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main_b;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

    }

    /*@OnClick(R2.id.fzb)
    public void onViewClicked() {
        // 2. 跳转并携带参数
        ARouter.getInstance().build("/appone/moudleA/activityA")
                .withLong("key1", 666L)
                .withString("key2", "888")
                .navigation();
    }*/
}
