package com.lantel.app.com.lantel.personmess.fragment.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.component_list.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class ItemTextHolder extends BaseViewHolder {
    public TextView title;
    public ImageView isNeccess_img;
    public TextView value;
    public TextView tip_neccess;
    public View item_line;
    public View item_decoration;

    public ItemTextHolder(View view) {
        super(view);
        title = getView(R.id.title);
        isNeccess_img = getView(R.id.isNeccess_img);
        value = getView(R.id.value);
        tip_neccess = getView(R.id.tip_neccess);
        item_line = getView(R.id.item_line);
        item_decoration = getView(R.id.item_decoration);
    }
}
