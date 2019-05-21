package com.example.lstopo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;


public class Lstopo extends AppCompatActivity {

    public RelativeLayout linearLayout;
    public Activity activity;
    MyCanvas canvas;
    public float scale_height = 5;
    public float scale_width = 5;

    public Lstopo(Activity activity) {
        this.activity = activity;
        linearLayout = activity.findViewById(R.id.relative_layout);
    }

    public void box(int r, int b, int g, int x, int y, int width, int height){
        View view = new View(activity);
        linearLayout.addView(view);
        setBoxAttributes(view, r, b, g, x, y, width, height);
    }

    private void setBoxAttributes(View view, int r, int b, int g, int x, int y, int width, int height){
        width = (int) (width*scale_width);
        height = (int) (height*scale_height);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width, height);
        view.setY(y*scale_height);
        view.setX(x*scale_width);

        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadii(new float[] { 0, 0, 0, 0, 0, 0, 0, 0 });
        shape.setColor(Color.rgb(r, g, b));
        shape.setStroke(2, Color.parseColor("#000000"));
        view.setBackground(shape);

        view.setLayoutParams(params);
    }

    public void text(String text, int x, int y){
        TextView view = new TextView(activity);
        linearLayout.addView(view);
        setTextAttributes(view, text, x, y);
    }

    private void setTextAttributes(TextView view, String text, int x, int y){
        view.setText(text);
        view.setY(y*scale_height);
        view.setX(x*scale_width);
    }

    public void line(int x1, int y1, int x2, int y2){
        canvas = new MyCanvas(activity,x1,x2,y1,y2);
        linearLayout.addView(canvas);
    }

    private int convertDpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }
}
