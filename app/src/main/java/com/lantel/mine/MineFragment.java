package com.lantel.mine;

import com.xiao360.baselibrary.base.BaseMVPFragment;
import com.xiao360.baselibrary.base.BaseModel;
import com.example.moudletest.R;
import com.example.moudletest.R2;
import com.lantel.mine.list.adpter.MineRecycleViewAdapter;
import com.lantel.mine.mvp.MineContract;
import com.lantel.mine.mvp.MineModel;
import com.lantel.mine.mvp.MinePresenter;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class MineFragment extends BaseMVPFragment<MinePresenter, MineModel> implements MineContract.View,MineRecycleViewAdapter.OnMenuClickListener {
    @BindView(R2.id.mine_Recycleview)
    RecyclerView mineRecycleview;

    private MineRecycleViewAdapter adapter;

    @Override
    protected int getBackgroundColor() {
        return android.R.color.white;
    }

    @Override
    protected MineModel getModel() {
        return FindModel(MineModel.class);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.moudle_mine;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        mineRecycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MineRecycleViewAdapter(getContext(), null);
        adapter.setOnMenuClickListener(this);
        mineRecycleview.setAdapter(adapter);
    }

    @Override
    public void notifyData(ArrayList<BaseModel> list) {
        adapter.refreshData(list);
    }

    /**
     * 菜单点击跳转**
     */
    @Override
    public void onMenuClick(int action) {
        switch (action){
            case MineRecycleViewAdapter.ACTION_FILE:
                LogUtils.d("ACTION_FILE");
                break;
            case MineRecycleViewAdapter.ACTION_CHANNEL:
                LogUtils.d("ACTION_CHANNEL");
                break;
            case MineRecycleViewAdapter.ACTION_OUTPUT:
                LogUtils.d("ACTION_OUTPUT");
                break;
            case MineRecycleViewAdapter.ACTION_ROLE_PERMISSION:
                LogUtils.d("ACTION_ROLE_PERMISSION");
                break;
            case MineRecycleViewAdapter.ACTION_FEEDBACK:
                LogUtils.d("ACTION_FEEDBACK");
                break;
        }
    }
}
