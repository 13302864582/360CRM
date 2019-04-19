package com.example.baselibrary.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseRecyclerViewAdapter<T,E extends BaseViewHolder> extends RecyclerView.Adapter<E>{
    private Context context;
    private LayoutInflater inflater;

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    private List<T> datas;
    protected OnItemClickListner onItemClickListner;//单击事件
    protected OnItemLongClickListner onItemLongClickListner;//长按单击事件
    private boolean clickFlag = true;//单击事件和长单击事件的屏蔽标识

    public BaseRecyclerViewAdapter(Context context, List<T> datas) {
        this.context = context;
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public E onCreateViewHolder(ViewGroup parent, int viewType) {
        E holder = CreateViewHolder(inflater,parent,viewType);
        return holder;
    }

    protected abstract E CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(E holder, int position) {
        bindViewHolder(holder, datas.get(position), position,getItemViewType(position));
    }

    @Override
    public int getItemCount() {
        return null == datas ? 0 : datas.size();
    }

    protected abstract void bindViewHolder(E holder, T data, int position, int viewType);

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public void setOnItemLongClickListner(OnItemLongClickListner onItemLongClickListner) {
        this.onItemLongClickListner = onItemLongClickListner;
    }

    public interface OnItemClickListner {
        void onItemClickListner(View v, int position);
    }

    public interface OnItemLongClickListner {
        void onItemLongClickListner(View v, int position);
    }
}
