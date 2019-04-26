package com.lantel.home.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moudletest.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.youth.banner.Banner;

import java.util.ArrayList;

import androidx.collection.SparseArrayCompat;
import androidx.viewpager.widget.ViewPager;


/**
 * Created by 冯支
 * function: 菜单ITEM布局holder
 * Date: 2019/4/23
 */
public class ADViewHolder extends BaseViewHolder {
    public Banner banner;

    public ADViewHolder(View view) {
        super(view);
        banner = getView(R.id.banner);
    }
}
