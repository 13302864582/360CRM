package com.lantel.app.com.lantel.list.listview.holder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.component_list.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

import androidx.annotation.NonNull;

public class ListItemHodler extends BaseViewHolder {
    //个人头像
    public ImageView circle_img;
    //默认头像
    public TextView default_img;
    //用户名
    public TextView name;
    //电话号码
    public TextView phone;
    //状态
    public TextView state;
    //备注
    public TextView remarks;
    //下划线
    public View line;
    public ListItemHodler(@NonNull View itemView) {
        super(itemView);
        circle_img = getView(R.id.circle_img);
        default_img = getView(R.id.default_img);
        name = getView(R.id.name);
        phone = getView(R.id.phone);
        state = getView(R.id.state);
        remarks = getView(R.id.remarks);
        line = getView(R.id.line);
    }
}
