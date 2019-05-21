package com.example.lstopo;


import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("lib");
    }

    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    GestureDetector gestureDetector;
    private RelativeLayout linearLayout;

    Lstopo lstopo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.relative_layout);
        mScaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());
        lstopo = new Lstopo(this);

        draw(lstopo);

        /*final Button button1 = new Button(this);
        final Button button2 = new Button(this);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                400,
                200
        );

        button1.setText("Text output");
        button1.setX(0);
        button1.setLayoutParams(params);

        button2.setText("Designed output");
        button2.setX(screen_width - 400);
        button2.setLayoutParams(params);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                linearLayout.removeView(button2);
                linearLayout.removeView(view);
                text(lstopo);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                linearLayout.removeView(button1);
                linearLayout.removeView(view);
                test(lstopo);
            }
        });

        linearLayout.addView(button1);
        linearLayout.addView(button2);
        */
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        mScaleGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector){
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f,
                    Math.min(mScaleFactor, 10.0f));
            linearLayout.setScaleX(mScaleFactor);
            linearLayout.setScaleY(mScaleFactor);
            return true;
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native void draw(Lstopo lstopo);
    public native void text(Lstopo lstopo);
}
