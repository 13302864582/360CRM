package com.lantel.app.com.lantel.personmess.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.utils.TextUtils;
import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnDismissListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.example.component_list.R;
import com.gyf.immersionbar.BarHide;
import com.lantel.app.com.app.Config;
import com.xiao360.baselibrary.base.BaseMVPActivity;
import com.xiao360.baselibrary.edit.EditStateLayout;
import com.xiao360.baselibrary.edit.listener.OnSaveListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModel;
import butterknife.BindView;

@Route(path = "/lantel/360/edit")
public class EditActivity extends BaseMVPActivity implements View.OnClickListener, OnSaveListener ,OnDismissListener,OnTimeSelectListener,OnItemSelectedListener{
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
    @BindView(R.id.top_txt_right)
    TextView topTxtRight;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edit_state)
    EditStateLayout editState;

    private int actionType = Config.ACTION_EDIT_TEXT;
    private String title;
    private String tip;
    private ArrayList<String> mOptionsItems;
    private String resultStr = "";

    @Override
    protected BarHide hideBar() {
        return BarHide.FLAG_SHOW_BAR;
    }

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    protected ViewModel getModel() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_edit;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        attchIntent();
        initToolbar();
    }

    private void initToolbar() {
        topImgLeft.setImageResource(R.mipmap.plus);
        topImgLeft.setOnClickListener(this);
        topImgRight.setVisibility(View.GONE);

        if(!TextUtils.isEmpty(title)) {
            topTitle.setText(title);
            topTitle.setTextColor(getResColor(R.color.person_toolbar_title));
        }

        statebarView.setBackgroundColor(getResColor(R.color.colorPrimary));
        toolbar.setBackgroundColor(getResColor(R.color.colorPrimary));
    }

    /**
     * 接受传递过来的相关数据
     */
    private void attchIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            //编辑的action
            actionType = bundle.getInt(Config.ACTION_EDIT, Config.ACTION_EDIT_TEXT);

            //toolbar标题
            title = bundle.getString(Config.TOOLBAR_TITLE,Config.STR_DEFAULT);

            //编辑提示
            tip = bundle.getString(Config.EDIT_TIP,Config.STR_DEFAULT);
        }
        editState.setSaveListener(this);
        handleType(actionType,bundle);
    }

    /**
     * 根据action显示界面
     */
    private void handleType(int actionType, Bundle bundle) {
        switch (actionType){
            case Config.ACTION_EDIT_TEXT:
                String strDefault = bundle.getString(Config.EDIT_TEXT_DEFAULT,Config.STR_DEFAULT);
                editState.showTextEditView(strDefault,tip);
                break;
            case Config.ACTION_EDIT_DATE:
                showTimePick();
                break;
            case Config.ACTION_EDIT_SELETE:
                editState.showTextPickView();
                mOptionsItems = bundle.getStringArrayList(Config.EDIT_OPTIONS);
                if(mOptionsItems == null){
                    mOptionsItems = new ArrayList();
                }
                WheelView wheelView = editState.getView(R.id.wheelview);
                wheelView.setCyclic(true);
                wheelView.setAdapter(new ArrayWheelAdapter(mOptionsItems));
                wheelView.setOnItemSelectedListener(this);
                editState.getView(R.id.btn_save_pick).setOnClickListener(this);
                break;
        }
    }

    private void showTimePick() {
        editState.showDatePickView();
        //时间选择器
        Calendar calendar = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        //正确设置方式 原因：注意事项有说明
        startDate.set(1993,0,1);
        endDate.set(2020,11,31);
        TimePickerView timePicker = new TimePickerBuilder(this,this)
                .setType(new boolean[]{true, true, true,false,false,false})//分别对应年月日时分秒，默认全部显示
                .setCancelText(getString(R.string.pickerview_cancel))//取消按钮文字
                .setSubmitText(getString(R.string.pickerview_submit))//确认按钮文字
                .setContentTextSize(25)//滚轮文字大小
                .setTitleSize(28)//标题文字大小
                .setTitleText(title)//标题文字
                .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(true)//是否循环滚动
                .setDate(calendar)
                .setRangDate(startDate,endDate)
                .setLabel("年","月","日","时","分","秒")
                .isDialog(false)
                .setDecorView((ViewGroup) editState.getDate_pick())
                .build();//是否显示为对话框样式
        timePicker.setOnDismissListener(this);
        timePicker.show();
    }

    private void onResult(boolean exit) {
        Intent intent = new Intent();
        intent.putExtra(Config.RESULT_TEXT,resultStr);
        setResult(RESULT_OK,intent);
        if(exit)
            finish();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.top_img_left) {
            finish();
        }else if(id == R.id.btn_save_pick){
            onResult(true);
        }
    }

    @Override
    public void onSaveEditText(String text) {
        resultStr = text;
        onResult(true);
    }

    @Override
    public void onDismiss(Object o) {
        finish();
    }

    @Override
    public void onTimeSelect(Date date, View v) {
        // 格式化日期
        String dateText = (String) DateFormat.format("yyyy-MM-dd", date);
        resultStr = dateText;
        onResult(false);
    }

    @Override
    public void onItemSelected(int index) {
        resultStr = mOptionsItems.get(index);
    }

    /** .setTitleColor(Color.BLACK)//标题文字颜色
     .setSubmitColor(Color.BLUE)//确定按钮文字颜色
     .setCancelColor(Color.BLUE)//取消按钮文字颜色
     .setTitleBgColor(0xFF666666)//标题背景颜色 Night mode
     .setBgColor(0xFF333333)//滚轮背景颜色 Night mode
     .setRange(calendar.get(Calendar.YEAR) - 20, calendar.get(Calendar.YEAR) + 20)//默认是1900-2100年
     .setDate(selectedDate)// 如果不设置的话，默认是系统时间
     .setRangDate(startDate,endDate)//起始终止年月日设定
     **/
}
