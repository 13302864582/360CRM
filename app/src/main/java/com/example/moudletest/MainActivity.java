package com.example.moudletest;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.api.ApiService;
import com.example.baselibrary.mvp.BaseObserver;
import com.example.baselibrary.util.LogUtils;
import com.example.mvp.bean;
import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;

public class MainActivity extends /*BaseActivity<MainPresenter, MainModel> implements MainContract.View*/AppCompatActivity {
    @BindView(R.id.moudle_a)
    ImageView moudleA;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_main);
        ButterKnife.bind(this);
        ApiService service = Http.getInstance().createRequest(ApiService.class);
        Observable<bean> response = service.course_prepares("http://dev.xiao360.com/api/course_prepares/","base", "faf57c482b128051671de07798607a05", "one_class", "1", "1", "10");
        response.compose(RxHelper.io_main())
                .subscribe(new BaseObserver<bean>() {
                    @Override
                    public void onSuccess(bean demo) {
                        LogUtils.d("onResponse===" + demo.getData().getSql());
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        LogUtils.d("onResponse===" + e.getMessage());
                    }
                });

        Glide.with(this).load("https://avatar.csdn.net/3/7/A/3_niuba123456.jpg").into(moudleA);
        /*AnyLayer.with(this)
                .contentView(R.layout.dialog_test_2)
               .onClick(R.id.ok, new LayerManager.OnLayerClickListener() {
                   @Override
                   public void onClick(AnyLayer anyLayer, View v) {
                       Log.d("MainActivity", "onClick===ok");
                       anyLayer.dismiss();
                   }
               })
                .onClick(R.id.cancel, new LayerManager.OnLayerClickListener() {
                @Override
                 public void onClick(AnyLayer anyLayer, View v) {
                    Log.d("MainActivity", "onResponse===cancel");
                    anyLayer.dismiss(); }
        }).show();*/
        /*CommonDialog dialog = new CommonDialog();
        dialog.setLayoutId(R.layout.dialog_test_2)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, BaseDialog dialog) {

                    }
                })
                .setSize(200,100)
                .show(getSupportFragmentManager());*/
        /*new MaterialDialog.Builder(MainActivity.this)
                .title("标题")
                .content("内容")
               *//* .positiveText("确认")
                .negativeText("取消")*//*
                .show();*/
    }

    /* @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;

    @Override
    protected MainModel getModel() {
        return FindModel(MainModel.class);
        *//*return FindModel(MainModel.class,new LifeCycleActivityFactory(this));*//*
    }

    @Override
    public int getLayoutId() {
        return R.layout.app_main;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    public void initView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(mPresenter);
        bottomNavigationView.setItemTextAppearanceActive(R.style.bottom_selected_text);
        bottomNavigationView.setItemTextAppearanceInactive(R.style.bottom_normal_text);
        bottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        bottomNavigationView.setSelectedItemId(R.id.item_bottom_2);
    }

    @ModuleEvent(coreClientClass = IBaseClient.class)
    public void fun(String s,int i) {
        *//* Do something *//*
        Log.d("bus", s+"==="+i);
    };

    @Override
    public void show(String msg) {

    }*/
}
