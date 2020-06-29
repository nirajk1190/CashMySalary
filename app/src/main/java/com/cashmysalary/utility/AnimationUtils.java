package com.cashmysalary.utility;


import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;


/**
 * Animation Util Class
 */
public final class AnimationUtils {


    /**
     * Don't let anyone instantiate this class.
     */
    private AnimationUtils() {
        throw new Error("Do not need instantiate!");
    }


    /**
     * The default duration of the animation
     */
    public static final long DEFAULT_ANIMATION_DURATION = 400;

    /**
     * Get a rotation animation
     *
     * @param fromDegrees
     * @param toDegrees
     * @param pivotXType
     * @param pivotXValue
     * @param pivotYType
     * @param pivotYValue
     * @param durationMillis
     * @param animationListener
     * @return
     */
    public static RotateAnimation getRotateAnimation(float fromDegrees, float toDegrees, int pivotXType, float pivotXValue, int pivotYType, float pivotYValue, long durationMillis, AnimationListener animationListener) {
        RotateAnimation rotateAnimation = new RotateAnimation(fromDegrees, toDegrees, pivotXType, pivotXValue, pivotYType, pivotYValue);
        rotateAnimation.setDuration(durationMillis);
        if (animationListener != null) {
            rotateAnimation.setAnimationListener(animationListener);
        }
        return rotateAnimation;
    }


    /**
     * Being a center of rotation according to the view of their own animation
     *
     * @param durationMillis
     * @param animationListener
     * @return
     */
    public static RotateAnimation getRotateAnimationByCenter(long durationMillis, AnimationListener animationListener) {
        return getRotateAnimation(0f, 359f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, durationMillis, animationListener);
    }


    /**
     * Being a center of rotation according to animation
     *
     * @param duration
     * @return
     */
    public static RotateAnimation getRotateAnimationByCenter(long duration) {
        return getRotateAnimationByCenter(duration, null);
    }


    /**
     * Being a center of rotation according to the view of their own animation
     *
     * @param animationListener
     * @return
     */
    public static RotateAnimation getRotateAnimationByCenter(AnimationListener animationListener) {
        return getRotateAnimationByCenter(DEFAULT_ANIMATION_DURATION, animationListener);
    }


    /**
     * Being a center of rotation according to animation
     *
     * @return
     */
    public static RotateAnimation getRotateAnimationByCenter() {
        return getRotateAnimationByCenter(DEFAULT_ANIMATION_DURATION, null);
    }


