/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.widget.codetail.animation;

import android.animation.Animator;
import android.view.View;

/**
 * Description 该类功能为：
 * Package com.darly.widget.codetail.animation
 *
 * @author zhangyuhui
 * @date 2019/8/21
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class SpringViewAnimatorManager extends ViewRevealManager {

    private final static DynamicAnimation.Property<RevealValues> RADIUS_PROPERTY =
            new DynamicAnimation.Property<RevealValues>("radius") {
                @Override
                public void setValue(RevealValues view, float value) {
                    view.radius = value;
                    view.target.invalidate();
                }

                @Override
                public float getValue(RevealValues view) {
                    return view.radius;
                }
            };

    private SpringForce force = new SpringForce();

    public SpringViewAnimatorManager() {
        super(new PathTransformation());
    }

    /**
     * In order to enable spring animation on devices running Lollipop & higher we override default
     * {@link ViewAnimationUtils#createCircularReveal(View, int, int, float, float)} running way
     */
    @Override
    protected boolean overrideNativeAnimator() {
        return true;
    }

    /**
     * Sets the stiffness of a spring. The more stiff a spring is, the more force it applies to
     * the object attached when the spring is not at the final position. Default stiffness is
     * {@link SpringForce#STIFFNESS_MEDIUM}.
     *
     * @param stiffness non-negative stiffness constant of a spring
     * @return the spring force that the given stiffness is set on
     * @throws IllegalArgumentException if the given spring stiffness is negative.
     */
    public void setStiffness(float stiffness) {
        force.setStiffness(stiffness);
    }

    /**
     * Gets the stiffness of the spring.
     *
     * @return the stiffness of the spring
     */
    public float getStiffness() {
        return force.getStiffness();
    }

    /**
     * Spring damping ratio describes how oscillations in a system decay after a disturbance.
     * <p>
     * When damping ratio > 1 (over-damped), the object will quickly return to the rest position
     * without overshooting. If damping ratio equals to 1 (i.e. critically damped), the object will
     * return to equilibrium within the shortest amount of time. When damping ratio is less than 1
     * (i.e. under-damped), the mass tends to overshoot, and return, and overshoot again. Without
     * any damping (i.e. damping ratio = 0), the mass will oscillate forever.
     * <p>
     * Default damping ratio is {@link SpringForce#DAMPING_RATIO_MEDIUM_BOUNCY}.
     *
     * @param dampingRatio damping ratio of the spring, it should be non-negative
     * @return the spring force that the given damping ratio is set on
     * @throws IllegalArgumentException if the {@param dampingRatio} is negative.
     */
    public void setDampingRatio(float dampingRatio) {
        force.setDampingRatio(dampingRatio);
    }

    /**
     * Returns the damping ratio of the spring.
     *
     * @return damping ratio of the spring
     */
    public float getDampingRatio() {
        return force.getDampingRatio();
    }

    /**
     * This threshold defines how close the animation value needs to be before the animation can
     * finish. This default value is based on the property being animated, e.g. animations on alpha,
     * scale, translation or rotation would have different thresholds. This value should be small
     * enough to avoid visual glitch of "jumping to the end". But it shouldn't be so small that
     * animations take seconds to finish.
     *
     * @param threshold the difference between the animation value and final spring position that is
     *                  allowed to end the animation when velocity is very low
     */
    public void setDefaultThreshold(double threshold) {
        force.setDefaultThreshold(threshold);
    }

    @Override
    protected Animator createAnimator(final RevealValues data) {
        force.setFinalPosition(data.endRadius);

        final SpringAnimation animation = new SpringAnimation(data, RADIUS_PROPERTY);
        animation.setStartValue(data.startRadius);
        animation.setSpring(force);

        final DynamicAnimator<SpringAnimation> animator = new DynamicAnimator<>(animation);
        animator.addListener(getAnimatorCallback());
        return animator;
    }
}
