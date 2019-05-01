package com.example.workspace.schedule.presentation.home.plans;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PlanCardView extends View {
    String startTime;
    String endTime;
    String title;

    public PlanCardView(Context context) {
        this(context, null);
    }

    public PlanCardView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PlanCardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
