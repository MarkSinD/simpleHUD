package com.gamecodeschool.testhud;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class GameEngine extends SurfaceView implements Runnable {
    private Thread mThread = null;
    public static long mFPS;
    private HUD mHUD;
    private Renderer mRenderer;
    private SoundEngine mSoundEngine;

    public GameEngine(Context context, Point size){
        super(context);
        mRenderer = new Renderer( this);
        mHUD = new HUD(size);
        mSoundEngine = new SoundEngine(context);
    }

    @Override
    public void run() {
        while(true) {
            Log.e("Run", " ");
            long frameStartTime = System.currentTimeMillis();

            mRenderer.draw(mHUD);

            long timeThisFrame = System.currentTimeMillis() - frameStartTime;

            if (timeThisFrame >= 1) {
                final int MILLIS_IN_SECOND = 1000;
                mFPS = MILLIS_IN_SECOND / timeThisFrame;
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        PlayerInputComponent.input(event,mHUD.getControls());
        return true;
    }

    public void stopThread(){
        try {
            mThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void startThread(){
        mThread = new Thread(this);
        mThread.start();
    }
}
