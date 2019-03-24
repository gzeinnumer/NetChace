package com.trisnawati.netchace.networl;

import com.trisnawati.netchace.model.ResponseJson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    //todo 5
    @GET("posts")
    Call<List<ResponseJson>> getData();
}
