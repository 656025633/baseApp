package wxrt.baseapp.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import wxrt.baseapp.R;
import wxrt.baseapp.adapter.RecyclerViewAdapter;
import wxrt.baseapp.base.BaseFragment;
import wxrt.baseapp.views.LoadMoreFooterView;
import wxrt.baseapp.views.RefreshHeaderView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment {
    @Bind(R.id.swipe_refresh_header)
    RefreshHeaderView mSwipeRefreshHeader;
    @Bind(R.id.swipe_target)
    RecyclerView mSwipeTarget;
    @Bind(R.id.swipe_load_more_footer)
    LoadMoreFooterView mSwipeLoadMoreFooter;
    @Bind(R.id.swipeToLoadLayout)
    SwipeToLoadLayout mSwipeToLoadLayout;
    RecyclerViewAdapter mAdapter;

    @Override
    public int getContentLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void initView(View view) {
        ButterKnife.bind(this,view);
    }

    @Override
    public void initListener(View view) {


    }

    @Override
    public void initData() {
        List<String>  datas = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            datas.add("我是"+i);
        }
        mAdapter = new RecyclerViewAdapter(getActivity(),datas);
        mSwipeTarget.setAdapter(mAdapter);
        mSwipeTarget.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
