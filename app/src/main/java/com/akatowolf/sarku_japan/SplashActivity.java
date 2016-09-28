package com.akatowolf.sarku_japan;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private static final long SPLASH_DELAY = 5000;
    Timer timer;
    /*Timer timer;
    TimerTask task;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        timer = new Timer();
        TimerTask task = new TimerTask(){
            public void run(){

                    Intent i = new Intent().setClass(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();}


        };
        timer.schedule(task, SPLASH_DELAY);

    }

}
