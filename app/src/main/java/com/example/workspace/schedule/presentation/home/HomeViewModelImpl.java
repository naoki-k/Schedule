package com.example.workspace.schedule.presentation.home;

import android.view.View;

public class HomeViewModelImpl implements HomeViewModel {
    private HomeView view;

    public HomeViewModelImpl() {
    }

    @Override public void init(HomeView view) {
        this.view = view;
    }

    @Override
    public void onClick(View view) {

    }
}
