package com.lantel.app.com.app;

import android.content.Intent;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.component_list.R;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.annotation.Nullable;

/**
 * app启动activity
 * */
public class AppMVPActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.launch;
    }

    @Override
    public void initView() {
        //跳转名单
       /* String[] tab_market_title = getResources().getStringArray(R.array.tab_market_title);
        ArrayList<String> titles = new ArrayList(Arrays.asList(tab_market_title));
        ARouter.getInstance().build("/lantel/360/list").withStringArrayList(Config.TAB_TITLES,titles).navigation();*/

       //跳转个人，新增，编辑
       /* ARouter.getInstance().build("/lantel/360/personalmess").withInt(Config.PERSON_TYPE,Config.PERSON_TYPE_ADD).navigation();
    */
        //ARouter.getInstance().build("/lantel/360/edit").withInt(Config.ACTION_EDIT,Config.ACTION_EDIT_DATE).navigation(this,Config.REQUEST_EDIT);

        //ARouter.getInstance().build("/lantel/360/edit").withInt(Config.ACTION_EDIT,Config.ACTION_EDIT_TEXT).navigation(this,Config.REQUEST_EDIT);
       ArrayList list =new ArrayList();
       for(int i=0;i<80;i++){
           list.add("==="+i+"===");
       }
        ARouter.getInstance().build("/lantel/360/edit")
                .withInt(Config.ACTION_EDIT,Config.ACTION_EDIT_SELETE)
                .withStringArrayList(Config.EDIT_OPTIONS,list).navigation(this,Config.REQUEST_EDIT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == Config.REQUEST_EDIT && resultCode == RESULT_OK){
            LogUtils.d("onActivityResult===="+data.getStringExtra(Config.RESULT_TEXT));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
