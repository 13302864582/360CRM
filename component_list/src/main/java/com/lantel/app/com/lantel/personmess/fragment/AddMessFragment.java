package com.lantel.app.com.lantel.personmess.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cangwang.core.IBaseClient;
import com.cangwang.core.ModuleBus;
import com.example.component_list.R;
import com.lantel.app.com.lantel.personmess.fragment.adapter.AddMessAdapter;
import com.lantel.app.com.lantel.personmess.fragment.mvp.add.AddContract;
import com.lantel.app.com.lantel.personmess.fragment.mvp.add.AddModel;
import com.lantel.app.com.lantel.personmess.fragment.mvp.add.AddPresenter;
import com.xiao360.baselibrary.base.BaseMVPFragment;
import com.xiao360.baselibrary.base.BaseModel;

import java.util.ArrayList;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class AddMessFragment extends BaseMVPFragment<AddPresenter, AddModel> implements AddContract.View {
    @BindView(R.id.top_img_left)
    ImageView topImgLeft;
    @BindView(R.id.top_title)
    TextView topTitle;
    @BindView(R.id.top_img_right)
    ImageView topImgRight;
    @BindView(R.id.top_txt_right)
    TextView topTxtRight;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.mess_list)
    RecyclerView messList;
    @BindView(R.id.statebarView)
    View statebarView;
    private AddMessAdapter mAdapter;

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    protected AddModel getModel() {
        return FindModel(AddModel.class);
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.person_add_mess;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        initToolbar();
        initList();
    }

    private void initList() {
        messList.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new AddMessAdapter(getContext(),null);
        messList.setAdapter(mAdapter);
    }

    private void initToolbar() {
        topImgLeft.setImageResource(R.mipmap.ic_photo);

        topImgRight.setVisibility(View.GONE);
        topTxtRight.setVisibility(View.VISIBLE);
        topTxtRight.setText(getString(R.string.done));

        topTitle.setText(getString(R.string.add_mess));
        topTitle.setTextColor(getResources().getColor(R.color.person_toolbar_title));

        statebarView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }

    @OnClick({R.id.top_img_left, R.id.top_txt_right})
    public void onViewClicked(View view) {
        int id = view.getId();
        if(id == R.id.top_img_left){
            ModuleBus.getInstance().post(IBaseClient.class,"onback","add");
        }else if(id == R.id.top_txt_right){

        }
    }

    @Override
    public void refreshList(ArrayList<BaseModel> list) {
        mAdapter.setDatas(list);
        mAdapter.notifyDataSetChanged();
    }
}
