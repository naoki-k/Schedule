package com.example.workspace.schedule.presentation.home;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.workspace.schedule.R;
import com.example.workspace.schedule.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity implements HomeView {
    private final HomeActivity self = this;
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public Context getContext() {
        return null;
    }
}
