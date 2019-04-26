package com.example.moudletest;

import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.circleMenu.GooeyMenu;
import butterknife.BindView;

public class MainMVPActivity extends BaseActivity implements GooeyMenu.GooeyMenuInterface {
    /*@BindView(R2.id.gooey_menu)
    GooeyMenu gooeyMenu;*/

    @Override
    protected boolean isFitsSystemWindows() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main_b;
    }

    @Override
    public void initView() {
        //gooeyMenu.setOnMenuListener(this);
    }

    @Override
    public void menuOpen() {

    }

    @Override
    public void menuClose() {

    }

    @Override
    public void menuItemClicked(int menuNumber) {

    }

    /*private GooeyMenu mGooeyMenu;

    @Override
    protected boolean isFitsSystemWindows() {
        return false;
    }

    @Override
    protected ViewModel getModel() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return com.example.moudleb.R.layout.activity_main_b;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mGooeyMenu = (GooeyMenu) findViewById(R.id.gooey_menu);
        mGooeyMenu.setOnMenuListener(this);
    }

    @Override
    public void menuOpen() {

    }

    @Override
    public void menuClose() {

    }

    @Override
    public void menuItemClicked(int menuNumber) {

    }*/
}
