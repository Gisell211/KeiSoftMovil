package com.example.kei2.Retrofit_Data;

public class Apis {
    public static final String URL_001="http://10.0.2.2:8000/v1/";

    public static EspecieService getEspecieService(){
        return  Cliente.getClient(URL_001).create(EspecieService.class);
    }
}
