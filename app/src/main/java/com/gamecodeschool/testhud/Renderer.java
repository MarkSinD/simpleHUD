package com.gamecodeschool.testhud;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Renderer {
    private Canvas mCanvas;
    private SurfaceHolder mSurfaceHolder;
    private Paint mPaint;

    Renderer(SurfaceView sh){
        mSurfaceHolder = sh.getHolder();
        mPaint = new Paint();
    }

    void draw( HUD hud){
        if( mSurfaceHolder.getSurface().isValid()){
            mCanvas = mSurfaceHolder.lockCanvas();

            // Установка фона
            mCanvas.drawColor(Color.argb(255, 180, 55, 55));
            mPaint.setTextSize(100);
            mCanvas.drawText("IndexUP = " + PlayerInputComponent.mUpIndex, 800, 400, mPaint);

            mCanvas.drawText("LeftInd = " + PlayerInputComponent.mLeftIndex, 800, 600, mPaint);
            mCanvas.drawText("LeftID = " + PlayerInputComponent.mLeftID, 1400, 600, mPaint);
            mCanvas.drawText("LeftPr = " + PlayerInputComponent.mLeftPressed, 2000, 600, mPaint);

            mCanvas.drawText("RightInd = " + PlayerInputComponent.mRightIndex, 800, 750, mPaint);
            mCanvas.drawText("RightID = " + PlayerInputComponent.mRightID, 1400, 750, mPaint);
            mCanvas.drawText("RightPr = " + PlayerInputComponent.mRightPressed, 2000, 750, mPaint);

            mCanvas.drawText("AttackInd = " + PlayerInputComponent.mAttackIndex, 800, 900, mPaint);
            mCanvas.drawText("AttackID = " + PlayerInputComponent.mAttackID, 1400, 900, mPaint);
            mCanvas.drawText("AttackPr = " + PlayerInputComponent.mAttackPressed, 2000, 900, mPaint);

            mCanvas.drawText("JumpInd = " + PlayerInputComponent.mJumpIndex, 800, 1050, mPaint);
            mCanvas.drawText("JumpID = " + PlayerInputComponent.mJumpID, 1400, 1050, mPaint);
            mCanvas.drawText("JumpPr = " + PlayerInputComponent.mJumpPressed, 2000, 1050, mPaint);

            mCanvas.drawText("PauseInd = " + PlayerInputComponent.mPauseIndex, 800, 1200, mPaint);
            mCanvas.drawText("PauseID = " + PlayerInputComponent.mPauseID, 1400, 1200, mPaint);
            mCanvas.drawText("PausePr = " + PlayerInputComponent.mPausePressed, 2000, 1200, mPaint);


            // Прорисовка кнопок
            hud.draw(mCanvas, mPaint);

            mSurfaceHolder.unlockCanvasAndPost(mCanvas);
        }
    }

}
