package com.example.moudletest;

import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.circleMenu.GooeyMenu;

public class MainMVPActivity extends BaseActivity implements GooeyMenu.GooeyMenuInterface {
    /*@BindView(R2.id.gooey_menu)
    GooeyMenu gooeyMenu;*/

    @Override
    public int getLayoutId() {
        return /*R.layout.activity_main_b*/0;
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
