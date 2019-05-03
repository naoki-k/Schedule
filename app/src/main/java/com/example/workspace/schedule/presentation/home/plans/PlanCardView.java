package com.example.workspace.schedule.presentation.home.plans;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PlanCardView extends RelativeLayout {

    private TextView titleTextView;

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

        this.setGravity(Gravity.CENTER);

        titleTextView = new TextView(getContext());
        titleTextView.setPaintFlags(titleTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        titleTextView.setText(title);
        titleTextView.setTextColor(getResources().getColor(android.R.color.white));
        titleTextView.setGravity(Gravity.CENTER);
        titleTextView.setPadding(50, 0, 50, 0);
        addView(titleTextView);
    }

    public String getTitle() {
        return title;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public TextView getTitleTextView() {
        return titleTextView;
    }
}
