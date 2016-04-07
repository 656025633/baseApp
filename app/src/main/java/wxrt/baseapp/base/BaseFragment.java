package wxrt.baseapp.base;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wxrt.baseapp.R;

/**
 *
 *
 */
public abstract class BaseFragment extends Fragment {
    //用于保存状态
    private View view;

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        if(view == null) {
            view = inflater.inflate(getContentLayoutId(), container, false);
        }
        ViewGroup parent = (ViewGroup)view.getParent();
        if(parent!=null){
            parent.removeView(view);
        }
        initView(view);
        initListener(view);
        initData();
        return view;
    }

    //获取布局的id
    public abstract int getContentLayoutId();
    public abstract void initView(View view);
    public abstract void initListener(View view);
    public abstract  void initData();
}