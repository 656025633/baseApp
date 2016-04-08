package wxrt.baseapp.utils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import wxrt.baseapp.api.ApiService;
import wxrt.baseapp.constant.Constant;

/**
 * Created by zcm on 2016/4/6.
 * qq:656025633
 * Func：provider a Retrofit Object
 */
public class RetrofitUtil{
    //定义共有的url
    private static ApiService apiService = new Retrofit
            .Builder()
            .baseUrl(Constant.DOU_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService.class);

    private RetrofitUtil(){}
    public static ApiService getApiService(){
        return apiService;
    }
}
