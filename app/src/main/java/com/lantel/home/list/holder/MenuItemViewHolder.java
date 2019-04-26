package com.lantel.home.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moudletest.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;


/**
 * Created by 冯支
 * function: 菜单ITEM布局holder
 * Date: 2019/4/23
 */
public class MenuItemViewHolder extends BaseViewHolder {
    public TextView title;
    public ImageView icon;

    public MenuItemViewHolder(View view) {
        super(view);
        icon = getView(R.id.home_menu_icon);
        title = getView(R.id.home_menu_text);
    }
}
