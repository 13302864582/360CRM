package com.lantel.app.com.app;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.component_list.R;
import com.xiao360.baselibrary.base.BaseActivity;

import java.util.ArrayList;
import java.util.Arrays;

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
        String[] tab_market_title = getResources().getStringArray(R.array.tab_market_title);
        ArrayList<String> titles = new ArrayList(Arrays.asList(tab_market_title));
        ARouter.getInstance().build("/lantel/360/list").withStringArrayList(Config.TAB_TITLES,titles).navigation();
    }
}
