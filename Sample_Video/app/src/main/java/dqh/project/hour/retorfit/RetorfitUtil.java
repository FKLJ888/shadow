package dqh.project.hour.retorfit;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Love_you on 2017/12/15 0015.
 */

public class RetorfitUtil {
    public RetorfitUtil(){}
    public static ApiService apiService;
    public static ApiService getApiService(){
        if(apiService==null){
            synchronized (RetorfitUtil.class){
                if(apiService==null){
                    HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                        @Override
                        public void log(String message) {
                            Log.i("dqh",message);
                        }
                    });
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    OkHttpClient client=new OkHttpClient.Builder()
                            .addInterceptor(interceptor)
                            .build();
                    Retrofit retrofit=new Retrofit.Builder()
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .baseUrl("http://api.svipmovie.com/front/")
                            .client(client)
                            .build();
                    apiService=retrofit.create(ApiService.class);
                }
            }
        }
        return apiService;
    }
}
