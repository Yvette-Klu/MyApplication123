package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("Newsline")

    Call<List<serviceModel>> getServices();
}
