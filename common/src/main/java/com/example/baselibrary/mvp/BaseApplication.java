package com.example.baselibrary.mvp;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.alibaba.android.arouter.launcher.ARouter;
import com.httpsdk.http.Constans;
import com.httpsdk.http.Http;


public abstract class BaseApplication extends Application {
    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        //Http.init(Constans.baseUrl);
        baseApplication = this;
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this);

        onCreateSelf();
    }

    protected abstract void onCreateSelf();


    public static Context getAppContext() {
        return baseApplication;
    }
    public static Resources getAppResources() {
        return baseApplication.getResources();
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    /**
     * 分包
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //MultiDex.install(this);
    }
}
