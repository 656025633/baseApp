package wxrt.baseapp;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.button)
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //请求网络
                Retrofit retrofit = new Retrofit.Builder()
                                                .baseUrl("")
                                                .addConverterFactory(GsonConverterFactory.create())
                                                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                                .build();


            }
        });



    }

    private void initData() {
        //创建事件源
        Observable<String> obs = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("helloworld");
            }
        });

        //创建观察者
        Subscriber<String> sub = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Toast.makeText(MainActivity.this,"",Toast.LENGTH_SHORT).show();

            }
        };

            obs.subscribe(sub);
        Observable.just("Hello, world!")
                .subscribe();
    }
    //

}
