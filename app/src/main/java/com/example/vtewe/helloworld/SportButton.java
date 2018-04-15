package com.example.vtewe.helloworld;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

public class SportButton extends AppCompatButton {

    public enum CustomState {
        DEFAULT,
        PRESSED,
        DEACTIVATED
    }

    SportButton(Context context){
        super(context);
    }
    SportButton(Context context, AttributeSet attrs) {
        super(context,attrs);
    }

    SportButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected static int[] STATE_DEFAULT = { R.attr.state_default};
    protected static int[] STATE_PRESSED = { R.attr.state_pressed};
    protected static int[] STATE_DEACTIVATED = { R.attr.state_deactivated};

    private CustomState mState = CustomState.DEACTIVATED;

    public void update( ) {
        toggleState();
        refreshDrawableState();
    }

    private void toggleState(){
        if(mState.equals(CustomState.DEFAULT)) {
          mState = CustomState.PRESSED;
        }else{
              mState = CustomState.DEFAULT;
        }
    }
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        if( mState == null )
            return super.onCreateDrawableState(extraSpace);

        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);

        if( CustomState.DEFAULT.equals( mState ) ) {
            mergeDrawableStates( drawableState, STATE_DEFAULT);
            return drawableState;
        } else if( CustomState.PRESSED.equals( mState ) ) {
            mergeDrawableStates( drawableState, STATE_PRESSED);
            return drawableState;
        } else if( CustomState.DEACTIVATED.equals( mState) ) {
            mergeDrawableStates( drawableState, STATE_DEACTIVATED);
            return drawableState;
        } else {
            return super.onCreateDrawableState(extraSpace);
        }
    }

}