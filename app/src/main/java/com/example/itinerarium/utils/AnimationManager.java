package com.example.itinerarium.utils;

import android.content.Intent;
import android.view.View;

public class AnimationManager {
    
    private static final Float VISIBILITY_0 = 0.0f;
    private static final Float VISIBILITY_100 = 1.0f;

    public static void setAlphaAnimationToView(Integer duration, View view) {

        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(VISIBILITY_0, VISIBILITY_100);
        alphaAnimation.setDuration(duration);
        view.startAnimation(alphaAnimation);
    }
}
