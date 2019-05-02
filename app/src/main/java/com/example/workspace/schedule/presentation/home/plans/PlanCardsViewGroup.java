package com.example.workspace.schedule.presentation.home.plans;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.workspace.schedule.R;

public class PlanCardsViewGroup extends ViewGroup {
    private int widthSize;
    private int heightSize;

    public PlanCardsViewGroup(Context context) {
        this(context, null);
    }

    public PlanCardsViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PlanCardsViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        //このViewGroupに割り当てられているサイズを取得する
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
    }

    public void addPlanCard(PlanCardView view) {
        // 追加するViewのサイズと位置を指定
        view.measure(MeasureSpec.makeMeasureSpec(100, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(100, MeasureSpec.EXACTLY));
        view.layout(0,0, view.getMeasuredWidth(), view.getMeasuredHeight());
        this.addView(view);
    }
}
