package com.example.databinding.viewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.databinding.Repositories.GlobalConfigRepository;
import com.example.databinding.model.GlobalConfigDto;
import com.example.databinding.model.LoginResponseDto;
import com.example.databinding.model.RequestDto;

public class GlobalConfigViewModel extends AndroidViewModel {

    private final Context context;


    MutableLiveData<GlobalConfigDto> mutableLiveData;

    public GlobalConfigViewModel(@NonNull Application application) {
        super(application);
        this.context = application;

        if (mutableLiveData == null)
            mutableLiveData = new MutableLiveData<>();
    }

    public LiveData<LoginResponseDto> getApiCAll() {

        RequestDto mreq = new RequestDto();
        mreq.setUserName("20700086");
        mreq.setPassword("alluser");
        mreq.setDeviceId("LF713TEG9300OS55421");
        mreq.setAppType("FPS");
        return GlobalConfigRepository.getInstance(context).getData(mreq);
    }
}
