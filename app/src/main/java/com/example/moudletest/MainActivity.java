package com.example.moudletest;


import android.os.Bundle;
import android.util.Log;
import com.example.api.ApiService;
import com.example.baselibrary.mvp.BaseObserver;
import com.example.mvp.bean;
import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends /*BaseActivity<MainPresenter, MainModel> implements MainContract.View*/AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_main);
        ApiService service = Http.getInstance().createRequest(ApiService.class);
        Observable<bean> response = service.course_prepares("one_class","1","1","10");
        response.compose(RxHelper.io_main())
                .subscribe(new BaseObserver<bean>() {
                    @Override
                    public void onSuccess(bean demo) {
                        Log.d("MainActivity", "onResponse==="+demo.getData().getSql());
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        Log.d("MainActivity", "onResponse==="+e.getMessage());
                    }
                });
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
