package com.example.databinding.Repositories;


import com.example.databinding.model.LoginResponseDto;
import com.example.databinding.model.NewDto;
import com.example.databinding.model.RequestDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiUrlList {
    @GET("api/activity")
    Call<NewDto> mGetCaptcha();

    @POST("login/validateuser")
    Call<LoginResponseDto> mGetDetails(@Body RequestDto requestDto);


}
