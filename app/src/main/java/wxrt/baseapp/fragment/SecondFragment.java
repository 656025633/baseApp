package wxrt.baseapp.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import wxrt.baseapp.R;
import wxrt.baseapp.base.BaseFragment;
import wxrt.baseapp.views.CustomViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends BaseFragment {
    @Bind(R.id.mViewPager)
    ViewPager mMViewPager;

    @Override
    public int getContentLayoutId() {
        return R.layout.fragment_second;
    }

    @Override
    public void initView(View view) {
         ButterKnife.bind(this,view);
        CustomViewPager customViewPager = new CustomViewPager(getActivity(),mMViewPager);
    }

    @Override
    public void initListener(View view) {

    }

    @Override
    public void initData() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
