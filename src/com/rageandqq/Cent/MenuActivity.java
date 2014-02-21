package com.rageandqq.Cent;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * @author Sameer Chitley
 * @version 1.0
 * Creates the Menu, and handles user action on the Buttons.
 */
public class MenuActivity extends Activity implements View.OnClickListener
{
    public static Typeface FONT_BOLD, FONT_REGULAR;

    /**
     * Creates the Menu.
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        //font initialization
        FONT_REGULAR = Typeface.createFromAsset(getAssets(), "fonts/Cardo-Regular.ttf");
        FONT_BOLD = Typeface.createFromAsset(getAssets(), "fonts/Cardo-Bold.ttf");

        //button assignment
        Button aboutButton, editButton, shareButton, receiveButton;
        aboutButton = (Button) findViewById(R.id.about_button);
        editButton = (Button) findViewById(R.id.edit_button);
        shareButton = (Button) findViewById(R.id.share_button);
        receiveButton = (Button) findViewById(R.id.receive_button);
        aboutButton.setTypeface(FONT_BOLD);
        editButton.setTypeface(FONT_BOLD);
        shareButton.setTypeface(FONT_BOLD);
        receiveButton.setTypeface(FONT_BOLD);
        aboutButton.setOnClickListener(this);
        editButton.setOnClickListener(this);
        shareButton.setOnClickListener(this);
        receiveButton.setOnClickListener(this);


    }

    /**
     * Executes the appropriate action depending on the button pressed.
     * @param v The view that the user clicked.
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.about_button) {
            Toast.makeText(getApplicationContext(), "About Button Pressed", Toast.LENGTH_SHORT).show();
        }

        if (v.getId() == R.id.edit_button) {
            Toast.makeText(getApplicationContext(), "Edit Button Pressed", Toast.LENGTH_SHORT).show();
        }

        if (v.getId() == R.id.share_button) {
            Toast.makeText(getApplicationContext(), "Share Button Pressed", Toast.LENGTH_SHORT).show();
        }

        if (v.getId() == R.id.receive_button) {
            Toast.makeText(getApplicationContext(), "Receive Button Pressed", Toast.LENGTH_SHORT).show();
        }
    }
}