package com.example.databinding.Repositories;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.databinding.model.NewDto;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityRepository {
    private static MainActivityRepository mainActivityRepository;
    ApiUrlList apiUrlList;

    public static MainActivityRepository getInstance(Context context) {
        if (mainActivityRepository == null) {
            mainActivityRepository = new MainActivityRepository();
        }

        return mainActivityRepository;
    }
    public MainActivityRepository() {
        apiUrlList = RetrofitClient.createService(ApiUrlList.class);
    }
    public MutableLiveData<NewDto> getData() {

        MutableLiveData<NewDto> mResponseLiveData = new MutableLiveData<>();
        apiUrlList.mGetCaptcha().enqueue(new Callback<NewDto>() {
            @Override
            public void onResponse(Call<NewDto> call, Response<NewDto> response) {
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
            public void onFailure(Call<NewDto> call, Throwable throwable) {
                mResponseLiveData.setValue(null);
                Log.e("onResponse", "failure");
            }


        });
        return mResponseLiveData;
    }

}
