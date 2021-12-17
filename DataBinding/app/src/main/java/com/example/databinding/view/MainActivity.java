package com.example.databinding.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.databinding.R;
import com.example.databinding.databinding.ActivityMainBinding;
import com.example.databinding.model.NewDto;
import com.example.databinding.viewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        Observer<NewDto> dbObserver = new Observer<NewDto>() {
            @Override
            public void onChanged(@Nullable final NewDto loginResponseDtoResponse) {

                binding.setUser(loginResponseDtoResponse);
            }
        };
        mainActivityViewModel.getApiCAll().observe(MainActivity.this, dbObserver);

    }
}