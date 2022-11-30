package com.example.kei2.Retrofit_Data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Cliente {

    public static Retrofit getClient(String url){
        Retrofit retrofit= new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return  retrofit;
    }
}
