package com.example.hao.animations;

import android.databinding.BindingAdapter;
import android.support.annotation.ColorRes;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by hao on 2016-09-13.
 */
public class Sample implements Serializable{

    final int color;
    private final String name;

    public Sample(@ColorRes int color, String name){
        this.color = color;
        this.name = name;
    }

    @BindingAdapter("bind:colorTint")
    public static void setColorTint(ImageView view, @ColorRes int color) {
        DrawableCompat.setTint(view.getDrawable(), color);
        //view.setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }

    public int getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
