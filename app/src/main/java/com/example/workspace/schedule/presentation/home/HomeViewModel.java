package com.example.workspace.schedule.presentation.home;

import android.view.View;

public class HomeViewModel extends android.arch.lifecycle.ViewModel {
    private HomeView homeView;

    public HomeViewModel(HomeView view) {
        this.homeView = view;
    }

    public void onClick(View view) {
        homeView.onClicked(view);
    }
}
