/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.widget.codetail.animation;

import android.animation.ValueAnimator;

/**
 * Description 该类功能为：
 * Package com.darly.widget.codetail.animation
 *
 * @author zhangyuhui
 * @date 2019/8/21
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
class DynamicAnimator<T extends DynamicAnimation<T>>
        extends ValueAnimator implements DynamicAnimation.OnAnimationEndListener {
    private final DynamicAnimation<T> animation;

    public DynamicAnimator(DynamicAnimation<T> animation) {
        this.animation = animation;
        this.animation.addEndListener(this);
    }

    @Override
    public void start() {
        animation.start();

        for (AnimatorListener listener : getListeners()) {
            listener.onAnimationStart(this);
        }
    }

    @Override
    public void cancel() {
        animation.cancel();
    }

    @Override
    public boolean isRunning() {
        return animation.isRunning();
    }

    @Override
    public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value,
                               float velocity) {
        for (AnimatorListener listener : getListeners()) {
            if (canceled) {
                listener.onAnimationCancel(this);
            } else {
                listener.onAnimationEnd(this);
            }
        }
    }
}
