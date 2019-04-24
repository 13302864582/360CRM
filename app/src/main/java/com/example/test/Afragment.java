package com.example.test;

import android.content.Context;
import com.xiao360.baselibrary.base.BaseFragment;
import com.xiao360.baselibrary.dragMenu.DefaultItemCallback;
import com.xiao360.baselibrary.dragMenu.DefaultItemTouchHelper;
import com.xiao360.baselibrary.dragMenu.SpaceItemDecoration;
import com.example.moudletest.R;
import java.util.ArrayList;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class Afragment extends BaseFragment {
    @BindView(R.id.recyclerViewExist)
    RecyclerView recyclerViewExist;

    private FunctionBlockAdapter blockAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.a_main;
    }

    @Override
    protected void initView() {
        ArrayList<FunctionItem> arrayList = new ArrayList<>();
        arrayList.add(new FunctionItem("充值中心",false,"icon_home_selected","#86c751"));
        arrayList.add(new FunctionItem("信用卡还款",false,"icon_home_selected","#86c751"));
        arrayList.add(new FunctionItem("生活缴费",false,"icon_home_selected","#86c751"));
        arrayList.add(new FunctionItem("城市服务",false,"icon_home_selected","#86c751"));
        arrayList.add(new FunctionItem("生活号",false,"icon_home_selected","#86c751"));
        arrayList.add(new FunctionItem("我的客服",false,"icon_home_selected","#86c751"));
        arrayList.add(new FunctionItem("我的快递",false,"icon_home_selected","#86c751"));
        arrayList.add(new FunctionItem("医疗健康",false,"icon_home_selected","#86c751"));
        arrayList.add(new FunctionItem("记账本",false,"icon_home_selected","#86c751"));
        arrayList.add(new FunctionItem("城市一卡通",false,"icon_home_selected","#86c751"));
        arrayList.add(new FunctionItem("发票管家",false,"icon_home_selected","#86c751"));
        arrayList.add(new FunctionItem("蚂蚁宝卡",false,"icon_home_selected","#86c751"));
        arrayList.add(new FunctionItem("车主服务",false,"icon_home_selected","#86c751"));
        arrayList.add(new FunctionItem("天天有料",false,"icon_home_selected","#86c751"));
        blockAdapter = new FunctionBlockAdapter(getActivity(), arrayList);
        recyclerViewExist.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        recyclerViewExist.setAdapter(blockAdapter);
        recyclerViewExist.addItemDecoration(new SpaceItemDecoration(4, dip2px(getActivity(), 10)));

        DefaultItemCallback callback = new DefaultItemCallback(blockAdapter);
        DefaultItemTouchHelper helper = new DefaultItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerViewExist);
    }

 /*   @OnClick(R.id.texta)
    public void onViewClicked() {
        Log.d("tabhost", "a=======");
        Navigation.findNavController(rootView).navigate(R.id.action_page2);
    }*/

    public  int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
