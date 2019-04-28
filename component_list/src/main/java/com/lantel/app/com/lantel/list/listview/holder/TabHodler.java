package com.lantel.app.com.lantel.list.listview.holder;

import android.view.View;
import android.widget.TextView;

import com.example.component_list.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

import androidx.annotation.NonNull;

public class TabHodler extends BaseViewHolder {
    public TextView tv_hight;
    public TextView tv_low;

    public TabHodler(@NonNull View itemView) {
        super(itemView);
        tv_hight = getView(R.id.text_high);
        tv_low = getView(R.id.text_below);
    }
}
