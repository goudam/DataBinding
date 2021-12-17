package com.example.databinding.Repositories;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://www.boredapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }


    private static Retrofit retrofitFPS = new Retrofit.Builder()
            .baseUrl("http://testfps.uppds.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static <S> S createFPSService(Class<S> serviceClass) {
        return retrofitFPS.create(serviceClass);
    }
}
