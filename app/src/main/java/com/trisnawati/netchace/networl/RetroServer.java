package com.trisnawati.netchace.networl;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//todo 3
public class RetroServer {

    //todo 4
    public static String BASE_URL = "http://jsonplaceholder.typicode.com/";
    public static Retrofit setInit(){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    public  static ApiService getInstancee(){
        return setInit().create(ApiService.class);
    }
}
