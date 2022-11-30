package com.example.kei2.Retrofit_Data;

import com.example.kei2.Modelo.Especie;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EspecieService {
    @GET("especie/")
    Call<List<Especie>> getEspecie();

    @POST("especie/")
    Call<Especie>addEspecie(@Body Especie especie);

    @PUT("especie/{id}")
    Call<Especie>updateEspecie(@Body Especie especie,@Path("id") int id);

    @DELETE("especie/{id}")
    Call<Especie>deleteEspecie(@Path("id")int id);
}
