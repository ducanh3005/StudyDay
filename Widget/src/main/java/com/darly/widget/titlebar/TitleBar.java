/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.widget.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.darly.widget.R;

/**
 * Description TODO: 自定义一个标题栏
 * Package com.darly.widget.titlebar
 *
 * @author zhangyuhui
 * @date 2019/8/23 14:09
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class TitleBar extends Toolbar {

    private TextView toolbar_title;
    private ImageView toolbar_leftButton;
    private ImageView toolbar_rightButton_img;
    private TextView toolbar_rightButton;
    private View mChildView;
    private Drawable left_button_icon;
    private Drawable right_button_icon;
    private String title;

    public interface OnLeftButtonClickListener {
        void onClick(View view);
    }

    public interface OnRightButtonClickListener {
        void onClick(View view);

    }

    private OnLeftButtonClickListener onLeftButtonClickListener;
    private OnRightButtonClickListener onRightButtonClickListener;

    public void setOnLeftButtonClickListener(OnLeftButtonClickListener listener) {
        onLeftButtonClickListener = listener;
    }

    public void setOnRightButtonClickListener(OnRightButtonClickListener listener) {
        onRightButtonClickListener = listener;
    }

    public TitleBar(Context context) {
        this(context, null, 0);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取自定义属性
        final TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomToolbar, defStyleAttr, 0);
        left_button_icon = a.getDrawable(R.styleable.CustomToolbar_leftButtonIcon);
        right_button_icon = a.getDrawable(R.styleable.CustomToolbar_rightButtonIcon);
        title = a.getString(R.styleable.CustomToolbar_myTitle);
        a.recycle();
        initView();//初始化视图
        initListener();//初始化监听器
    }

    private void initListener() {
        toolbar_leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onLeftButtonClickListener!=null) {
                    onLeftButtonClickListener.onClick(view);
                }
            }
        });

        toolbar_rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onRightButtonClickListener!=null) {
                    onRightButtonClickListener.onClick(view);
                }
            }
        });
        toolbar_rightButton_img.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onRightButtonClickListener!=null) {
                    onRightButtonClickListener.onClick(view);
                }
            }
        });
    }

    private void initView() {
        if (mChildView == null) {
            mChildView = View.inflate(getContext(), R.layout.custom_toolbar, null);
            toolbar_leftButton = mChildView.findViewById(R.id.toolbar_leftButton);
            toolbar_rightButton_img = mChildView.findViewById(R.id.toolbar_rightButton_img);
            toolbar_rightButton = mChildView.findViewById(R.id.toolbar_rightButton);
            toolbar_title = mChildView.findViewById(R.id.toolbar_title);
            addView(mChildView);
            if (left_button_icon != null) {
                toolbar_leftButton.setImageDrawable(left_button_icon);
            }
            if (right_button_icon !=null){
                toolbar_rightButton_img.setImageDrawable(right_button_icon);
            }
            toolbar_leftButton.setVisibility(VISIBLE);
            toolbar_rightButton.setVisibility(VISIBLE);
            toolbar_rightButton_img.setVisibility(GONE);
            if(toolbar_title != null) {
                toolbar_title.setText(title);
            }
        }
    }

    public void setCenterTitle(String title){
        toolbar_title.setText(title);
    }

    public void setCenterTitle(int resId){
        toolbar_title.setText(resId);
    }

    /**
     * 设置左右按钮的图标
     *
     * @param d
     */
    public void setLeftButtonIconDrawable(Drawable d) {
        toolbar_leftButton.setImageDrawable(d);
    }

    public void setRightButtonIconDrawable(Drawable d) {
        toolbar_rightButton_img.setImageDrawable(d);
    }

    public void setRightButtonText(String rightButtonText) {
        toolbar_rightButton.setText(rightButtonText);
    }

    public void setLeftVisiable(boolean show) {
        if (show){
            toolbar_leftButton.setVisibility(VISIBLE);
        }else {
            toolbar_leftButton.setVisibility(INVISIBLE);
        }

    }

    public void setRightVisiable(boolean show) {

        if (show){
            toolbar_rightButton.setVisibility(VISIBLE);
        }else {
            toolbar_rightButton.setVisibility(INVISIBLE);
        }
    }

    public void setRightImgVisiable(boolean show) {
        if (show){
            toolbar_rightButton_img.setVisibility(VISIBLE);
        }else {
            toolbar_rightButton_img.setVisibility(GONE);
        }
    }

}
