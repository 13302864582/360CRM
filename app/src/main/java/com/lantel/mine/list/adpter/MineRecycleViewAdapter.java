package com.lantel.mine.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.lantel.mine.list.model.MenuItemModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.example.moudletest.R;
import com.lantel.mine.list.holder.MineHeadViewHolder;
import com.lantel.mine.list.holder.MineViewHolder;
import java.util.List;

/**
 * Created by 冯支
 * function: 菜单布局适配器.
 * Date: 2019/4/23
 * Time: 18:18
 */
public class MineRecycleViewAdapter extends BaseRecyclerViewAdapter<BaseModel> {
    /**
     * 布局viewType标志，TYPE_HEAD头布局，TYPE_ITEM选项布局
     */
    public static final int TYPE_HEAD = 0x10;
    public static final int TYPE_ITEM = 0x11;

    /**
     * 跳转ACTION标志
     */
    public static final int ACTION_FILE = 0x00;
    public static final int ACTION_CHANNEL = 0x01;
    public static final int ACTION_OUTPUT = 0x02;
    public static final int ACTION_ROLE_PERMISSION = 0x03;
    public static final int ACTION_FEEDBACK = 0x04;

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
        if(viewType == TYPE_HEAD){
            return new MineHeadViewHolder(inflater.inflate(R.layout.top_personal_mess,parent,false));
        }else{
            return new MineViewHolder(inflater.inflate(R.layout.mine_item,parent,false));
        }
    }


    /**
     * 根据viewtype，获取对应的holder
     */
    @Override
    protected void bindViewHolder(BaseViewHolder viewHolder, BaseModel data, int position, int viewType) {
        if(viewType == TYPE_HEAD){
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
        ImageView imageView = headViewHolder.getView(R.id.top_img);

        Glide.with(context)
                .load("http://img5.duitang.com/uploads/item/201506/07/20150607110911_kY5cP.jpeg")
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
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
