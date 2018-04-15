package com.example.vtewe.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Act_SportButtons extends AppCompatActivity {

    protected static int[] STATE_GO = {R.attr.state_default};
    protected static int[] STATE_SLOW_DOWN = {R.attr.state_pressed};
    protected static int[] STATE_STOP = {R.attr.state_deactivated};

    private void addSportsButtons() {
        ConstraintLayout buttonContainer = findViewById(R.id.clay_sports_types);
        ButtonBuilder bb = new ButtonBuilder(this, buttonContainer);
        bb.buildButtons();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_buttons);
        addSportsButtons();

        ConstraintLayout container = findViewById(R.id.container);
        container.setOnTouchListener(new OnSwipeTouchListener(Act_SportButtons.this) {
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
        Intent intent = new Intent( this, Act_Slider.class);
        startActivity(intent);
    }

}