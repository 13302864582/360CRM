package com.lantel.home.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.moudletest.R;
import com.lantel.AppConfig;
import com.lantel.home.list.holder.ADViewHolder;
import com.lantel.home.list.holder.HomeHeadViewHolder;
import com.lantel.home.list.holder.MenuItemViewHolder;
import com.lantel.home.list.holder.MenuViewHolder;
import com.lantel.home.list.model.ADModel;
import com.lantel.home.list.model.HeaderBean;
import com.lantel.home.list.model.MenuModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.youth.banner.Banner;

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
public class HomeRecycleViewAdapter extends BaseRecyclerViewAdapter<BaseModel> {
    public void setmListener(HomeMenuAdapter.OnMenuClickListener mListener) {
        this.mListener = mListener;
    }

    private HomeMenuAdapter.OnMenuClickListener mListener;


    /**
     * 构造器
     * @param context 上下文
     * @param datas 数据
     */
    public HomeRecycleViewAdapter(Context context, List<BaseModel> datas) {
        super(context, datas);
    }


    /**
     * 根据viewtype，返回不同的holder绑定
     */
    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        if(viewType == AppConfig.TYPE_HEAD){
            return new HomeHeadViewHolder(inflater.inflate(R.layout.home_top_personal_mess,parent,false));
        }else if(viewType == AppConfig.TYPE_ITEM){
            return new MenuViewHolder(inflater.inflate(R.layout.home_function,parent,false));
        }else if(viewType == AppConfig.TYPE_AD){
            return new ADViewHolder(inflater.inflate(R.layout.home_ad,parent,false));
        }
        return null;
    }


    /**
     * 根据viewtype，获取对应的holder
     */
    @Override
    protected void bindViewHolder(BaseViewHolder viewHolder, BaseModel data, int position, int viewType) {
        if(viewType == AppConfig.TYPE_HEAD){
            bindTopHolder(viewHolder,data,position);
        } else if(viewType == AppConfig.TYPE_ITEM){
            bindItemHolder(viewHolder,data,position);
        }else if(viewType == AppConfig.TYPE_AD){
            bindADHolder(viewHolder,data,position);
        }
    }

    private void bindADHolder(BaseViewHolder viewHolder, BaseModel data, int position) {
        ADViewHolder holder = (ADViewHolder) viewHolder;
        ADModel model = (ADModel) data;
        Banner banner = holder.banner;
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(model.getIcon());
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }


    /**
     * 处理itemHolder
     */
    private void bindItemHolder(BaseViewHolder viewHolder, BaseModel data, int position) {
        MenuViewHolder holder = (MenuViewHolder) viewHolder;
        MenuModel model = (MenuModel) data;
        HomeMenuAdapter adapter = new HomeMenuAdapter(context,model.getItems());
        if(mListener!=null)
        adapter.setOnMenuClickListener(mListener);
        holder.recycle_menu.setLayoutManager(new GridLayoutManager(context,4));
        holder.recycle_menu.setAdapter(adapter);
    }


    /**
     * 处理headHolder
     */
    private void bindTopHolder(BaseViewHolder viewHolder, BaseModel data, int position) {
        HomeHeadViewHolder headViewHolder = (HomeHeadViewHolder) viewHolder;
        HeaderBean headerBean = (HeaderBean) data;

        headViewHolder.user_name.setText(headerBean.getUser_name());

        headViewHolder.user_area.setText(headerBean.getUser_area());

        headViewHolder.scheldue_txt.setText(headerBean.getScheldue_txt());

        headViewHolder.homeday_txt.setText(headerBean.getHomework_txt());

        headViewHolder.renew_txt.setText(headerBean.getRenew_txt());

        GlideUtils.loadImageViewInside(context,headerBean.getPersonal_img(),R.mipmap.default_home_user,R.mipmap.default_home_user,headViewHolder.user_img);
    }

    private void loadNormalImage() {

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
