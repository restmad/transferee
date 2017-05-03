package com.hitomi.tilibrary.style.index;

import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.hitomi.tilibrary.style.IIndexIndicator;
import com.hitomi.tilibrary.view.indicator.NumberIndicator;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by Hitomis on 2017/4/23 0023.
 */

public class NumberIndexIndicator implements IIndexIndicator {

    private NumberIndicator numberIndicator;

    @Override
    public void attach(FrameLayout parent) {
        FrameLayout.LayoutParams indexLp = new FrameLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
        indexLp.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
        indexLp.topMargin = 30;

        numberIndicator = new NumberIndicator(parent.getContext());
        numberIndicator.setLayoutParams(indexLp);

        parent.addView(numberIndicator);
    }

    @Override
    public void onShow(ViewPager viewPager) {
        numberIndicator.setVisibility(View.VISIBLE);
        numberIndicator.setViewPager(viewPager);
    }

    @Override
    public void onHide() {
        numberIndicator.setVisibility(View.GONE);
    }

    @Override
    public void onRemove() {
        ViewGroup vg = (ViewGroup) numberIndicator.getParent();

        if (vg != null) {
            vg.removeView(numberIndicator);
        }
    }
}