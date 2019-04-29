package com.lantel.app.com.lantel.list;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.component_list.R;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.lantel.app.com.app.Config;
import com.lantel.app.com.lantel.list.listview.adapter.DayListAdapter;
import com.lantel.app.com.lantel.list.listview.adapter.TabAdapter;
import com.lantel.app.com.lantel.list.listview.model.DayTitleModel;
import com.lantel.app.com.lantel.list.mvp.ListContract;
import com.lantel.app.com.lantel.list.mvp.ListModel;
import com.lantel.app.com.lantel.list.mvp.ListPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.xiao360.baselibrary.base.BaseMVPActivity;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * 名单公用组件
 */
@Route(path = "/lantel/360/list")
public class ListActivity extends BaseMVPActivity<ListPresenter, ListModel> implements ListContract.View, OnRefreshLoadMoreListener {
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
    //获取传递过来的数据
    private Bundle bundle;
    //获取页面标题
    private ArrayList<String> titles;

    /**
     * 状态栏id
     */
    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }


    @Override
    protected ListModel getModel() {
        return FindModel(ListModel.class);
    }

    /**
     * 布局文件
     */
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
        attchIntent();
        //初始化状态栏，toolbar
        initToolbar();
        //初始化抽屉
        initDrawer();
        //初始化顶部tab导航菜单
        initTopTab();
        initRefreshList();
    }

    private void attchIntent() {
        //接受传递过来的相关数据
        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            //标题
            titles = bundle.getStringArrayList(Config.TAB_TITLES);
        }
    }

    private void initRefreshList() {
    //列表上下拉刷新监听
     refreshLayout.setOnRefreshLoadMoreListener(this);
     //设置列表数据
     recyclerView.setLayoutManager(new LinearLayoutManager(this));
     ArrayList<BaseModel> data = new ArrayList();
     for (int i = 0; i < 100; i++) {
         data.add(new DayTitleModel("星期"+i,"==="+i));
     }
     DayListAdapter adapter = new DayListAdapter(this);
     adapter.setDatas(data);
     recyclerView.setAdapter(adapter);
    }

    private void initTopTab() {
        //头部导航
        //添加菜单数据
        topTab.setLayoutManager(new GridLayoutManager(this,4));
        tabAdapter =  new TabAdapter(this);
        tabAdapter.setTitles(titles);
        topTab.setAdapter(tabAdapter);
    }

    private void initDrawer() {
        //监听抽屉事件
        listDrawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerClosed(View drawerView) {
               //TODO 抽屉关闭
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                //TODO 抽屉打开
            }
        });
    }

    private void initToolbar() {
        //初始化状态栏
        ImmersionBar.with(this).hideBar(BarHide.FLAG_SHOW_BAR).init();
        //设置左上图标
        topImgLeft.setImageResource(R.mipmap.ic_audio);
        //设置右上图标
        topImgRight.setImageResource(R.mipmap.ic_photo);
        //设置状态栏背景
        statebarView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        //设置Toolbar背景
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorAccent));
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
}
