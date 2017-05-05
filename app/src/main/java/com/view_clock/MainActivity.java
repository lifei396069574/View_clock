package com.view_clock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.view_clock.view.ClockView;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity implements  View.OnTouchListener {

    private ClockView clockView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("zzz","Math.cos(angle*Math.PI/180) " + Math.cos(30*Math.PI/180));
        initView();
    }

    private void initView() {
        clockView = (ClockView) findViewById(R.id.clockView);

        clockView.setOnTouchListener(this);

    }
    public static String StringData(){
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        if("1".equals(mWay)){
            mWay ="天";
        }else if("2".equals(mWay)){
            mWay ="一";
        }else if("3".equals(mWay)){
            mWay ="二";
        }else if("4".equals(mWay)){
            mWay ="三";
        }else if("5".equals(mWay)){
            mWay ="四";
        }else if("6".equals(mWay)){
            mWay ="五";
        }else if("7".equals(mWay)){
            mWay ="六";
        }
        return "星期"+mWay;
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                if (x > 130 && y > 180 && x < 250  && y < 250) {
                    Toast.makeText(MainActivity.this,"点击了",Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return true;

    }
}
