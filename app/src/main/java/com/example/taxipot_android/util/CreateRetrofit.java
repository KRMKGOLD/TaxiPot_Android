package com.example.taxipot_android.util;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateRetrofit {
    private final static String baseUrl = "http://192.168.0.6:8080/";
    private final static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
    public static <T> T createRetrofit(Class<T> clazz) {
        return retrofit.create(clazz);
    }
}
