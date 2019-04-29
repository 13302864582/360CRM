package com.lantel.home;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.moudletest.R;
import com.lantel.AppConfig;
import com.lantel.common.fragment.TbHeadListFragment;
import com.lantel.home.list.adpter.HomeMenuAdapter;
import com.lantel.home.list.adpter.HomeRecycleViewAdapter;
import com.lantel.home.list.listener.onMenuMoreListener;
import com.lantel.home.mvp.HomeContract;
import com.lantel.home.mvp.HomeModel;
import com.lantel.home.mvp.HomePresenter;
import com.qiniu.android.common.FixedZone;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.LogUtils;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;
import org.json.JSONObject;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by 冯支.
 * function:
 * Date: 2019/4/26
 * Time: 14:50
 */
public class HomeFragment extends TbHeadListFragment<HomePresenter, HomeModel> implements HomeContract.View {
    private HomeRecycleViewAdapter adapter;

    @Override
    protected void initViewSelf() {
        /***
         * 设置左右上角的图片，取消红点
         */
        topImgLeft.setImageResource(R.mipmap.scan);
        topImgRight.setImageResource(R.mipmap.add);
        topRedpoint.setVisibility(View.GONE);
        statebarView.setBackgroundResource(R.mipmap.statebar_bg);
        toolbar.setBackgroundResource(R.mipmap.toolbar_bg);
    }

    @Override
    protected int getTitle() {
        /**
         * 设置顶部标题
         */
        return R.string.tabhost_home;
    }

    @Override
    protected void clickTopLeft() {
        //TODO 主页左边点击事件
        /**
         * 点击扫描按钮，进入扫一扫二级页面
         */
        Intent intent = new Intent(getContext(), CaptureActivity.class);
        /*ZxingConfig是配置类
         *可以设置是否显示底部布局，闪光灯，相册，
         * 是否播放提示音  震动
         * 设置扫描框颜色等
         * 也可以不传这个参数
         * */
        ZxingConfig config = new ZxingConfig();
        config.setPlayBeep(true);//是否播放扫描声音 默认为true
        config.setShake(false);//是否震动  默认为true
        config.setDecodeBarCode(true);//是否扫描条形码 默认为true
        /*config.setReactColor(R.color.colorAccent);//设置扫描框四个角的颜色 默认为白色
        config.setFrameLineColor(R.color.colorAccent);//设置扫描框边框颜色 默认无色
        config.setScanLineColor(R.color.colorAccent);//设置扫描线的颜色 默认白色*/
        config.setFullScreenScan(false);//是否全屏扫描  默认为true  设为false则只会在扫描框中扫描
        intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
        startActivityForResult(intent, AppConfig.REQUEST_CODE_SCAN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * 扫描二维码/条码回传
         */
        if (requestCode == AppConfig.REQUEST_CODE_SCAN && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                String content = data.getStringExtra(Constant.CODED_CONTENT);
                LogUtils.d("扫描结果为：" + content);
            }
        }
    }

    @Override
    protected void clickTopRight() {
        //TODO 主页右边点击事件
        Configuration config = new Configuration.Builder()
                .chunkSize(512 * 1024)        // 分片上传时，每片的大小。 默认256K
                .putThreshhold(1024 * 1024)   // 启用分片上传阀值。默认512K
                .connectTimeout(10)           // 链接超时。默认10秒
                .useHttps(true)               // 是否使用https上传域名
                .responseTimeout(60)          // 服务器响应超时。默认60秒
                /* .recorder(recorder)           // recorder分片上传时，已上传片记录器。默认null
                 .recorder(recorder, keyGen)   // keyGen 分片上传时，生成标识符，用于片记录器区分是那个文件的上传记录*/
                .zone(FixedZone.zone2)        // 设置区域，指定不同区域的上传域名、备用域名、备用IP。
                .build();

        // 重用uploadManager。一般地，只需要创建一个uploadManager对象
        UploadManager uploadManager = new UploadManager(config);
        String str = "fz";
        byte[] bs = str.getBytes();
        uploadManager.put(bs, "fztest.txt", "p9mUPzEN5ihLHctwvBIk5w9MBckHvFSrXadVRlPY:4g38GIZD-mQeO7sf5vhst2cpb5Q=:eyJzY29wZSI6Inlnd3FtcyIsImRlYWRsaW5lIjoxNTU2MzQzNTY0fQ==", new UpCompletionHandler() {
            @Override
            public void complete(String key, ResponseInfo info, JSONObject response) {
                LogUtils.d("====Uploadcomplete====key:" + key + "===info:" + info.toString() + "===" + response.toString());
            }
        }, null);
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        /**
         * 设置主页适配器
         */
        adapter = new HomeRecycleViewAdapter(getContext(), null);
        adapter.setmListener(new onMenuMoreListener() {
            /**
             * 菜单点击选项
             */
            @Override
            public void onItemClick(int position) {
                LogUtils.d(position + "===============onMenuClick");
            }

            /**
             * 菜单点击更多
             */
            @Override
            public void onMoreClick() {
                LogUtils.d("===============onMoreClick");
            }
        });
        return adapter;
    }

    /**
     * 共享model
     */
    @Override
    protected HomeModel getModel() {
        return FindModel(HomeModel.class);
    }


    /**
     * Presenter控制器，设置view,model接口
     */
    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }


    /**
     * view接口回调，notifyData
     */
    @Override
    public void notifyData(ArrayList<BaseModel> list) {
        adapter.refreshData(list);
    }
}
