package com.lantel.home.list.holder;

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
public class MenuViewHolder extends BaseViewHolder {
    public RecyclerView recycle_menu;

    public MenuViewHolder(View view) {
        super(view);
        recycle_menu = getView(R.id.recycle_menu);
    }
}
