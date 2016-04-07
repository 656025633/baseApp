package wxrt.baseapp.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import butterknife.ButterKnife;
import wxrt.baseapp.R;
import wxrt.baseapp.base.BaseActivity;
import wxrt.baseapp.utils.ActivityControlUtil;

public class HomeActivity extends BaseActivity {
    private boolean firstEnter = true;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    private boolean isExit = false;

    @Override
    protected void beforeView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void obtainIntent() {

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        //判断启动页
        if (firstEnter) {
            Intent intent = new Intent(HomeActivity.this, SplashActivity.class);
            startActivity(intent);
            firstEnter = false;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //退出當前應用
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            isExit = true;
        }

        return super.onKeyDown(keyCode, event);
    }

    public void exit(){
        handler.sendEmptyMessageDelayed(10, 2000);
        if(isExit == true){
        //exit
            ActivityControlUtil.removeAll();
        }
    }
}
