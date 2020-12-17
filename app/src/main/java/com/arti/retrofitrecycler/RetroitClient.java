package com.arti.retrofitrecycler;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroitClient {
    private Retrofit retrofit;
    private static RetroitClient mInstance;
    private static final String BASE_URL = "https://navneet7k.github.io/";

    public RetroitClient() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }


    public static synchronized RetroitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetroitClient();
        }
        return mInstance;
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }
}
