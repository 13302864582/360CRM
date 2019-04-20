package com.example.test;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.baselibrary.listview.BaseViewHolder;
import com.example.moudletest.R;

public class FunctionItemHolder extends BaseViewHolder {
    protected ImageView iv, btn;
    protected TextView text;

    public FunctionItemHolder(View view) {
        super(view);
        iv = getView(R.id.iv);
        text = getView(R.id.text);
        btn = getView(R.id.btn);
    }
}
