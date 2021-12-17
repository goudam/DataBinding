package com.example.databinding.view.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.databinding.R;
import com.example.databinding.databinding.ActivityMain3Binding;
import com.example.databinding.model.GlobalConfigDto;
import com.example.databinding.model.LoginResponseDto;
import com.example.databinding.view.adapter.RecycleViewAdapter;
import com.example.databinding.viewModel.GlobalConfigViewModel;

import java.util.ArrayList;

public class RecycleViewWithDataBindingActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    GlobalConfigViewModel globalConfigViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMain3Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_main3);

        mRecycleView = (RecyclerView) findViewById(R.id.mRecycleView);
        ArrayList<GlobalConfigDto> list = new ArrayList<>();
        RecycleViewAdapter RecycleViewAdapter = new RecycleViewAdapter(this, list);
//        binding.setUser(RecycleViewAdapter);
        globalConfigViewModel = new ViewModelProvider(this).get(GlobalConfigViewModel.class);


        Observer<LoginResponseDto> dbObserver = new Observer<LoginResponseDto>() {
            @Override
            public void onChanged(@Nullable final LoginResponseDto loginResponseDtoResponse) {
                list.addAll(loginResponseDtoResponse.getGlobalConfigs());
                binding.setUser(RecycleViewAdapter);
            }
        };
        globalConfigViewModel.getApiCAll().observe(RecycleViewWithDataBindingActivity.this, dbObserver);

    }
}