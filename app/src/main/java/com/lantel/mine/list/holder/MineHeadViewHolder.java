package com.lantel.mine.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moudletest.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by 冯支
 * function: 菜单ITEM布局holder
 * Date: 2019/4/23
 */
public class MineHeadViewHolder extends BaseViewHolder {
    public ImageView top_circle_personal;
    //public TextView top_title;
    public TextView top_personal_name;
    public TextView top_personal_area;
    public RecyclerView top_grid_position;

    public MineHeadViewHolder(View view) {
        super(view);
        //top_title = getView(R.id.top_title);
        top_circle_personal = getView(R.id.top_img_circle_personal);
        top_grid_position = getView(R.id.grid_position);
        top_personal_name = getView(R.id.top_personal_name);
        top_personal_area = getView(R.id.top_personal_area);
    }
}
