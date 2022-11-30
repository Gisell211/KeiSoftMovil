package com.example.kei2.Retrofit_Data;

import com.example.kei2.Modelo.RegisterRequ;
import com.example.kei2.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("user")
    Call<RegisterResponse>
    registerUsers(@Body RegisterRequ registerRequ);
}
