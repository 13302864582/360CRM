package com.xiao360.baselibrary.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseViewHolder>{
    /**
     *  context 上下文
     */
    protected Context context;

    /**
     * inflater 布局渲染器
     */
    protected LayoutInflater inflater;

    /**
     * datas 数据模型
     */
    protected List<T> datas;

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }


    /**
     * 设置单击事件
     */
    protected OnItemClickListner onItemClickListner;

    public interface OnItemClickListner {
        void onItemClickListner(View v, int position);
    }

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }


    /**
     * 设置长按事件
     */
    protected OnItemLongClickListner onItemLongClickListner;

    public interface OnItemLongClickListner {
        void onItemLongClickListner(View v, int position);
    }

    public void setOnItemLongClickListner(OnItemLongClickListner onItemLongClickListner) {
        this.onItemLongClickListner = onItemLongClickListner;


    }

    /**
     * 适配器构造
     */
    public BaseRecyclerViewAdapter(Context context, List<T> datas) {
        this.context = context;
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);
    }


    /**
     * 创建视图的holder
     */
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder holder = CreateViewHolder(inflater,parent,viewType);
        return holder;
    }

    protected abstract BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType);


    /**
     * 获取holder
     */
    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        bindViewHolder(holder, datas.get(position), position,getItemViewType(position));
    }


    /**
     * 条目数量
     */
    @Override
    public int getItemCount() {
        return null == datas ? 0 : datas.size();
    }

    protected abstract void bindViewHolder(BaseViewHolder holder, T data, int position, int viewType);
}
