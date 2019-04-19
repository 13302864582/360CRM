package com.lantel.mine;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;

import com.example.baselibrary.base.BaseMVPFragment;
import com.example.moudletest.R;
import com.example.moudletest.R2;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lantel.mine.list.MenuItem;
import com.lantel.mine.list.MineRecycleViewAdapter;
import com.lantel.mine.mvp.MineContract;
import com.lantel.mine.mvp.MineModel;
import com.lantel.mine.mvp.MinePresenter;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class MineFragment extends BaseMVPFragment<MinePresenter, MineModel> implements MineContract.View {
    @BindView(R2.id.mine_Recycleview)
    RecyclerView mineRecycleview;

    /*@BindView(R2.id.mine_RefreshLayout)
    SmartRefreshLayout mineRefreshLayout;*/
    @BindView(R2.id.bottom_navigation)
    BottomNavigationView mineRefreshLayout;

    private MineRecycleViewAdapter adapter;

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
        mineRefreshLayout.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull android.view.MenuItem menuItem) {
                Log.d("MineFragmenttab","onTabSelect====="+menuItem.getTitle());
                return true;
            }
        });
       /* mineRefreshLayout.getMenu().findItem(R.id.item_bottom_4).setVisible(false);
        mineRefreshLayout.getMenu().findItem(R.id.item_bottom_3).setVisible(false);*/

        Resources resource = getResources();
        String[] titles = resource.getStringArray(R.array.mine_menu_title);
        TypedArray icons = resource.obtainTypedArray(R.array.mine_menu_icon);

        List<MenuItem> list = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            MenuItem menuItem = new MenuItem();
            menuItem.setText(titles[i]);
            menuItem.setIcon(icons.getResourceId(i, 0));
            list.add(menuItem);
        }

        adapter = new MineRecycleViewAdapter(MineFragment.this.getContext(), list);
        mineRecycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        mineRecycleview.setAdapter(adapter);
    }

    @Override
    public void setData(List list) {
        /*adapter = new MineRecycleViewAdapter(this.getContext(),list);
        mineRecycleview.setAdapter(adapter);*/
        adapter.loadData(list);
    }

    @Override
    public void notifyData(ArrayList<MenuItem> list) {
        adapter.refreshData(list);
    }
}
