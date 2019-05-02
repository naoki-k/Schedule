package com.example.workspace.schedule.presentation.home.plans;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PlanCardView extends View {
    private String startTime;
    private String endTime;
    private String title = "";

    private int widthSize;
    private int heightSize;

    public PlanCardView(Context context) {
        this(context, null);
    }

    public PlanCardView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PlanCardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        //このViewGroupに割り当てられているサイズを取得する
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //このViewGroupのサイズをセットする
        setMeasuredDimension(widthSize, heightSize);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    // パラメータのセットをするメソッド newした後に必ず呼び出す
    public void setParams(String title, String startTime, String endTime) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
