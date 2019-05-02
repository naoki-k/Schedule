package com.example.workspace.schedule.presentation.home.plans;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PlanCardView extends View {

    private String startTime;
    private String endTime;
    private String title = "";

    public PlanCardView(Context context) {
        this(context, null);
    }

    public PlanCardView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PlanCardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    // パラメータのセットをするメソッド newした後に必ず呼び出す
    public void setParams(String title, String startTime, String endTime) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
