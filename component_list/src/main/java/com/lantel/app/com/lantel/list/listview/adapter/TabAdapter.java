package com.lantel.app.com.lantel.list.listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.component_list.R;
import com.lantel.app.com.lantel.list.listview.holder.TabHodler;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends BaseRecyclerViewAdapter<BaseModel> {
    private ArrayList<String> titles;
    /**
     * 适配器构造
     */
    public TabAdapter(Context context) {
        this(context,null);
    }

    public TabAdapter(Context context, List datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new TabHodler(inflater.inflate(R.layout.layout_tabt_item,parent,false));
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, BaseModel data, int position, int viewType) {
        TabHodler tabHodler = (TabHodler) holder;
        if(datas!=null)
        tabHodler.tv_hight.setText(data.getTitle());
        if(titles!=null)
        tabHodler.tv_low.setText(titles.get(position));

        holder.itemView.setOnClickListener((View v)->{

        });
    }

    public void setTitles(ArrayList<String> titles) {
        this.titles = titles;
    }

    @Override
    public int getItemCount() {
        //重写，根据标题计算子项数量
        return null == titles ? 0 : titles.size();
    }
}
