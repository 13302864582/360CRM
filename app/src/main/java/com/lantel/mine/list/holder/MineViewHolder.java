package com.lantel.mine.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.example.moudletest.R;


/**
 * Created by 冯支
 * function: 菜单ITEM布局holder
 * Date: 2019/4/23
 */
public class MineViewHolder extends BaseViewHolder {
    public TextView title;
    public ImageView icon;
    public ImageView arrow;

    public MineViewHolder(View view) {
        super(view);
        icon = getView(R.id.icon);
        title = getView(R.id.title);
        arrow = getView(R.id.arrow);
    }
}
