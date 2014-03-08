package com.rageandqq.Cent;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sameer on 2/22/2014.
 */
public class FirstRunActivity extends Activity implements View.OnClickListener{
    public void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_run);

        Typeface FONT_REGULAR, FONT_BOLD;
        FONT_REGULAR = Typeface.createFromAsset(getAssets(), "fonts/Cardo-Regular.ttf");
        FONT_BOLD = Typeface.createFromAsset(getAssets(), "fonts/Cardo-Bold.ttf");
        Button yes = (Button)findViewById(R.id.yes_button), no = (Button)findViewById(R.id.no_button);
        TextView firstInfo = (TextView)findViewById(R.id.first_run_text);
        firstInfo.setTypeface(FONT_REGULAR);
        yes.setTypeface(FONT_BOLD);
        no.setTypeface(FONT_BOLD);

        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        /**
         * REMINDER: IMPLEMENT OVERRIDE "BACK BUTTON" freature. One of these options MUST be pressed!
         */
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.yes_button) { //change Intent to start EditActivity once created
            Intent i = new Intent (FirstRunActivity.this, EditActivity.class);
            i.putExtra("calledByFirst", true);
            startActivity(i);
            finish();
        }

        if (v.getId()==R.id.no_button) {
            Intent i = new Intent (FirstRunActivity.this, MenuActivity.class);
            startActivity(i);
            finish();
        }
    }
}