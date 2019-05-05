package com.lantel.app.com.lantel.list.listview.holder;

import android.view.View;
import android.widget.TextView;
import com.example.component_list.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import androidx.annotation.NonNull;

public class ListDayTitleHodler extends BaseViewHolder {
    public TextView tv_day;
    public TextView tv_date;

    public ListDayTitleHodler(@NonNull View itemView) {
        super(itemView);
        tv_day = getView(R.id.title_day);
        tv_date = getView(R.id.title_date);
    }
}
