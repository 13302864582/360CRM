package com.lantel.app.com.lantel.list.listview.holder;

import android.view.View;
import android.widget.TextView;

import com.example.component_list.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

import androidx.annotation.NonNull;

public class ListItemHodler extends BaseViewHolder {
    public TextView tv_day;
    public TextView tv_date;

    public ListItemHodler(@NonNull View itemView) {
        super(itemView);
        tv_day = getView(R.id.text_high);
        tv_date = getView(R.id.text_below);
    }
}
