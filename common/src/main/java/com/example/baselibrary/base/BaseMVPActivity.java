package com.example.baselibrary.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cangwang.core.ModuleBus;
import com.example.baselibrary.util.AppManager;
import com.example.baselibrary.util.StatusBarUtil;
import com.example.baselibrary.util.TUtil;
import com.example.baselibrary.util.ToastUitl;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.ButterKnife;

public abstract class BaseMVPActivity<T extends BaseActivityPresenter, E extends ViewModel> extends RxAppCompatActivity {
    public T mPresenter;
    public E mModel;
    private Context mContext;
    private boolean isConfigChange=false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        doBeforeSetcontentView();

        //设置视图布局
        setContentView(getLayoutId());

        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
        StatusBarUtil.setRootViewFitsSystemWindows(this,isFitsSystemWindows());

        //设置状态栏透明
        StatusBarUtil.setTranslucentStatus(this);

        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
        //设置深色风格
        if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
            StatusBarUtil.setStatusBarColor(this,0x55000000/*getStatusBarColor()*/);
        }

        //ButterKnife绑定注入
        ButterKnife.bind(this);

        //模块路由绑定注入
        ARouter.getInstance().inject(this);

        //模块通信绑定
        ModuleBus.getInstance().register(this);

        mContext = this;

        //反射自动生成Presenter控制器
        mPresenter = TUtil.getT(this, 0);

        //通过子类生成Model
        mModel=this.getModel();

        if(mPresenter!=null){
            mPresenter.context=this;
        }

        //绑定android生命周期
        getLifecycle().addObserver(mPresenter);

        //初始化Presenter
        this.initPresenter();
        this.initView();
    }

    //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
    //这样半透明+白=灰, 状态栏的文字能看得清
    //protected abstract int getStatusBarColor();

    protected abstract boolean isFitsSystemWindows();

    protected abstract E getModel();


    /**
     * 设置layout前配置
     */
    private void doBeforeSetcontentView() {
        // 把actvity放到application栈中管理
        AppManager.getAppManager().addActivity(this);
        // 无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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



}
