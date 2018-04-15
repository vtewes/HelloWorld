package com.example.vtewe.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Act_SportButtons extends AppCompatActivity {

    public enum CustomState {
        GO,
        SLOW_DOWN,
        STOP
    }

    protected static int[] STATE_GO = {R.attr.state_default};
    protected static int[] STATE_SLOW_DOWN = {R.attr.state_pressed};
    protected static int[] STATE_STOP = {R.attr.state_deactivated};

    private ConstraintLayout buttonContainer;
    private ConstraintSet constraintSet;

    private void addSportsButtons() {
        buttonContainer = findViewById(R.id.clay_sports_types);
        constraintSet = new ConstraintSet();
        constraintSet.clone(buttonContainer);

        SportButton btn_football = createSportButton(R.string.txt_btn_football);
        handleConstraintSetFirstButton(btn_football);
        configureButton(btn_football);

        SportButton btn_squash = createSportButton(R.string.txt_btn_squash);
        handleConstraintSetAddLeft(btn_squash, btn_football);
        configureButton(btn_squash);

        SportButton btn_fitness = createSportButton(R.string.txt_btn_fitness);
        handleConstraintSetAddLeft(btn_fitness, btn_squash);
        configureButton(btn_fitness);


        //next line
        SportButton btn_taekwondo = createSportButton(R.string.txt_btn_takewondo);
        handleConstraintSetAddNewLine(btn_taekwondo, btn_football);
        configureButton(btn_taekwondo);

        SportButton btn_swimming = createSportButton(R.string.txt_btn_swimming);
        handleConstraintSetAddLeft(btn_swimming, btn_taekwondo);
        configureButton(btn_swimming);

        SportButton btn_wingChung = createSportButton(R.string.txt_btn_wingChun);
        handleConstraintSetAddLeft(btn_wingChung, btn_swimming);
        configureButton(btn_wingChung);

        constraintSet.applyTo(buttonContainer);
    }

    private SportButton createSportButton(int caption) {
        SportButton button = new SportButton(this);
        button.setId(View.generateViewId());
        button.setText(caption);
        buttonContainer.addView(button);
        return button;
    }

    private void handleConstraintSetFirstButton(SportButton newSportButton) {
        constraintSet.connect(newSportButton.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0);
        constraintSet.connect(newSportButton.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
        wrapButton(newSportButton);
    }

    private void handleConstraintSetAddLeft(SportButton newSportButton, SportButton previousButton) {
        constraintSet.connect(newSportButton.getId(), ConstraintSet.START, previousButton.getId(), ConstraintSet.END, 10);
        constraintSet.connect(newSportButton.getId(), ConstraintSet.TOP, previousButton.getId(), ConstraintSet.TOP, 0);
        wrapButton(newSportButton);
    }

    private void handleConstraintSetAddNewLine(SportButton newSportButton, SportButton topButton) {
        constraintSet.connect(newSportButton.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 0);
        constraintSet.connect(newSportButton.getId(), ConstraintSet.TOP, topButton.getId(), ConstraintSet.BOTTOM, 10);
        wrapButton(newSportButton);
    }

    private void wrapButton(SportButton newSportButton) {
        constraintSet.constrainHeight(newSportButton.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.constrainWidth(newSportButton.getId(), ConstraintSet.WRAP_CONTENT);
    }

    private void configureButton(final SportButton sportButton) {
        sportButton.setBackgroundResource(R.drawable.custom_state_background);
        sportButton.update();
        sportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sportButton.update();
            }
        });
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
        Intent intent = new Intent( this, Act_ConstraintTest.class);
        startActivity(intent);
    }

}