package com.lantel.home.list.adpter;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.moudletest.R;
import com.xiao360.baselibrary.util.DisplayUtil;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by 冯支.
 * function:
 * Date: 2019/4/26
 * Time: 10:10
 */
public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide 加载图片简单用法
        Glide.with(context).load(path)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(DisplayUtil.dip2px(15))))
                .into(imageView);
    }
}
