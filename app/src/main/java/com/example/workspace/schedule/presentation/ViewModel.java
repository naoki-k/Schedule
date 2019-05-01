package com.example.workspace.schedule.presentation;

public interface ViewModel<T extends BaseView> {

    void init(T view);

}
