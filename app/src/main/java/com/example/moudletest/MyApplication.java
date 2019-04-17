package com.example.moudletest;

import com.example.baselibrary.mvp.BaseApplication;
import com.example.baselibrary.util.SpCache;
import com.httpsdk.http.CacheInterceptor;
import com.httpsdk.http.Constans;
import com.httpsdk.http.Http;
import com.httpsdk.http.LogInterceptor;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyApplication extends BaseApplication {
    @Override
    protected void onCreateSelf() {
        File cacheDir = new File(getAppContext().getCacheDir(), "response");
        //缓存的最大尺寸10m
        Cache cache = new Cache(cacheDir, 1024 * 1024 * 10);
        OkHttpClient.Builder builder =  new OkHttpClient.Builder()
               .cache(cache).readTimeout(Constans.DEFAULT_TIME, TimeUnit.SECONDS)//设置读取超时时间
                .connectTimeout(Constans.DEFAULT_TIME, TimeUnit.SECONDS)//设置请求超时时间
                .writeTimeout(Constans.DEFAULT_TIME,TimeUnit.SECONDS)//设置写入超时时间
                .addInterceptor(new LogInterceptor())//添加打印拦截器
                .addInterceptor(new CacheInterceptor(getAppContext()))
                .retryOnConnectionFailure(true); //设置出现错误进行重新连接;*/
        Http.init(builder,Constans.baseUrl);
        SpCache.init(this);
    }
}
