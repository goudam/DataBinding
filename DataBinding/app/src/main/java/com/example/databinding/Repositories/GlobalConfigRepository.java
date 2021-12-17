package com.example.databinding.Repositories;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.databinding.model.LoginResponseDto;
import com.example.databinding.model.RequestDto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GlobalConfigRepository {
    private static GlobalConfigRepository mainActivityRepository;
    ApiUrlList apiUrlList;

    public static GlobalConfigRepository getInstance(Context context) {
        if (mainActivityRepository == null) {
            mainActivityRepository = new GlobalConfigRepository();
        }

        return mainActivityRepository;
    }

    public GlobalConfigRepository() {
        apiUrlList = RetrofitClient.createFPSService(ApiUrlList.class);
    }

    public MutableLiveData<LoginResponseDto> getData(RequestDto mRequestDto) {

        MutableLiveData<LoginResponseDto> mResponseLiveData = new MutableLiveData<>();
        apiUrlList.mGetDetails(mRequestDto).enqueue(new Callback<LoginResponseDto>() {
            @Override
            public void onResponse(Call<LoginResponseDto> call, Response<LoginResponseDto> response) {
                if (response.isSuccessful()) {
                    try {
                        String jsonString = response.body().toString();
                        mResponseLiveData.setValue(response.body());
                        Log.e("onResponse", jsonString);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    Log.e("onResponse", "failure");
                }
            }

            @Override
            public void onFailure(Call<LoginResponseDto> call, Throwable throwable) {
                mResponseLiveData.setValue(null);
                Log.e("onResponse", "failure");
            }


        });
        return mResponseLiveData;
    }
}