package com.lantel.mine;

import android.view.View;
import com.example.moudletest.R;
import com.lantel.AppConfig;
import com.lantel.common.fragment.TbHeadListFragment;
import com.lantel.mine.list.adpter.MineRecycleViewAdapter;
import com.lantel.mine.mvp.MineContract;
import com.lantel.mine.mvp.MineModel;
import com.lantel.mine.mvp.MinePresenter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.listview.listener.OnMenuClickListener;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;

public class MineFragment extends TbHeadListFragment<MinePresenter, MineModel> implements MineContract.View, OnMenuClickListener {
    private MineRecycleViewAdapter adapter;

    @Override
    protected void initViewSelf() {
        topImgLeft.setImageResource(R.mipmap.my_head_mess);
        topImgRight.setImageResource(R.mipmap.my_head_setting);
        statebarView.setBackgroundResource(R.mipmap.statebar_bg);
        toolbar.setBackgroundResource(R.mipmap.toolbar_bg);
    }

    @Override
    protected int getTitle() {
        return R.string.tabhost_mine;
    }

    @Override
    protected void clickTopLeft() {
        topRedpoint.setVisibility(View.INVISIBLE);
        LogUtils.d("===============top_img_left");
    }

    @Override
    protected void clickTopRight() {
        LogUtils.d("===============clickTopRight");
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        adapter = new MineRecycleViewAdapter(getContext(), null);
        adapter.setOnMenuClickListener(this);
        return adapter;
    }

    @Override
    public void notifyData(ArrayList<BaseModel> list) {
        adapter.refreshData(list);
    }

    @Override
    protected MineModel getModel() {
        return FindModel(MineModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void onItemClick(int position) {
        switch (position) {
            case AppConfig.ACTION_FILE:
                LogUtils.d("ACTION_FILE");
                break;
            case AppConfig.ACTION_CHANNEL:
                LogUtils.d("ACTION_CHANNEL");
                break;
            case AppConfig.ACTION_OUTPUT:
                LogUtils.d("ACTION_OUTPUT");
                break;
            case AppConfig.ACTION_ROLE_PERMISSION:
                LogUtils.d("ACTION_ROLE_PERMISSION");
                break;
            case AppConfig.ACTION_FEEDBACK:
                LogUtils.d("ACTION_FEEDBACK");
                break;
        }
    }
}
