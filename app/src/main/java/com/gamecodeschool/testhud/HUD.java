package com.gamecodeschool.testhud;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.ArrayList;

public class HUD {
    private int mScreenHeight;
    private int mScreenWidth;

    // Массив прямоугольников ( Кнопок )
    // Задание. Составить массив окружностей. Переделать!
    private ArrayList<Rect> mControls;

    static int LEFT = 0;
    static int RIGHT = 1;
    static int JUMP = 2;
    static int ATTACK = 3;
    static int PAUSE = 4;

    HUD( Point sizeScreen ){
        mScreenHeight = sizeScreen.y;
        mScreenWidth = sizeScreen.x;
        prepareControls();
    }

    // Этот метод вызывается в Renderer
    void draw(Canvas canvas, Paint paint){
        drawControls(canvas,paint);
    }

    private void prepareControls(){

        // Это отступы
        int buttonWidth = mScreenWidth / 10;
        int buttonHeight = mScreenHeight / 9;
        int buttonPadding = mScreenWidth / 90;

        // Задаешь верний левый угол и правый нижий в формате ( X, Y ) координат
        Rect pause = new Rect(mScreenWidth - buttonPadding - buttonWidth, buttonPadding, mScreenWidth - buttonPadding, buttonPadding + buttonHeight);
        Rect left = new Rect(buttonPadding, mScreenHeight - buttonHeight - buttonPadding, buttonWidth + buttonPadding, mScreenHeight - buttonPadding);
        Rect right = new Rect((buttonPadding * 2) + buttonWidth, mScreenHeight - buttonHeight - buttonPadding, (buttonPadding * 2) + (buttonWidth * 2), mScreenHeight - buttonPadding);
        Rect jump = new Rect(mScreenWidth - buttonPadding - buttonWidth, mScreenHeight - buttonHeight - buttonPadding, mScreenWidth - buttonPadding, mScreenHeight - buttonPadding);
        Rect attack = new Rect(mScreenWidth - buttonPadding - buttonWidth, mScreenHeight-2*buttonPadding - 2*buttonHeight, mScreenWidth - buttonPadding, mScreenHeight - 2*buttonPadding - buttonHeight);

        // Дабаление в массив, содержащий "кнопки". Так легче держать все кнопки в одном месте.
        mControls = new ArrayList<>();
        mControls.add(LEFT,left);
        mControls.add(RIGHT,right);
        mControls.add(JUMP, jump);
        mControls.add(ATTACK, attack);
        mControls.add(PAUSE, pause);
    }

    private void drawControls(Canvas canvas, Paint p){
        // Установка цвета кнопок
        // Задание. Установить зеленый цвет
        p.setColor(Color.argb(100, 255,255, 255));

        // Прорисовка всех кнопок.
        for( Rect r : mControls)
            canvas.drawRect(r.left, r.top, r.right, r.bottom, p);

        p.setColor( Color.argb(255, 255, 255, 255));
    }

    // Вернуть массив при вызове
    ArrayList<Rect> getControls(){
        return mControls;
    }
}
