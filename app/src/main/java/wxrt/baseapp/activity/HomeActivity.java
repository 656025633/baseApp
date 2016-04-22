package wxrt.baseapp.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wxrt.baseapp.R;
import wxrt.baseapp.base.BaseActivity;
import wxrt.baseapp.bean.DouBean;
import wxrt.baseapp.utils.ActivityControlUtil;
import wxrt.baseapp.utils.RetrofitUtil;

public class HomeActivity extends BaseActivity {
    private boolean firstEnter = true;
    @Bind(R.id.imageview)
    ImageView mImageView;

    private Handler handler = new Handler() {
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
    protected void onResume() {
        super.onResume();
        Glide.with(this)
                .load("http://h.hiphotos.baidu.com/image/h%3D200/sign=10161fa51830e924d0a49b317c096e66/d52a2834349b033b4cabfe7712ce36d3d539bd7f.jpg")
                .crossFade(5000)
                .into(mImageView);

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void initData() {

        if (firstEnter) {
            Intent intent = new Intent(HomeActivity.    this, SplashActivity.class);
            startActivity(intent);
            firstEnter = false;
        }
        RetrofitUtil.getApiService().getDouNews(0, 2).enqueue(new Callback<DouBean>() {
            @Override
            public void onResponse(Call<DouBean> call, Response<DouBean> response) {

            }

            @Override
            public void onFailure(Call<DouBean> call, Throwable t) {
                Log.d("random", "fail");
            }
        });
        //对数据库的操作
       //
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //退出应用
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            isExit = true;
        }

        return super.onKeyDown(keyCode, event);     
    }

    public void exit() {
        handler.sendEmptyMessageDelayed(10, 2000);
        if (isExit == true) {
        //exit
            ActivityControlUtil.removeAll();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
