package wxrt.baseapp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import wxrt.baseapp.bean.DouBean;
import wxrt.baseapp.bean.WeatherBean;
import wxrt.baseapp.bean.ZhihuBean;

/**
 * Created by zcm on 2016/3/31.
 * qq:656025633
 * 存放接口
 * 1.http://www.weather.com.cn/data/sk/101010100.html
 */
public interface ApiService {
    /* @GET("/data/sk/101010100.html")
     Observable<WeatherBean> getWeathe();*/
    @GET("/data/sk/101010100.html")
    Call<WeatherBean> getWeathe();

    @GET("api/4/news/latest")
    Observable<ZhihuBean> getLatestNews();

    @GET("v2/movie/top250")
    Call<DouBean> getDouNews(@Query("start") int start, @Query("count") int count);
}
