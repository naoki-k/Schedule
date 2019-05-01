package com.example.workspace.schedule.presentation.home;

import android.view.View;

public class HomeViewModelImpl implements HomeViewModel {
    private HomeView homeView;

    @Override
    public void onClick(View view) {

    }

    @Override
    public void init(HomeView view) {
        this.homeView = view;
    }
}
