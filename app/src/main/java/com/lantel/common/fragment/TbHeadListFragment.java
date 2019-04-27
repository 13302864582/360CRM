package com.lantel.common.fragment;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moudletest.R;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.base.BaseMVPActivity;
import com.xiao360.baselibrary.base.BaseMVPFragment;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;


public abstract class TbHeadListFragment<T extends BaseFragmentPresenter, E extends ViewModel> extends BaseMVPFragment<T, E> {
    @BindView(R.id.top_img_left)
    protected ImageView topImgLeft;
    @BindView(R.id.top_redpoint)
    protected ImageView topRedpoint;
    @BindView(R.id.top_title)
    protected TextView topTitle;
    @BindView(R.id.top_img_right)
    protected ImageView topImgRight;
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    @BindView(R.id.recycleview)
    protected RecyclerView recycleview;
    @BindView(R.id.statebarView)
    protected View statebarView;

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.moudle_mine;
    }

    @Override
    protected void initView() {
        topTitle.setText(getString(getTitle()));
        ((BaseMVPActivity) getActivity()).setSupportActionBar(toolbar);
        recycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleview.setAdapter(getAdapter());
        initViewSelf();
    }

    protected abstract void initViewSelf();

    @OnClick({R.id.top_img_left, R.id.top_img_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_img_left:
                clickTopLeft();
                break;
            case R.id.top_img_right:
                clickTopRight();
                break;
        }
    }

    protected abstract int getTitle();

    protected abstract void clickTopLeft();

    protected abstract void clickTopRight();

    protected abstract RecyclerView.Adapter getAdapter();
}
