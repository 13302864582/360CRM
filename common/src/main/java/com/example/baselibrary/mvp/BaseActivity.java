package com.example.baselibrary.mvp;


import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cangwang.core.ModuleBus;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.ButterKnife;


public abstract class BaseActivity<T extends BaseActivityPresenter, E extends ViewModel> extends RxAppCompatActivity {
    public T mPresenter;
    public E mModel;
    private Context mContext;
    private boolean isConfigChange=false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doBeforeSetcontentView();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        ModuleBus.getInstance().register(this);
        mContext = this;
        mPresenter = TUtil.getT(this, 0);
        mModel=this.getModel();
        if(mPresenter!=null){
            mPresenter.context=this;
        }
        getLifecycle().addObserver(mPresenter);
        this.initPresenter();
        this.initView();
    }

    protected abstract E getModel();


    /**
     * 设置layout前配置
     */
    private void doBeforeSetcontentView() {
        //设置昼夜主题
        //initTheme();
        // 把actvity放到application栈中管理
        AppManager.getAppManager().addActivity(this);
        // 无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // 默认着色状态栏
        //SetStatusBarColor();

    }
    /*********************子类实现*****************************/
    //获取布局文件
    public abstract int getLayoutId();
    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();
    //初始化view
    public abstract void initView();

    /**
     * 通过Class跳转界面
     **/
    public void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 开启浮动加载进度条
     */
   /* public void startProgressDialog() {
        LoadingDialog.showDialogForLoading(this);
    }*/

    /**
     * 开启浮动加载进度条
     *
     * @param msg
     */
    /*public void startProgressDialog(String msg) {
        LoadingDialog.showDialogForLoading(this, msg, true);
    }*/

    /**
     * 停止浮动加载进度条
     */
    /*public void stopProgressDialog() {
        LoadingDialog.cancelDialogForLoading();
    }*/

    /**
     * 短暂显示Toast提示(来自String)
     **/
    public void showShortToast(String text) {
        ToastUitl.showShort(text);
    }

    /**
     * 短暂显示Toast提示(id)
     **/
    public void showShortToast(int resId) {
        ToastUitl.showShort(resId);
    }

    /**
     * 长时间显示Toast提示(来自res)
     **/
    public void showLongToast(int resId) {
        ToastUitl.showLong(resId);
    }

    /**
     * 长时间显示Toast提示(来自String)
     **/
    public void showLongToast(String text) {
        ToastUitl.showLong(text);
    }
    /**
     * 带图片的toast
     * @param text
     * @param res
     */
   /* public void showToastWithImg(String text,int res) {
        ToastUitl.showToastWithImg(text,res);
    }*/
    /**
     * 网络访问错误提醒
     */
    /*public void showNetErrorTip() {
        ToastUitl.showToastWithImg(getText(R.string.net_error).toString(),R.drawable.ic_wifi_off);
    }
    public void showNetErrorTip(String error) {
        ToastUitl.showToastWithImg(error,R.drawable.ic_wifi_off);
    }*/


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        isConfigChange=true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ModuleBus.getInstance().unregister(this);
        if(!isConfigChange){
            AppManager.getAppManager().finishActivity(this);
        }
    }

    protected E FindModel(Class<E> modelClass, ViewModelProvider.Factory factory) {
        return ViewModelProviders.of(this,factory).get(modelClass);
    }

    protected E FindModel(Class<E> modelClass) {
        return ViewModelProviders.of(this).get(modelClass);
    }
}
