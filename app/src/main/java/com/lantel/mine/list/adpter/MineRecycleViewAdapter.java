package com.lantel.mine.list.adpter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.lantel.AppConfig;
import com.lantel.common.image.GlideCircleWithBorder;
import com.lantel.common.list.GridItemDecoration;
import com.lantel.mine.list.model.HeaderBean;
import com.lantel.mine.list.model.MenuItemModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.example.moudletest.R;
import com.lantel.mine.list.holder.MineHeadViewHolder;
import com.lantel.mine.list.holder.MineViewHolder;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by 冯支
 * function: 菜单布局适配器.
 * Date: 2019/4/23
 * Time: 18:18
 */
public class MineRecycleViewAdapter extends BaseRecyclerViewAdapter<BaseModel> {


    /**
     * 点击事件
     */
    public interface OnMenuClickListener {
        void onMenuClick(int action);
    }

    private OnMenuClickListener mListener;

    public void setOnMenuClickListener(OnMenuClickListener mListener) {
        this.mListener = mListener;
    }


    /**
     * 构造器
     * @param context 上下文
     * @param datas 数据
     */
    public MineRecycleViewAdapter(Context context, List<BaseModel> datas) {
        super(context, datas);
    }


    /**
     * 根据viewtype，返回不同的holder绑定
     */
    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        if(viewType == AppConfig.TYPE_HEAD){
            return new MineHeadViewHolder(inflater.inflate(R.layout.mine_top_personal_mess,parent,false));
        }else if(viewType == AppConfig.TYPE_ITEM){
            return new MineViewHolder(inflater.inflate(R.layout.mine_item,parent,false));
        }
        return null;
    }


    /**
     * 根据viewtype，获取对应的holder
     */
    @Override
    protected void bindViewHolder(BaseViewHolder viewHolder, BaseModel data, int position, int viewType) {
        if(viewHolder == null)
            return;

        if(viewType == AppConfig.TYPE_HEAD){
            bindTopHolder(viewHolder,data,position);
        }else {
            bindItemHolder(viewHolder,data,position);
        }
    }


    /**
     * 处理itemHolder
     */
    private void bindItemHolder(BaseViewHolder viewHolder, BaseModel data, int position) {
        MenuItemModel model = (MenuItemModel) data;
        MineViewHolder itemHolder = (MineViewHolder) viewHolder;
        int action = model.getFlag_action();
        itemHolder.icon.setImageResource(model.getIcon());
        itemHolder.title.setText(model.getTitle());
        itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null)
                    mListener.onMenuClick(action);
            }
        });
    }


    /**
     * 处理headHolder
     */
    private void bindTopHolder(BaseViewHolder viewHolder, BaseModel data, int position) {
        MineHeadViewHolder headViewHolder = (MineHeadViewHolder) viewHolder;
        HeaderBean headerBean = (HeaderBean) data;

        headViewHolder.top_personal_name.setText(headerBean.getPersonal_name());

        headViewHolder.top_personal_area.setText(headerBean.getPersonal_area());

        Glide.with(context).load(headerBean.getPersonal_img())
                        .apply(new RequestOptions()
                        .error(context.getResources().getDrawable(R.mipmap.ic_launcher))
                        .placeholder(R.mipmap.ic_launcher)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .transform(new GlideCircleWithBorder(3, Color.parseColor("#ccffffff"))))
                        .into(headViewHolder.top_circle_personal);

        MineHeadPositionAdapter adapter =new MineHeadPositionAdapter(context,headerBean.getPositions());
        RecyclerView grid_position = headViewHolder.top_grid_position;
        GridItemDecoration divider = new GridItemDecoration.Builder(context)
                .setVerticalSpan(R.dimen.common_vew_raw_padding)
                .setHorizontalSpan(R.dimen.common_vew_vertical_padding)
                .setColorResource(R.color.mine_text_position)
                .setShowLastLine(true)
                .setNormalGrid(false)
                .build();

        grid_position.addItemDecoration(divider);
        grid_position.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                grid_position.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
        grid_position.setLayoutManager(new GridLayoutManager(context,4));
        grid_position.setAdapter(adapter);
    }


    /**
     * 设置数据并重新刷新加载
     */
    public void refreshData(List<BaseModel> list) {
       setDatas(list);
       notifyDataSetChanged();
    }


    /**
     * item的viewtype
     */
    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getType();
    }
}
