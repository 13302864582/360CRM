package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.baselibrary.dragMenu.ItemTouchHelperAdapter;
import com.example.baselibrary.listview.BaseRecyclerViewAdapter;
import com.example.moudletest.R;

import java.util.Collections;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class FunctionBlockAdapter extends BaseRecyclerViewAdapter<FunctionItem,FunctionItemHolder> implements ItemTouchHelperAdapter{

    public FunctionBlockAdapter(Context context, List<FunctionItem> datas) {
        super(context, datas);
    }

    @Override
    public void onItemMove(RecyclerView.ViewHolder holder, int fromPosition, int targetPosition) {
        if (fromPosition < datas.size() && targetPosition < datas.size()) {
            Collections.swap(datas, fromPosition, targetPosition);
            notifyItemMoved(fromPosition, targetPosition);
        }
    }

    @Override
    public void onItemSelect(RecyclerView.ViewHolder holder) {
        //长按缩放
        holder.itemView.setScaleX(0.9f);
        holder.itemView.setScaleY(0.9f);
    }

    @Override
    public void onItemClear(RecyclerView.ViewHolder holder) {
        //绘制完毕，抬起手，缩放至原始大小
        holder.itemView.setScaleX(1.0f);
        holder.itemView.setScaleY(1.0f);
    }

    @Override
    public void onItemDismiss(RecyclerView.ViewHolder holder) {

    }

    @Override
    protected FunctionItemHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new FunctionItemHolder(inflater.inflate(R.layout.layout_grid_item, parent, false));
    }

    @Override
    protected void bindViewHolder(FunctionItemHolder holder, FunctionItem data, int position, int viewType) {
        int rid = context.getResources().getIdentifier(data.imageUrl,"drawable",context.getPackageName());
        setImage(rid, holder.iv);
        holder.text.setText(data.name);
        holder.btn.setImageResource(R.mipmap.ic_block_delete);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FunctionItem fi = datas.remove(position);
                if (listener != null) {
                    listener.remove(fi);
                }
                notifyDataSetChanged();
            }
        });
    }

    public void setImage(int url, ImageView iv) {
        Glide.with(context).load(url).into(iv);
    }

    public interface OnItemRemoveListener {
        void remove(FunctionItem item);
    }

    private OnItemRemoveListener listener;

    public void setOnItemRemoveListener(OnItemRemoveListener listener) {
        this.listener = listener;
    }
}
