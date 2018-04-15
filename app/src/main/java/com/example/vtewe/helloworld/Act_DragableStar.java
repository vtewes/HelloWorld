package com.example.vtewe.helloworld;

import android.annotation.SuppressLint;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Act_DragableStar extends AppCompatActivity {

    private int xDelta;
    private int yDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_dragable_star);
        addOnTouchListener();

        Toast.makeText(Act_DragableStar.this,
                "Drag me!", Toast.LENGTH_SHORT)
                .show();
    }

    private void addOnTouchListener() {

        final RelativeLayout layout = findViewById(R.id.rlay_star);
        final ImageView imageStar = findViewById(R.id.image_star);

        imageStar.setOnTouchListener(new View.OnTouchListener() {
            View.OnTouchListener listener;
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                listener = onTouchListener();
                return listener.onTouch(view,event);
            }

            private View.OnTouchListener onTouchListener() {

                listener =  new View.OnTouchListener() {

                    @SuppressLint("ClickableViewAccessibility")
                    @Override
                    public boolean onTouch(View view, MotionEvent event) {

                        final int x = (int) event.getRawX();
                        final int y = (int) event.getRawY();

                        switch (event.getAction() & MotionEvent.ACTION_MASK) {

                            case MotionEvent.ACTION_DOWN:
                                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams)
                                        view.getLayoutParams();

                                xDelta = x - lParams.leftMargin;
                                yDelta = y - lParams.topMargin;
                                break;

                            case MotionEvent.ACTION_UP:
                                break;

                            case MotionEvent.ACTION_MOVE:
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                                        .getLayoutParams();
                                layoutParams.leftMargin = x - xDelta;
                                layoutParams.topMargin = y - yDelta;
                                layoutParams.rightMargin = 0;
                                layoutParams.bottomMargin = 0;
                                view.setLayoutParams(layoutParams);
                                break;
                        }
                        layout.invalidate();
                        return true;
                    }
                };

                return listener;
            }

        });
    }
}
