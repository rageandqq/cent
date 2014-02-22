package com.rageandqq.Cent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Sameer Chitley
 * @version 1.0
 * Creates the About view with basic information about the app and its author.
 */
public class AboutActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        //Will add animations in later
        //overridePendingTransition(R.anim.righttoleft,R.anim.lefttoright);
        Button back = (Button) findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView about = (TextView)findViewById(R.id.about), author = (TextView)findViewById(R.id.author);
        about.setTypeface(MenuActivity.FONT_REGULAR);
        author.setTypeface(MenuActivity.FONT_REGULAR);
        back.setTypeface(MenuActivity.FONT_BOLD);
    }
}