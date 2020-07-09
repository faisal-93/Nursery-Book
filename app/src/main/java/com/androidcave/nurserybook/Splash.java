package com.androidcave.nurserybook;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * A login screen that offers login via email/password.
 */
public class Splash extends Activity  {
    private Context mContext;
    private final int SPLASH_DISPLAY_LENGHT = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mContext = this;


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
				/* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(mContext, MainApp.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }

    }




