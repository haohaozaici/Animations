package com.example.hao.animations;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Sample> mSamples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupWindowAnimations();
        setupSamples();
        setupToolbar();
        setupLayout();

    }

    private void setupWindowAnimations() {
        Slide slide = new Slide();
        slide.setDuration(500);
        getWindow().setExitTransition(slide);

    }

    private void setupSamples() {
        mSamples = Arrays.asList(
                new Sample(ContextCompat.getColor(this, R.color.sample_red), "Transitions"),
                new Sample(ContextCompat.getColor(this, R.color.sample_blue), "Shared Elements"),
                new Sample(ContextCompat.getColor(this, R.color.sample_green), "View animations"),
                new Sample(ContextCompat.getColor(this, R.color.sample_yellow), "Circular Reveal Animation")
        );
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    private void setupLayout() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.sample_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SamplesRecyclerAdapter samplesRecyclerAdapter = new SamplesRecyclerAdapter(this, mSamples);
        recyclerView.setAdapter(samplesRecyclerAdapter);
    }


}
