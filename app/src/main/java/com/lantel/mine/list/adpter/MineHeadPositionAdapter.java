package com.lantel.mine.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.moudletest.R;
import com.lantel.mine.list.holder.MineHeadPositionHolder;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;

import java.util.List;

/**
 * Created by 冯支.
 * function:
 * Date: 2019/4/24
 * Time: 14:16
 */
public class MineHeadPositionAdapter extends BaseRecyclerViewAdapter<String> {
    /**
     * 适配器构造
     *
     * @param context
     * @param datas
     */
    public MineHeadPositionAdapter(Context context, List datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new MineHeadPositionHolder(inflater.inflate(R.layout.mine_header_position,parent,false));
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, String data, int position, int viewType) {
        MineHeadPositionHolder mineHeadPositionHolder = (MineHeadPositionHolder) holder;
        mineHeadPositionHolder.position.setText(data);
    }
}
