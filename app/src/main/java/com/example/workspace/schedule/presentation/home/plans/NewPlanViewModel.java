package com.example.workspace.schedule.presentation.home.plans;

import android.view.View;

public class NewPlanViewModel extends android.arch.lifecycle.ViewModel {
    private NewPlanView planView;

    public NewPlanViewModel(NewPlanView view){
        this.planView = view;
    }

    public void onClick(View view) {
        planView.onClicked(view);
    }
}
