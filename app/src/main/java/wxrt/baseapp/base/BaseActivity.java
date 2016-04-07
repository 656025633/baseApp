package wxrt.baseapp.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import wxrt.baseapp.utils.ActivityControlUtil;

/**
 * Created by zcm on 2016/4/1.
 * qq:656025633
 */
public abstract  class BaseActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeView();
        setContentView(getLayoutId());
        obtainIntent();
        initView();
        initListener();
        initData();
        //添加集合
        ActivityControlUtil.addActivity(this);

        
    }
    //setting title and so on
    protected abstract void beforeView();
    //get layout id
    protected abstract  int getLayoutId();
    //get intent
    protected abstract void obtainIntent();
    //get view
    protected abstract void initView();
    //set listener
    protected abstract void initListener();
    //set data
    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //退出activity
        ActivityControlUtil.removeActivity(this);
    }
}
