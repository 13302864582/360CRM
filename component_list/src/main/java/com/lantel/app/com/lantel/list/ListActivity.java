package com.lantel.app.com.lantel.list;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.component_list.R;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.lantel.app.com.lantel.list.listview.adapter.TabAdapter;
import com.lantel.app.com.lantel.list.mvp.ListContract;
import com.lantel.app.com.lantel.list.mvp.ListModel;
import com.lantel.app.com.lantel.list.mvp.ListPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.xiao360.baselibrary.base.BaseMVPActivity;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * 名单公用组件
 */
@Route(path = "/lantel/360/list")
public class ListActivity extends BaseMVPActivity<ListPresenter, ListModel> implements ListContract.View, OnRefreshLoadMoreListener, DrawerLayout.DrawerListener {
    @BindView(R.id.statebarView)
    View statebarView;
    @BindView(R.id.top_img_left)
    ImageView topImgLeft;
    @BindView(R.id.top_redpoint)
    ImageView topRedpoint;
    @BindView(R.id.top_title)
    TextView topTitle;
    @BindView(R.id.top_img_right)
    ImageView topImgRight;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.top_tab)
    RecyclerView topTab;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.drawer)
    ConstraintLayout drawer;
    @BindView(R.id.list_drawerLayout)
    DrawerLayout listDrawerLayout;

    private TabAdapter tabAdapter;

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    protected ListModel getModel() {
        return FindModel(ListModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.filter_list;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        //初始化状态栏
        ImmersionBar.with(this)
                .hideBar(BarHide.FLAG_SHOW_BAR)
                .init();

        String mess = getIntent().getExtras().getString("mess");

        //初始化状态栏，toolbar
        statebarView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        //监听抽屉事件
        listDrawerLayout.addDrawerListener(this);
        LogUtils.d("ListActivity========" + mess);

        //头部导航
        //添加菜单数据
        String[] titles = getResources().getStringArray(R.array.tab_market_title);
        topTab.setLayoutManager(new GridLayoutManager(this,4));
        tabAdapter =  new TabAdapter(this,null);
        tabAdapter.setTitles(titles);
        topTab.setAdapter(tabAdapter);

       /* //列表上下拉刷新监听
        refreshLayout.setOnRefreshLoadMoreListener(this);
        //设置列表数据
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList data = new ArrayList();
        for (int i = 0; i < 100; i++) {
            data.add(i);
        }
        recyclerView.setAdapter(new TabAdapter(this, data));*/
    }

    /**
     * 上拉加载更多
     */
    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        //refreshLayout.finishLoadMore();
    }

    /**
     * 下拉刷新数据
     */
    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        LogUtils.d("ListActivity========onRefresh====");
        /*ArrayList data = new ArrayList();
        for (int i = 0; i < 5; i++) {
            data.add(i);
        }
        recyclerView.setAdapter(new ListAdapter(this, data));
        refreshLayout.finishRefresh();*/
    }

    /**
     * 当抽屉被滑动的时候调用此方法
     * arg1 表示 滑动的幅度（0-1）
     */
    @Override
    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

    }

    /**
     * 当一个抽屉被完全打开的时候被调用
     */
    @Override
    public void onDrawerOpened(@NonNull View drawerView) {

    }

    /**
     * 当一个抽屉被完全关闭的时候被调用
     */
    @Override
    public void onDrawerClosed(@NonNull View drawerView) {

    }

    /**
     * 当抽屉滑动状态改变的时候被调用
     * 状态值是STATE_IDLE（闲置--0）, STATE_DRAGGING（拖拽的--1）, STATE_SETTLING（固定--2）中之一。
     * 抽屉打开的时候，点击抽屉，drawer的状态就会变成STATE_DRAGGING，然后变成STATE_IDLE
     */
    @Override
    public void onDrawerStateChanged(int newState) {

    }
}
