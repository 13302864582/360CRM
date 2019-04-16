package com.example.moudleb;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselibrary.mvp.BaseActivity;
import androidx.lifecycle.ViewModel;
import butterknife.OnClick;

@Route(path = "/apptwo/moudleB/activityB")
public class MainActivityB extends BaseActivity {
    @Override
    protected ViewModel getModel() {
        return null;
        //return FindModel(BModel.class,new AMoudleFactory(this));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main_b;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

    }

    @OnClick(R2.id.fzb)
    public void onViewClicked() {
        // 2. 跳转并携带参数
        ARouter.getInstance().build("/appone/moudleA/activityA")
                .withLong("key1", 666L)
                .withString("key2", "888")
                .navigation();
    }
}
