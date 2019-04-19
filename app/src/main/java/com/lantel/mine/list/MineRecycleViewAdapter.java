package com.lantel.mine.list;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.baselibrary.listview.BaseRecyclerViewAdapter;
import com.example.moudletest.R;
import java.util.List;


public class MineRecycleViewAdapter extends BaseRecyclerViewAdapter<MenuItem,MineViewHolder>{
    public MineRecycleViewAdapter(Context context, List<MenuItem> datas) {
        super(context, datas);
    }

    @Override
    protected MineViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new MineViewHolder(inflater.inflate(R.layout.mine_item,parent,false));
    }

    @Override
    protected void bindViewHolder(MineViewHolder viewHolder, MenuItem data, int position, int viewType) {
        TextView textView = viewHolder.getView(R.id.item_Text);
        ImageView imageView = viewHolder.getView(R.id.item_icon);
        textView.setText(data.getText());
        imageView.setImageResource(data.getIcon());
        imageView.setOnClickListener(viewHolder);
    }

    public void loadData(List<MenuItem> list) {
        List list1 = getDatas();
        int begin = list1.size();
        list1.addAll(list);
        notifyItemRangeInserted(begin,list1.size()-1);
    }

    public void refreshData(List<MenuItem> list) {
       setDatas(list);
       notifyDataSetChanged();
    }
}
