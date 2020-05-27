package com.darly.chinese.common;

import android.annotation.TargetApi;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;

/**
 * author:zhangyuhui
 * date:2020-05-2717:11
 * description: 预加载效果对象类
 */
public class DrawableUtils {
    private DrawableUtils(){
        throw new UnsupportedOperationException("Can not be instantiated.");
    }

    public static GradientDrawable createRectangleDrawable(int color, float cornerRadius) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setCornerRadius(cornerRadius);
        gradientDrawable.setColor(color);
        return gradientDrawable;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static GradientDrawable createRectangleDrawable(int[] colors, float cornerRadius) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setCornerRadius(cornerRadius);
        gradientDrawable.setColors(colors);
        return gradientDrawable;
    }

    public static GradientDrawable createOvalDrawable(int color) {
        GradientDrawable gradientDrawable =  new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.OVAL);
        gradientDrawable.setColor(color);
        return gradientDrawable;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static GradientDrawable createOvalDrawable(int[] colors) {
        GradientDrawable gradientDrawable =  new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.OVAL);
        gradientDrawable.setColors(colors);
        return gradientDrawable;
    }
}
