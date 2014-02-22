package com.rageandqq.Cent;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.TextView;

/**
 * Splash Screen Activity
 * Displays Application name and Logo, and transitions to the Menu.
 * On the first launch, will ask the user if they want to setup their CENT.
 */
public class SplashActivity extends Activity {
    /**
     * Called when the Activity is created.
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        boolean firstRun = prefs.getBoolean("firstRun", true);
        Intent mainIntent;
        if (firstRun) {
            SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
            editor.putBoolean("firstRun", false);
            editor.commit();
            mainIntent = new Intent(SplashActivity.this, FirstRunActivity.class);
        }
        else {
            mainIntent = new Intent(SplashActivity.this, MenuActivity.class);
        }
        final Intent mainIntent2 = mainIntent;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashActivity.this.startActivity(mainIntent2);
                SplashActivity.this.finish();
                overridePendingTransition(R.anim.mainfadein, R.anim.splashfadeout);
            }
        }, 800);
    }
}
