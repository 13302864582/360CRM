package com.lantel.app.com.lantel.list.listview.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.component_list.R;
import com.lantel.app.com.app.Config;
import com.lantel.app.com.lantel.list.listview.holder.ListDayTitleHodler;
import com.lantel.app.com.lantel.list.listview.holder.ListItemHodler;
import com.lantel.app.com.lantel.list.listview.model.DayTitleModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.List;

public class DayListAdapter extends BaseRecyclerViewAdapter<BaseModel> {
    public DayListAdapter(Context context) {
        this(context,null);
    }

    public DayListAdapter(Context context, List datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        if(viewType == Config.DAY_ITEM){
            return new ListDayTitleHodler(inflater.inflate(R.layout.day_title,parent,false));
        }else{
            return new ListItemHodler(inflater.inflate(R.layout.list_item,parent,false));
        }
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, BaseModel data, int position, int viewType) {
        if(viewType == Config.DAY_ITEM){
            bindListDayTitleHodler((ListDayTitleHodler) holder,(DayTitleModel)data);
        }else{
            bindListItemHodler((ListItemHodler) holder,data);
        }
    }

    private void bindListItemHodler(ListItemHodler holder, BaseModel data) {

    }

    private void bindListDayTitleHodler(ListDayTitleHodler holder, DayTitleModel data) {
        holder.tv_day.setText(data.getTitle());
        holder.tv_date.setText(data.getDate());
    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getType();
    }
}
