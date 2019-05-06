package com.example.workspace.schedule.presentation.home;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.workspace.schedule.R;
import com.example.workspace.schedule.databinding.ActivityHomeBinding;
import com.example.workspace.schedule.presentation.home.plans.NewPlanDialogFragment;
import com.example.workspace.schedule.presentation.home.plans.NewPlanView;
import com.example.workspace.schedule.presentation.home.plans.PlanCardView;
import com.example.workspace.schedule.presentation.home.plans.PlanCardsViewGroup;

public class HomeActivity extends AppCompatActivity implements HomeView {
    private final HomeActivity self = this;
    private ActivityHomeBinding binding;
    private HomeViewModel viewModel;
    private PlanCardsViewGroup viewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        viewModel = new HomeViewModel(this);
        binding.setViewModel(viewModel);

        viewGroup = binding.viewGroup;

        Display display = this.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void onClicked(View view) {
        NewPlanDialogFragment newPlanDialogFragment = new NewPlanDialogFragment();
        newPlanDialogFragment.show(getSupportFragmentManager(), NewPlanDialogFragment.class.getSimpleName());
    }

    public void onDialogFragmentResult(PlanCardView view) {
        viewGroup.addPlanCard(view);
    }
}

aaaaa

