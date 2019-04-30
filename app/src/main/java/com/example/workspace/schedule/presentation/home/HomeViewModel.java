package com.example.workspace.schedule.presentation.home;

import android.view.View;
import com.example.workspace.schedule.presentation.ViewModel;

public interface HomeViewModel extends ViewModel<HomeView> {

    void onClick(View view);

    void init(HomeView view);
}
