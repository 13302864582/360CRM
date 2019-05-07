package com.lantel.app.com.lantel.personmess.fragment.holder;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.cb.ratingbar.CBRatingBar;
import com.example.component_list.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class ItemStarHolder extends BaseViewHolder {
    public TextView title;
    public CBRatingBar ratingBar;
    public View item_line;

    public ItemStarHolder(View view) {
        super(view);
        title = getView(R.id.title);
        ratingBar = getView(R.id.rating_bar);
        item_line = getView(R.id.item_line);
    }
}
