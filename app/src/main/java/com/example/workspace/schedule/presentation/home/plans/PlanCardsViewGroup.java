package com.example.workspace.schedule.presentation.home.plans;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

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
        //子ビューの位置を指定するメソッド
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        if (widthMode != MeasureSpec.EXACTLY || heightMode != MeasureSpec.EXACTLY) {
            throw new IllegalStateException("Must measure with an exact width");
        }

        //このViewGroupに割り当てられているサイズを取得する
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //このViewGroupのサイズをセットする
        setMeasuredDimension(widthSize, heightSize);
    }

    public void addPlanCard(PlanCardView view) {
        this.addView(view);
    }

    public int getWidthSize() {
        return widthSize;
    }

    public int getHeightSize() {
        return heightSize;
    }

}
