package com.lantel.app.com.lantel.personmess.fragment.holder;

import android.view.View;

import com.example.component_list.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class ItemRemarkHolder extends BaseViewHolder {
    public View item_decoration;

    public ItemRemarkHolder(View view) {
        super(view);
        item_decoration = getView(R.id.item_decoration);
    }
}
