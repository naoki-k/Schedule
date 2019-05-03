package com.example.workspace.schedule.presentation.home.plans;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.workspace.schedule.R;

public class PlanCardsViewGroup extends FrameLayout {
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

        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        ViewGroup.LayoutParams params = this.getLayoutParams();
        heightSize = params.height;
    }

    public void addPlanCard(PlanCardView view) {

        // 追加するViewのサイズと位置を指定
        view.measure(MeasureSpec.makeMeasureSpec(widthSize - 10, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(getChildHeight(view), MeasureSpec.EXACTLY));
        view.layout(0, getY(view), view.getMeasuredWidth(), view.getMeasuredHeight() + getY(view));
        view.setBackground(getResources().getDrawable(R.drawable.layout_bg_plan_card));
        this.addView(view);
    }

    private int getChildHeight(PlanCardView view) {
        int startHour = Integer.parseInt(view.getStartTime().substring(0,2));
        int endHour = Integer.parseInt(view.getEndTime().substring(0,2));
        int startMinute = Integer.parseInt(view.getStartTime().substring(3));
        int endMinute = Integer.parseInt(view.getEndTime().substring(3));

        int duringTime = (endHour - startHour) * 60 + (endMinute - startMinute);

        if (duringTime < 60) {
            view.getTitleTextView().setVisibility(View.GONE);
        } else {
            view.getTitleTextView().setVisibility(View.VISIBLE);
        }
        // 高さ計算がズレるので、179/150で微調整。原因不明
        return (heightSize/1680) * duringTime * 179 / 150;
    }

    public int getY(PlanCardView view) {
        int startHour = Integer.parseInt(view.getStartTime().substring(0,2));
        int startMinute = Integer.parseInt(view.getStartTime().substring(3));

        int totalMinute = (startHour * 60) + startMinute;
        // 高さ計算がズレるので、179/150で微調整。原因不明
        return (heightSize/1680) * (totalMinute + 75) * 179 / 150 ;
    }
}
