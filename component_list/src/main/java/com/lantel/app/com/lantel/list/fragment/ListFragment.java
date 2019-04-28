package com.lantel.app.com.lantel.list.fragment;

import com.example.component_list.R;
import com.xiao360.baselibrary.base.BaseFragment;
import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class ListFragment extends BaseFragment {
    @BindView(R.id.list)
    RecyclerView list;

    @Override
    protected int getLayoutResource() {
        return R.layout.list_frag;
    }

    @Override
    protected void initView() {
        /*list.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList data = new ArrayList();
        for(int i=0;i<100;i++){
            data.add(i);
        }
        list.setAdapter(new ListAdapter(getContext(),data));*/
    }
}
