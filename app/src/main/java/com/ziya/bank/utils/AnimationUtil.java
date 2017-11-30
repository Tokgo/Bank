package com.ziya.bank.utils;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.ziya.bank.R;


/**
 * Created by Oliver on 16/1/13.
 */
public class AnimationUtil {
    public static void shakeAnim(Context context, View view) {
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.shake_x);
        view.startAnimation(anim);
    }
}
