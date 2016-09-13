package com.example.hao.animations;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button next;
    private ImageView shareView;
    private final Activity activity = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupWindowAnimations();

        shareView = (ImageView)findViewById(R.id.circle);

        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityB.class);
                String transitionName = getString(R.string.transition_name);

                final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(activity, false,
                        new Pair<>(shareView, transitionName));

                ActivityOptionsCompat transitionActivityOption =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pairs);

                startActivity(intent, transitionActivityOption.toBundle());
            }
        });

    }

    private void setupWindowAnimations() {
        Slide slide = new Slide();
        slide.setDuration(500);
        getWindow().setExitTransition(slide);

    }
}
