package com.example.felipe.spotifystreamer_stageone.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.felipe.spotifystreamer_stageone.R;

public class SplashScreen extends Activity {

    //Splash Screen timer - how long it will be displayed
    private static int INTERVAL = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //The handler will only call the method "run()" after the set interval
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, INTERVAL);
    }

}
