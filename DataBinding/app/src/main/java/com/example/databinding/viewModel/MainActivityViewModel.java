package com.example.databinding.viewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.databinding.Repositories.MainActivityRepository;
import com.example.databinding.model.NewDto;

public class MainActivityViewModel extends AndroidViewModel {

    private final Context context;



    MutableLiveData<NewDto> mutableLiveData ;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application;

        if (mutableLiveData == null)
            mutableLiveData = new MutableLiveData<>();
    }

    public LiveData<NewDto> getApiCAll() {
        return MainActivityRepository.getInstance(context).getData();
    }
}
