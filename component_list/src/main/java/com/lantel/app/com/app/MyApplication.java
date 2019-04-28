package com.lantel.app.com.app;

import com.xiao360.baselibrary.base.BaseApplication;
import com.xiao360.baselibrary.util.SpCache;

public class MyApplication extends BaseApplication {
    @Override
    protected void onCreateSelf() {
        SpCache.init(this);
    }
}
