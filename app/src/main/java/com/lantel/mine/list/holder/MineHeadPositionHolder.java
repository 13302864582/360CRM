package com.lantel.mine.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moudletest.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

/**
 * Created by 冯支.
 * function:
 * Date: 2019/4/24
 * Time: 14:19
 */
public class MineHeadPositionHolder extends BaseViewHolder {
    public TextView position;

    public MineHeadPositionHolder(View view) {
        super(view);
        position= getView(R.id.mine_text_position);

    }
}
