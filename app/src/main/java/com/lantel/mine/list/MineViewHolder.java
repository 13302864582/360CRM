package com.lantel.mine.list;

import android.view.View;

import com.example.baselibrary.listview.BaseViewHolder;
import com.example.baselibrary.util.LogUtils;

public class MineViewHolder extends BaseViewHolder implements View.OnClickListener {
    public MineViewHolder(View view) {
        super(view);
    }

    @Override
    public void onClick(View v) {
        LogUtils.d("onItemClick: ===="+getAdapterPosition());
    }
}
