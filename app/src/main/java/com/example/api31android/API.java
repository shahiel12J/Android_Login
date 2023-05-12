package com.example.api31android;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {

    @POST("register")
    Call<ResponseBody> createUser (
            @Body Users user
    );

    @POST("login")
    Call<ResponseBody> checkUser (
            @Body Users user
    );

}
