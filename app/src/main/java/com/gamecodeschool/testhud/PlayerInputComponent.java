package com.gamecodeschool.testhud;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;

public class PlayerInputComponent{


    static int mUpIndex = 10;
    static int mLeftIndex;
    static int mRightIndex;
    static int mAttackIndex;
    static int mJumpIndex;
    static int mPauseIndex;

    static int mUpID = 10;
    static int mLeftID;
    static int mRightID;
    static int mAttackID;
    static int mJumpID;
    static int mPauseID;

    static boolean mLeftPressed = false;
    static boolean mRightPressed = false;
    static boolean mAttackPressed = false;
    static boolean mJumpPressed = false;
    static boolean mPausePressed = false;



    static public void input(MotionEvent event, ArrayList<Rect> buttons) {

        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);


        int index = event.getActionIndex();
        int count = event.getPointerCount();
        int id = event.getPointerId(index);


        // Условный оператор тут не нужен сейчас, но позже пригодится
        if(true){
            switch ( event.getAction() & MotionEvent.ACTION_MASK ){

                case MotionEvent.ACTION_UP:

                    mUpIndex = index;
                    Log.e("mUpIndex", index + " ");
                    Log.e("mUpID", event.getPointerId(index) + " ");
                    Log.e("COUNT",  count + " ");

                    if( mLeftID == id )
                        mLeftPressed = false;
                    if ( mRightID == id)
                        mRightPressed = false;
                    if ( mJumpID == id)
                        mJumpPressed = false;
                    if ( mAttackID == id)
                        mAttackPressed = false;
                    if ( mPauseID == id)
                        mPausePressed = false;


                    break;

                case MotionEvent.ACTION_POINTER_UP:
                    mUpIndex = index;
                    Log.e("mUpIndex", index + " ");
                    Log.e("mUpID", event.getPointerId(index) + " ");
                    Log.e("COUNT",  count + " ");

                    if( mLeftID == id )
                        mLeftPressed = false;
                    if ( mRightID == id)
                        mRightPressed = false;
                    if ( mJumpID == id)
                        mJumpPressed = false;
                    if ( mAttackID == id)
                        mAttackPressed = false;
                    if ( mPauseID == id)
                        mPausePressed = false;

                    break;

                case MotionEvent.ACTION_DOWN:
                    if(buttons.get(HUD.LEFT).contains(x,y)){
                        mLeftID = event.getPointerId(index);
                        mLeftPressed = true;
                    }
                    else if( buttons.get(HUD.RIGHT).contains(x,y)){
                        mRightID = event.getPointerId(index);
                        mRightPressed = true;
                    }
                    else if( buttons.get(HUD.JUMP).contains(x,y)){
                        mJumpID = event.getPointerId(index);
                        mJumpPressed = true;
                    }
                    else if( buttons.get(HUD.ATTACK).contains(x,y)){
                        mAttackIndex = index;
                        mAttackID = event.getPointerId(mAttackIndex);
                        mAttackPressed = true;
                    }
                    else if( buttons.get(HUD.PAUSE).contains(x,y)){
                        mPauseIndex = index;
                        mPauseID = event.getPointerId(mPauseIndex);
                        mPausePressed = true;
                    }
                    break;


                case MotionEvent.ACTION_POINTER_DOWN:
                    if(buttons.get(HUD.LEFT).contains(x,y)){
                        mLeftIndex = index;
                        mLeftID = event.getPointerId(mLeftIndex);
                        mLeftPressed = true;
                    }
                    else if( buttons.get(HUD.RIGHT).contains(x,y)){
                        mRightIndex = index;
                        mRightID = event.getPointerId(mRightIndex);
                        mRightPressed = true;
                    }
                    else if( buttons.get(HUD.JUMP).contains(x,y)){
                        mJumpIndex = index;
                        mJumpID = event.getPointerId(mJumpIndex);
                        mJumpPressed = true;
                    }

                    else if( buttons.get(HUD.ATTACK).contains(x,y)){
                        mAttackIndex = index;
                        mAttackID = event.getPointerId(mAttackIndex);
                        mAttackPressed = true;
                    }

                    else if( buttons.get(HUD.PAUSE).contains(x,y)){
                        mPauseIndex = index;
                        mPauseID = event.getPointerId(mPauseIndex);
                        mPausePressed = true;
                    }
                    break;
            }
        }
    }
}
