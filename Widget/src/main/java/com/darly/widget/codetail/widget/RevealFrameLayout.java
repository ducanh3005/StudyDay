/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.widget.codetail.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.darly.widget.codetail.animation.RevealViewGroup;
import com.darly.widget.codetail.animation.ViewRevealManager;

/**
 * Description 该类功能为：
 * Package com.darly.widget.codetail.widget
 * @author zhangyuhui
 * @date 2019/8/21
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class RevealFrameLayout extends FrameLayout implements RevealViewGroup {
  private ViewRevealManager manager;

  public RevealFrameLayout(Context context) {
    this(context, null);
  }

  public RevealFrameLayout(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public RevealFrameLayout(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);

    manager = new ViewRevealManager();
  }

  @Override protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
    try {
      canvas.save();
      return manager.transform(canvas, child)
          & super.drawChild(canvas, child, drawingTime);
    } finally {
      canvas.restore();
    }
  }

  @Override
  public void setViewRevealManager(ViewRevealManager manager) {
    if (manager == null) {
      throw new NullPointerException("ViewRevealManager is null");
    }

    this.manager = manager;
  }

  @Override public ViewRevealManager getViewRevealManager() {
    return manager;
  }
}
