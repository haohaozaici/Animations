package com.example.hao.animations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;

/**
 * Created by hao on 2016/9/13.
 */
public class ActivityB extends AppCompatActivity {

    private ImageView circle2;
    private Interpolator interpolator;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);


        circle2 = (ImageView)findViewById(R.id.circle2);
        ViewGroup.LayoutParams params = circle2.getLayoutParams();
        params.height = 200;
        params.width = 200;
        setupWindowAnimations();
    }

    private void setupWindowAnimations() {
        interpolator = AnimationUtils.loadInterpolator(this, android.R.interpolator.linear_out_slow_in);
        setupEnterAnimations();
//        setupExitAnimations();
    }

    private void setupEnterAnimations() {
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.changebounds_with_arcmotion);
        getWindow().setSharedElementEnterTransition(transition);

    }

    private void setupExitAnimations() {
        Fade returnTransition = new Fade();
        getWindow().setReturnTransition(returnTransition);
//        returnTransition.setDuration(1000);
//        returnTransition.setStartDelay(1000);

    }


}
