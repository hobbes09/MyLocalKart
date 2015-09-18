package com.mylocalkart.homescreen;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by sourin on 18/09/15.
 */
public class SubCategoryCustomGridView extends GridView {

    int mHeight;

    public SubCategoryCustomGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int desiredWidth = 100;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int width;

        // Measure Width
        if (widthMode == MeasureSpec.EXACTLY) {
            // Must be this size
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            // Can't be bigger than...
            width = Math.min(desiredWidth, widthSize);
        } else { // Be whatever you want
            width = desiredWidth;
        }

        // MUST CALL THIS
        setMeasuredDimension(width, mHeight);
    }

    public void SetHeight(int height) {
        mHeight = height;
    }


}
