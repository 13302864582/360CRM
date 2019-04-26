package com.lantel.home.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moudletest.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by 冯支
 * function:主页头布局holder
 * Date: 2019/4/24
 */
public class HomeHeadViewHolder extends BaseViewHolder {
    public ImageView user_img;
    public TextView user_name;
    public TextView user_area;
    public TextView scheldue_txt;
    public TextView homeday_txt;
    public TextView renew_txt;


    public HomeHeadViewHolder(View view) {
        super(view);
        user_img = getView(R.id.top_img_personal);
        user_name = getView(R.id.top_personal_name);
        user_area = getView(R.id.top_area_txt);
        scheldue_txt = getView(R.id.top_schedule_num_txt);
        homeday_txt = getView(R.id.top_homework_num_txt);
        renew_txt = getView(R.id.top_renew_num_txt);
    }
}
