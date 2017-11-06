package com.example.chaman.htoh;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent homeIntent = new Intent(SplashScreen.this, LogIn.class);
                Intent homeIntent = new Intent(MainActivity.this, NewsLive.class);
                startActivity(homeIntent);
                finish();

            }
        }, SPLASH_TIME_OUT);


    }
}
