package com.lantel.app.com.app;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.component_list.R;
import com.xiao360.baselibrary.base.BaseActivity;

/**
 * app启动activity
 * */
public class AppMVPActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.launch;
    }

    @Override
    public void initView() {
        ARouter.getInstance().build("/lantel/360/list").withString("mess","jump from appmvp").navigation();
    }
}
