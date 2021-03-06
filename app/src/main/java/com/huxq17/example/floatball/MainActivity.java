package com.huxq17.example.floatball;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

public class MainActivity extends Activity {
    private FloatBall mFloatBall;

    public void changeOrientation(View v) {
        if (Utils.isScreenOriatationPortrait(this)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatBallMenu menu = new FloatBallMenu();
        mFloatBall = new FloatBall(getApplicationContext(), menu);
//        mFloatBall = (FloatBall) LayoutInflater.from(this).inflate(R.layout.float_layout, null);
        mFloatBall.setLayoutGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
    }

    @Override
    protected void onStart() {
        super.onStart();
        show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        dismiss();
    }


    private void show() {
        mFloatBall.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismiss();
    }

    private void dismiss() {
        mFloatBall.dismiss();
    }

}
