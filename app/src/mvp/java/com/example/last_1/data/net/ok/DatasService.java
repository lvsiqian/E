package com.example.last_1.data.net.ok;

import com.example.last_1.BuildConfig;
import com.example.last_1.data.net.ok.converter.MvpGsonConverterFactory;
import com.example.last_1.utils.Constrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DatasService {
    private  static  final long TIME_OUT=20000;
    public  static volatile  ApiService mService;
    public  static  ApiService getService(){
        if(mService==null){
            synchronized ( DatasService.class){
                if(mService==null){
                    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                    if(BuildConfig.DEBUG){
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                    }else{
                        logging.setLevel(HttpLoggingInterceptor.Level.NONE);
                    }
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    builder.addInterceptor(logging);
                    builder.connectTimeout(TIME_OUT,TimeUnit.MILLISECONDS)
                    .writeTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                    .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                            .build();
                    Retrofit mRetrofit = new Retrofit.Builder()
                            .client(builder.build())
                            .addConverterFactory(MvpGsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                            .baseUrl(Constrant.BASE_URL)
                            .build();
                    mService=mRetrofit.create(ApiService.class);



                }
            }
        }
        return  mService;

    }
}
