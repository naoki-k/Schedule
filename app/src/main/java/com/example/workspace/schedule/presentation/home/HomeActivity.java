package com.example.workspace.schedule.presentation.home;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.workspace.schedule.R;
import com.example.workspace.schedule.databinding.ActivityHomeBinding;
import com.example.workspace.schedule.presentation.home.plans.NewPlanDialogFragment;

public class HomeActivity extends AppCompatActivity implements HomeView {
    private final HomeActivity self = this;
    private ActivityHomeBinding binding;
    private HomeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        viewModel = new HomeViewModel() {
            @Override
            public void init(HomeView view) {
            }

            @Override
            public void onClick(View view) {
                NewPlanDialogFragment newPlanDialogFragment = new NewPlanDialogFragment();
                newPlanDialogFragment.show(getSupportFragmentManager(), NewPlanDialogFragment.class.getSimpleName());
            }
        };
        binding.setViewModel(viewModel);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
