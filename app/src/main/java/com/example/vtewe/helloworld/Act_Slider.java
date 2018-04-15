package com.example.vtewe.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class Act_Slider extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__slider);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        handleSeekBar();
        addButtons();
        ConstraintLayout container = findViewById(R.id.slider_container);
       container.setOnTouchListener(new OnSwipeTouchListener(Act_Slider.this) {
            public void onSwipeTop() {
            }
            public void onSwipeRight() {
                ;            }
            public void onSwipeLeft() {
                startNewActivity();
            }
            public void onSwipeBottom() {
            }

        });
    }

    private void startNewActivity() {
        Intent intent = new Intent( this, Act_DragableStar.class);
        startActivity(intent);
    }

    private void addButtons() {
        ConstraintLayout buttonContainer = findViewById(R.id.clay_buttons);
        ButtonBuilder bb = new ButtonBuilder(this, buttonContainer);
        bb.buildButtons();
    }

    private void handleSeekBar() {
        // set a change listener on the SeekBar
        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(seekBarChangeListener);

        textView = findViewById(R.id.progress_text);
        textView.setText("move the slider");
    }

    SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // updated continuously as the user slides the thumb
            textView.setText("Progress: " + progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // called when the user first touches the SeekBar
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // called after the user finishes moving the SeekBar
        }
    };

}
