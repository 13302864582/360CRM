package com.lantel.app.com.lantel.personmess.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.android.arouter.utils.TextUtils;
import com.example.component_list.R;
import com.lantel.app.com.app.Config;
import com.lantel.app.com.lantel.personmess.fragment.holder.ItemRemarkHolder;
import com.lantel.app.com.lantel.personmess.fragment.holder.ItemStarHolder;
import com.lantel.app.com.lantel.personmess.fragment.holder.ItemTextHolder;
import com.lantel.app.com.lantel.personmess.fragment.model.ItemRemarkModel;
import com.lantel.app.com.lantel.personmess.fragment.model.ItemStarModel;
import com.lantel.app.com.lantel.personmess.fragment.model.ItemTextModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.HashSet;
import java.util.List;

public class AddMessAdapter extends BaseRecyclerViewAdapter<BaseModel> {
    private HashSet<Integer> neccessPositions;
    /**
     * 适配器构造
     *
     * @param context
     * @param datas
     */
    public AddMessAdapter(Context context, List datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        if(viewType == Config.PERSON_ITEM_TEXT){
            return new ItemTextHolder(inflater.inflate(R.layout.edit_item_text,parent,false));
        }else if(viewType == Config.PERSON_ITEM_STAR){
            return new ItemStarHolder(inflater.inflate(R.layout.edit_item_star,parent,false));
        }else
            return new ItemRemarkHolder(inflater.inflate(R.layout.edit_item_remark,parent,false));
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, BaseModel data, int position, int viewType) {
        if(viewType == Config.PERSON_ITEM_TEXT){
            bindItemTextHolder((ItemTextHolder)holder,(ItemTextModel) data,position);
        }else if(viewType == Config.PERSON_ITEM_STAR){
            bindItemStarHolder((ItemStarHolder)holder,(ItemStarModel) data,position);
        }else
            bindItemRemarkHolder((ItemRemarkHolder)holder,(ItemRemarkModel) data,position);
    }

    private void bindItemRemarkHolder(ItemRemarkHolder holder, ItemRemarkModel model, int position) {
        holder.item_decoration.setVisibility(model.isGroupTop()?View.VISIBLE:View.GONE);
    }

    private void bindItemStarHolder(ItemStarHolder holder, ItemStarModel model, int position) {
        holder.item_line.setVisibility(model.isGroupTop()?View.GONE:View.VISIBLE);
        holder.title.setText("意向级别：");
        holder.ratingBar.setStarProgress(50f);
    }

    private void bindItemTextHolder(ItemTextHolder holder, ItemTextModel model,int position) {
        if(position == 0){
            holder.item_decoration.setVisibility(View.GONE);
            holder.item_line.setVisibility(View.GONE);
        }else {
            holder.item_decoration.setVisibility(model.isGroupTop()?View.VISIBLE:View.GONE);
            holder.item_line.setVisibility(model.isGroupTop()?View.GONE:View.VISIBLE);
        }
        holder.itemView.setOnClickListener((View view)-> {
            LogUtils.d("bindItemTextHolder===="+position);

        });
    }

    private boolean validate() {
        if(neccessPositions == null)
            neccessPositions = getNeccessPositions();
        for(Integer position : neccessPositions){
            ItemTextModel itemTextModel = (ItemTextModel) datas.get(position);
            if(TextUtils.isEmpty(itemTextModel.getValue()))
                return false;
        }
        return true;
    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getType();
    }

    public HashSet getNeccessPositions() {
        neccessPositions = new HashSet();
        if(datas ==null || datas.size() == 0)
            return neccessPositions;

        for(int i=0;i<datas.size();i++){
            BaseModel model = datas.get(i);
            if(model.getType() == Config.PERSON_ITEM_TEXT){
                ItemTextModel textModel = (ItemTextModel) model;
                if(textModel.isNeccessary())
                neccessPositions.add(i);
            }
        }
        return neccessPositions;
    }
}
