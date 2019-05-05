package com.lantel.app.com.lantel.list.listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import com.alibaba.android.arouter.utils.TextUtils;
import com.example.component_list.R;
import com.lantel.app.com.app.Config;
import com.lantel.app.com.lantel.list.listview.holder.ListDayTitleHodler;
import com.lantel.app.com.lantel.list.listview.holder.ListItemHodler;
import com.lantel.app.com.lantel.list.listview.model.DayTitleModel;
import com.lantel.app.com.lantel.list.listview.model.ListItemModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public class DayListAdapter extends BaseRecyclerViewAdapter<BaseModel> implements Filterable {
    private ListFilter filter;

    public DayListAdapter(Context context) {
        this(context, null);
    }

    public DayListAdapter(Context context, List datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        if (viewType == Config.DAY_ITEM) {
            return new ListDayTitleHodler(inflater.inflate(R.layout.day_title, parent, false));
        } else {
            return new ListItemHodler(inflater.inflate(R.layout.list_item, parent, false));
        }
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, BaseModel data, int position, int viewType) {
        if (viewType == Config.DAY_ITEM) {
            bindListDayTitleHodler((ListDayTitleHodler) holder, (DayTitleModel) data);
        } else {
            bindListItemHodler((ListItemHodler) holder, (ListItemModel) data, position, viewType);
        }
    }

    private void bindListItemHodler(ListItemHodler holder, ListItemModel data, int position, int viewtype) {
        if (TextUtils.isEmpty(data.getImg())) {
            holder.default_img.setVisibility(View.VISIBLE);
            holder.circle_img.setVisibility(View.GONE);
            holder.default_img.setText(data.getName().substring(0, 1));
        } else {
            holder.default_img.setVisibility(View.GONE);
            holder.circle_img.setVisibility(View.VISIBLE);
            GlideUtils.loadCircle(context, data.getImg(), 0, 0, holder.circle_img, false, 0);
        }
        holder.name.setText(data.getName());
        holder.phone.setText(data.getPhone());
        holder.state.setText(data.getState_txt());
        holder.state.setTextColor(getColor(data.getState_color()));
        holder.remarks.setText(data.getRemarks());
        boolean hasLine = !(position == getItemCount() - 1 || getItemViewType(position + 1) == Config.DAY_ITEM);
        holder.line.setVisibility(hasLine ? View.VISIBLE : View.INVISIBLE);
    }


    private void bindListDayTitleHodler(ListDayTitleHodler holder, DayTitleModel data) {
        holder.tv_day.setText(data.getTitle());
        holder.tv_date.setText(data.getDate());
    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getType();
    }

    /**
     * 自定义MyAdapter类实现了Filterable接口，重写了该方法
     */
    @Override
    public Filter getFilter() {
        // 如果MyFilter对象为空，那么重写创建一个
        if (filter == null) {
            filter = new ListFilter(datas);
        }
        return filter;
    }


    /**
     * ListFilter,搜索过滤器
     */
    public class ListFilter extends Filter {
        // 创建集合保存原始数据
        private List<BaseModel> original = new ArrayList();

        public ListFilter(List<BaseModel> list) {
            this.original = list;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            // 创建FilterResults对象
            FilterResults results = new FilterResults();

            /**
             * 没有搜索内容的话就还是给results赋值原始数据的值和大小
             * 执行了搜索的话，根据搜索的规则过滤即可，最后把过滤后的数据的值和大小赋值给results
             */
            if(TextUtils.isEmpty(constraint)){
                results.values = original;
                results.count = original.size();
            }else {
                // 创建集合保存过滤后的数据
                List<BaseModel> mList = new ArrayList();
                // 遍历原始数据集合，根据搜索的规则过滤数据
                for (BaseModel s : original) {
                    if(s.getType() == Config.MESS_ITEM){
                        ListItemModel model = (ListItemModel) s;
                        // 这里就是过滤规则的具体实现【规则有很多，大家可以自己决定怎么实现】
                        String name = StringToLower(model.getName());
                        String phoneNumber = StringToLower(model.getPhone());
                        String searchText = StringToLower(constraint.toString());
                        if (name.contains(searchText) || phoneNumber.contains(searchText)) {
                            // 规则匹配的话就往集合中添加该数据
                            mList.add(model);
                        }
                    }
                }
                results.values = mList;
                results.count = mList.size();
            }
            return results;
        }

        private String StringToLower(String constraint) {
            return constraint.trim().toLowerCase();
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            // 获取过滤后的数据
            datas = (List<BaseModel>) results.values;
            // 刷新数据源显示
            notifyDataSetChanged();
        }
    }
}
