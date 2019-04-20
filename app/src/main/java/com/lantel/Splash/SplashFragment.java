package com.lantel.Splash;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cangwang.core.IBaseClient;
import com.cangwang.core.ModuleBus;
import com.example.baselibrary.base.BaseFragment;
import com.example.baselibrary.util.LogUtils;
import com.example.moudletest.R;

import androidx.navigation.Navigation;
import butterknife.OnClick;
import retrofit2.http.Path;

@Route(path = "/test/fragment")
public class SplashFragment extends BaseFragment {
    //资源模式
    public static final String RES_MODE = "RES_MODE";

    //获取资源模式，0:本地资源
    public static final int MODE_LOACL = 0;

    //本地资源 int数组
    public static final String LOACL_RES_LIST = "LOACL_RES_LIST";

    //获取资源模式，1:网络资源
    public static final int MODE_NET = 1;

    //网络资源 string集合
    public static final String NET_RES_LIST = "NET_RES_LIST";

    @Override
    protected int getLayoutResource() {
        return R.layout.b_main;
    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        if( bundle== null)
            return;

        int res_Mode = bundle.getInt(RES_MODE);
        switch (res_Mode){
            case MODE_LOACL:
                int[] local_Array = bundle.getIntArray(LOACL_RES_LIST);
                loadSplash(local_Array);
                break;
            case MODE_NET:
                String[] net_Array = bundle.getStringArray(NET_RES_LIST);
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

    @OnClick(R.id.textb)
    public void onViewClicked() {
        Log.d("tabhost","b=======");
        Navigation.findNavController(rootView).navigate(R.id.action_page3);
    }
}
