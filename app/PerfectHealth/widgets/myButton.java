package com.abdulrahman.asus.PerfectHealth.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by asus on 8/27/2017.
 */

public class myButton extends android.support.v7.widget.AppCompatButton {

    public myButton(Context context) {
        super(context);
        Typeface tp = Typeface.createFromAsset(context.getAssets(),"fonts/DroidKufi-Regular.ttf");
        this.setTypeface(tp);
    }

    public myButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface tp = Typeface.createFromAsset(context.getAssets(),"fonts/DroidKufi-Regular.ttf");
        this.setTypeface(tp);
    }

    public myButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface tp = Typeface.createFromAsset(context.getAssets(),"fonts/DroidKufi-Regular.ttf");
        this.setTypeface(tp);
    }

}
