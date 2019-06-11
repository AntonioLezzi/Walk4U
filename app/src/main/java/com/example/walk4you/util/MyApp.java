package com.example.walk4you.util;

import android.app.Application;
import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApp extends Application {

    public static Context context = null;

    public static final String BASE_URL = "http://api.myservice.com";
    Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }



}
