package com.lantel.Splash;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.AppConfig;
import com.xiao360.baselibrary.base.BaseFragment;
import com.xiao360.baselibrary.util.LogUtils;
import com.example.moudletest.R;

import androidx.navigation.Navigation;
import butterknife.OnClick;

@Route(path = "/test/fragment")
public class SplashFragment extends BaseFragment {
    @Override
    protected int getLayoutResource() {
        return R.layout.b_main;
    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        if( bundle== null)
            return;

        int res_Mode = bundle.getInt(AppConfig.RES_MODE);
        switch (res_Mode){
            case AppConfig.MODE_LOACL:
                int[] local_Array = bundle.getIntArray(AppConfig.LOACL_RES_LIST);
                loadSplash(local_Array);
                break;
            case AppConfig.MODE_NET:
                String[] net_Array = bundle.getStringArray(AppConfig.NET_RES_LIST);
                loadSplash(net_Array);
                break;
            default:
                LogUtils.d("启动页需要设置本地图片资源集合，或者网络资源集合");
                break;
        }


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /**
                 *要执行的操作
                 */
            }
        }, 3000);//3秒后执行Runnable中的run方法
    }

    private void loadSplash(String[] net_array) {

    }

    private void loadSplash(int[] array) {

    }
}
