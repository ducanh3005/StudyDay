/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.darly.widget.progress;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.darly.widget.R;

/**
 * Description TODO: 自定义一个好看的加载进度条，横向
 * Package com.darly.widget.titlebar
 *
 * @author zhangyuhui
 * @date 2019/8/23 14:09
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class BeautifulProgressBar extends RelativeLayout {

    private ImageView heart_layout;
    private ProgressBar progressBar;
    private int max = 100;//默认ProgressBar的最大值为100
    private int mProgress = 0;
    private int left;
    private int top;
    private int right;
    private int bottom;

    public BeautifulProgressBar(Context context) {
        super(context);
        init(context);
    }


    public BeautifulProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BeautifulProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mProgressBar_layout = inflater.inflate(R.layout.progress_beautiful, null);
        heart_layout = (ImageView) mProgressBar_layout.findViewById(R.id.heart_layout);
        progressBar = (ProgressBar) mProgressBar_layout.findViewById(R.id.progressBar);
        this.addView(mProgressBar_layout);

    }


    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        int iv_height = heart_layout.getMeasuredHeight();
        int iv_width = heart_layout.getMeasuredWidth();
        int iv_bottom = heart_layout.getBottom();
        int progress_left = progressBar.getLeft();
        int progress_width = progressBar.getMeasuredWidth();
        heart_layout.layout(progress_left + mProgress * (progress_width - iv_width) / max, iv_bottom - iv_height, progress_left + mProgress * (progress_width - iv_width) / max + iv_width, iv_bottom);
    }

    /**
     * 设置ProgressBar的进度及小人的位置
     *
     * @param progress
     */
    @SuppressLint("WrongCall")
    public void setProgress(int progress) {
        if (progress > max) {
            this.mProgress = max;
        } else {

            this.mProgress = progress;
        }
        this.onLayout(true, left, top, right, bottom);
        progressBar.setProgress(mProgress);
    }

    /**
     * 获取当前ProgressBar的进度
     *
     * @return
     */
    public int getProgress() {
        return mProgress;
    }

    /**
     * 设置ProgressBar的最大值
     *
     * @param max
     */
    public void setMax(int max) {
        this.max = max;
    }
}
