package com.lantel.app.com.lantel.list;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.component_list.R;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.lantel.app.com.app.Config;
import com.lantel.app.com.lantel.list.listview.adapter.DayListAdapter;
import com.lantel.app.com.lantel.list.listview.adapter.TabAdapter;
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
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
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
public class ListActivity extends BaseMVPActivity<ListPresenter, ListModel> implements ListContract.View, OnRefreshLoadMoreListener, View.OnClickListener, TextWatcher {
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
    @BindView(R.id.filter_drawer)
    ImageView filterDrawer;
    @BindView(R.id.filter_edit)
    SearchView filterEdit;
    @BindView(R.id.search_layout)
    LinearLayout search_layout;
    @BindView(R.id.search_txt)
    TextView search_txt;
    @BindView(R.id.search_btn)
    AppCompatButton search_button;

    //tab菜单适配器
    private TabAdapter tabAdapter;

    //获取页面标题
    private ArrayList<String> titles;

    //列表适配器
    private DayListAdapter mRefreshAdapter;

    //toolbar标题
    private String toolbarTitle;

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
        //TODO 整理lauout内部，searchview
        return R.layout.filter_list;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    /**
     * 初始化view
     */
    @Override
    public void initView() {
        attchIntent();
        //初始化状态栏，toolbar
        initToolbar();
        //初始化抽屉
        initDrawer();
        //初始化searchview
        initSearchView();
        //初始化顶部tab导航菜单
        initTopTab();
        initRefreshList();
    }

    /**
     * 接受传递过来的相关数据
     */
    private void attchIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            //toolbar标题
            toolbarTitle = bundle.getString(Config.TOOLBAR_TITLE);
            //tab标题
            titles = bundle.getStringArrayList(Config.TAB_TITLES);
        }
    }


    /**
     * 初始化列表
     */
    private void initRefreshList() {
        //列表上下拉刷新监听
        refreshLayout.setOnRefreshLoadMoreListener(this);
        //设置列表数据
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRefreshAdapter = new DayListAdapter(this);
        recyclerView.setAdapter(mRefreshAdapter);
    }


    /**
     * 初始化抽屉
     */
    private void initDrawer() {
        filterDrawer.setOnClickListener((View view) -> {
            listDrawerLayout.openDrawer(drawer);
        });
        //禁止手动滑动
        listDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
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

    /**
     * 初始化toolbar
     */
    private void initToolbar() {
        //初始化状态栏
        ImmersionBar.with(this).hideBar(BarHide.FLAG_SHOW_BAR).init();
        //设置左上图标
        topImgLeft.setImageResource(R.mipmap.ic_audio);
        topImgLeft.setOnClickListener(this);
        //设置右上图标
        topImgRight.setImageResource(R.mipmap.ic_photo);
        topImgRight.setOnClickListener(this);
        //设置状态栏背景
        statebarView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        //设置Toolbar背景
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        if (toolbarTitle != null)
            topTitle.setText(toolbarTitle);
    }

    /**
     * 初始化tab导航
     */
    private void initTopTab() {

        //头部导航
        //初始化菜单数据
        topTab.setLayoutManager(new GridLayoutManager(this, 4));
        tabAdapter = new TabAdapter(this);
        if (titles != null)
            tabAdapter.setTitles(titles);
        topTab.setAdapter(tabAdapter);
    }

    /**
     * 初始化搜索栏
     */
    private void initSearchView() {
        search_button.setOnClickListener(this);

        //searchview设置搜索监听，不显示放大镜
        filterEdit.setIconifiedByDefault(false);
        ImageView searchViewIcon = filterEdit.findViewById(R.id.search_mag_icon);
        ViewGroup linearLayoutSearchView = (ViewGroup) searchViewIcon.getParent();
        linearLayoutSearchView.removeView(searchViewIcon);
        final EditText editText = filterEdit.findViewById(R.id.search_src_text);
        editText.addTextChangedListener(this);
        editText.setOnEditorActionListener((TextView v, int actionId, KeyEvent event) -> {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        //搜索逻辑
                        search_txt.performClick();
                    }
                    return true;
                }
        );
        filterEdit.setOnQueryTextFocusChangeListener((View view, boolean b)-> {
                if (!b) {
                    editText.getText().clear();
                    FilterText("");
                }
            }
        );

    }

    /**
     * 上拉加载事件
     */
    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        //refreshLayout.finishLoadMore();
    }

    /**
     * 下拉刷新事件
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
     * 下拉刷新数据
     */
    @Override
    public void refreshListData(ArrayList<BaseModel> data) {
        mRefreshAdapter.setDatas(data);
        mRefreshAdapter.notifyDataSetChanged();
    }


    /**
     * 上拉加载数据
     */
    @Override
    public void loadMoreListData(ArrayList<BaseModel> data) {
        if (data == null || data.size() == 0)
            return;
        int start = mRefreshAdapter.getItemCount();
        mRefreshAdapter.addDatas(data);
        mRefreshAdapter.notifyItemRangeInserted(start, data.size());
    }


    /**
     * 刷新tab菜单全部数据
     */
    @Override
    public void refreshTabData(ArrayList<BaseModel> data) {
        tabAdapter.setDatas(data);
        tabAdapter.notifyDataSetChanged();
    }

    /**
     * 根据搜索刷新数据
     */
    @Override
    public void filterListData(CharSequence search) {
        mRefreshAdapter.getFilter().filter(search);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.search_btn) {
            search_button.setVisibility(View.GONE);
            search_layout.setVisibility(View.VISIBLE);
            filterEdit.setFocusable(true);//设置输入框可聚集
            filterEdit.requestFocus();//请求焦点
            filterEdit.onActionViewExpanded();
        } else if (id == R.id.top_img_left) {
            finish();
        } else if (id == R.id.top_img_right) {

        }
    }

    private void FilterText(CharSequence newText) {
        filterEdit.setFocusable(false);//设置输入框不可聚焦，即失去焦点和光标
        filterEdit.clearFocus();
        search_button.setVisibility(View.VISIBLE);
        search_layout.setVisibility(View.GONE);
        filterListData(newText);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        search_txt.setEnabled(true);
        search_txt.setOnClickListener((View view) -> {
            FilterText(charSequence);
        });
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
