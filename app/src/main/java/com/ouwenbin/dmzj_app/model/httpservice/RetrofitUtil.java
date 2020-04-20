package com.ouwenbin.dmzj_app.model.httpservice;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
* 第一步
* Retrofit网络请求的实体类
* */

public class RetrofitUtil {

    private static RetrofitUtil instance;
    private static final String BASE_URL = "https://v3api.dmzj.com/";
    private Retrofit retrofit;

    @Inject
    public RetrofitUtil(){
        init();
    }
//    public static RetrofitUtil getInstance() {
//        if (instance == null) {
//            synchronized (RetrofitUtil.class) {
//                if (instance == null) {
//                    instance = new RetrofitUtil();
//                }
//            }
//        }
//        return instance;
//    }

//    private RetrofitUtil() {
//        init();
//    }

    private void init() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public <T> T create(Class<T> clazz) {
        return retrofit.create(clazz);
    }
}