    /**
     * Get a transparency gradient animation
     *
     * @param fromAlpha
     * @param toAlpha
     * @param durationMillis
     * @param animationListener
     * @return
     */
    public static AlphaAnimation getAlphaAnimation(float fromAlpha, float toAlpha, long durationMillis, AnimationListener animationListener) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(fromAlpha, toAlpha);
        alphaAnimation.setDuration(durationMillis);
        if (animationListener != null) {
            alphaAnimation.setAnimationListener(animationListener);
        }
        return alphaAnimation;
    }

    /**
     * Get a transparency gradient animation
     *
     * @param fromAlpha
     * @param toAlpha
     * @param durationMillis
     * @return
     */
    public static AlphaAnimation getAlphaAnimation(float fromAlpha, float toAlpha, long durationMillis) {
        return getAlphaAnimation(fromAlpha, toAlpha, durationMillis, null);
    }


    /**
     * Get a transparency gradient animation
     *
     * @param fromAlpha
     * @param toAlpha
     * @param animationListener
     * @return
     */
    public static AlphaAnimation getAlphaAnimation(float fromAlpha, float toAlpha, AnimationListener animationListener) {
        return getAlphaAnimation(fromAlpha, toAlpha, DEFAULT_ANIMATION_DURATION, animationListener);
    }


    /**
     * Get a transparency gradient animation
     *
     * @param fromAlpha
     * @param toAlpha
     * @return
     */
    public static AlphaAnimation getAlphaAnimation(float fromAlpha, float toAlpha) {
        return getAlphaAnimation(fromAlpha, toAlpha, DEFAULT_ANIMATION_DURATION, null);
    }


    /**
     * Get a complete display becomes invisible by the transparency Tweening
     *
     * @param durationMillis
     * @param animationListener
     * @return
     */
    public static AlphaAnimation getHiddenAlphaAnimation(long durationMillis, AnimationListener animationListener) {
        return getAlphaAnimation(1.0f, 0.0f, durationMillis, animationListener);
    }


    /**
     * Get a complete display becomes invisible by the transparency Tweening
     *
     * @param durationMillis
     * @return
     */
    public static AlphaAnimation getHiddenAlphaAnimation(long durationMillis) {
        return getHiddenAlphaAnimation(durationMillis, null);
    }


    /**
     * Get a complete display becomes invisible by the transparency Tweening
     *
     * @param animationListener
     * @return
     */
    public static AlphaAnimation getHiddenAlphaAnimation(AnimationListener animationListener) {
        return getHiddenAlphaAnimation(DEFAULT_ANIMATION_DURATION, animationListener);
    }


    /**
     * Get a complete display becomes invisible by the transparency Tweening
     *
     * @return
     */
    public static AlphaAnimation getHiddenAlphaAnimation() {
        return getHiddenAlphaAnimation(DEFAULT_ANIMATION_DURATION, null);
    }


    /**
     * Gets a transparency gradient by the invisible becomes totally animated display
     *
     * @param durationMillis
     * @param animationListener
     * @return
     */
    public static AlphaAnimation getShowAlphaAnimation(long durationMillis, AnimationListener animationListener) {
        return getAlphaAnimation(0.0f, 1.0f, durationMillis, animationListener);
    }


    /**
     * Gets a transparency gradient by the invisible becomes totally animated display
     *
     * @param durationMillis
     * @return
     */
    public static AlphaAnimation getShowAlphaAnimation(long durationMillis) {
        return getAlphaAnimation(0.0f, 1.0f, durationMillis, null);
    }


    /**
     * Gets a transparency gradient by the invisible becomes totally animated display
     *
     * @param animationListener
     * @return
     */
    public static AlphaAnimation getShowAlphaAnimation(AnimationListener animationListener) {
        return getAlphaAnimation(0.0f, 1.0f, DEFAULT_ANIMATION_DURATION, animationListener);
    }


    /**
     * Gets a transparency gradient by the invisible becomes totally animated display
     *
     * @return
     */
    public static AlphaAnimation getShowAlphaAnimation() {
        return getAlphaAnimation(0.0f, 1.0f, DEFAULT_ANIMATION_DURATION, null);
    }


    /**
     * Get a shrink animation
     *
     * @param durationMillis
     * @param animationListener
     * @return
     */
    public static ScaleAnimation getLessenScaleAnimation(long durationMillis, AnimationListener animationListener) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, ScaleAnimation.RELATIVE_TO_SELF, ScaleAnimation.RELATIVE_TO_SELF);
        scaleAnimation.setDuration(durationMillis);
        scaleAnimation.setAnimationListener(animationListener);
        return scaleAnimation;
    }

    /**
     * Get a shrink animation
     *
     * @param durationMillis
     * @return
     */
    public static ScaleAnimation getLessenScaleAnimation(long durationMillis) {
        return getLessenScaleAnimation(DEFAULT_ANIMATION_DURATION);
    }


    /**
     * Get a shrink animation
     *
     * @param animationListener
     * @return
     */
    public static ScaleAnimation getLessenScaleAnimation(AnimationListener animationListener) {
        return getLessenScaleAnimation(DEFAULT_ANIMATION_DURATION, null);
    }


    /**
     * Get a zoom animation
     *
     * @param durationMillis
     * @param animationListener
     * @return
     */
    public static ScaleAnimation getAmplificationAnimation(long durationMillis, AnimationListener animationListener) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, ScaleAnimation.RELATIVE_TO_SELF, ScaleAnimation.RELATIVE_TO_SELF);
        scaleAnimation.setDuration(durationMillis);
        scaleAnimation.setAnimationListener(animationListener);
        return scaleAnimation;
    }


    /**
     * Get a zoom animation
     *
     * @param durationMillis
     * @return
     */
    public static ScaleAnimation getAmplificationAnimation(long durationMillis) {
        return getLessenScaleAnimation(DEFAULT_ANIMATION_DURATION);
    }

    /**
     * Get a zoom animation
     *
     * @param animationListener
     * @return
     */
    public static ScaleAnimation getAmplificationAnimation(AnimationListener animationListener) {
        return getLessenScaleAnimation(DEFAULT_ANIMATION_DURATION, null);
    }
}
