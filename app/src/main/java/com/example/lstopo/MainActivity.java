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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("lib");
    }

    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private Spinner spinner;
    private RelativeLayout linearLayout;
    private String selectedItem = "";
    private Activity activity = this;


    Lstopo lstopo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.relative_layout);
        mScaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());
        addListenerOnSpinnerItemSelection();
        lstopo = new Lstopo(this);

        draw(lstopo);
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

    public void addListenerOnSpinnerItemSelection() {
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    private class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            if ( selectedItem == "Draw"){
                linearLayout.removeAllViews();
                text(lstopo);
                selectedItem = "Text";
            }

            else if(selectedItem == "Text"){
                linearLayout.removeAllViews();
                draw(lstopo);
                selectedItem = "Draw";
            }

            else
                selectedItem = "Draw";
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }

    }

    public native void draw(Lstopo lstopo);
    public native void text(Lstopo lstopo);
}
