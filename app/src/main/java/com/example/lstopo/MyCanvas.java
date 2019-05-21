package com.example.lstopo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyCanvas extends View {

    Paint paint;
    int x1;
    int x2;
    int y1;
    int y2;

    public MyCanvas(Context context, int x1, int x2, int y1, int y2){
        super(context);
        paint = new Paint();
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);
        canvas.drawLine(x1,y1,x2,y2, paint);
    }
}
