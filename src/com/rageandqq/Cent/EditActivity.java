package com.rageandqq.Cent;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.*;

/**
 * Created by sameer on 2/22/2014.
 */
public class EditActivity extends Activity implements View.OnClickListener{

    private EditText firstNameField, lastNameField, phoneNumberField, emailAddressField;

    public void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        ImageView userImage = (ImageView) findViewById(R.id.user);

        TextView firstName = (TextView) findViewById(R.id.first_name);
        TextView lastName = (TextView) findViewById(R.id.last_name);
        TextView phoneNumber = (TextView) findViewById(R.id.phone_number);
        TextView emailAddress = (TextView) findViewById(R.id.email_address);

        firstNameField = (EditText)findViewById(R.id.first_name_field);
        lastNameField = (EditText)findViewById(R.id.last_name_field);
        phoneNumberField = (EditText)findViewById(R.id.phone_number_field);
        emailAddressField = (EditText)findViewById(R.id.email_address_field);

        Button saveButton = (Button) findViewById(R.id.save_button);
        Button cancelButton = (Button) findViewById(R.id.cancel_button);


        firstName.setTypeface(MenuActivity.FONT_REGULAR);
        lastName.setTypeface(MenuActivity.FONT_REGULAR);
        phoneNumber.setTypeface(MenuActivity.FONT_REGULAR);
        emailAddress.setTypeface(MenuActivity.FONT_REGULAR);

        firstNameField.setTypeface(MenuActivity.FONT_REGULAR);
        lastNameField.setTypeface(MenuActivity.FONT_REGULAR);
        phoneNumberField.setTypeface(MenuActivity.FONT_REGULAR);
        emailAddressField.setTypeface(MenuActivity.FONT_REGULAR);

        saveButton.setTypeface(MenuActivity.FONT_BOLD);
        cancelButton.setTypeface(MenuActivity.FONT_BOLD);

        saveButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
        userImage.setOnClickListener(this);

        //--------

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String first = prefs.getString("first", null);
        String last = prefs.getString("last", null);
        String phone = prefs.getString("phone", null);
        String email = prefs.getString("email", null);

        if (! (first == null || first.equals (""))) {
            firstNameField.setText(first);
        }

        if (! (last == null || last.equals (""))) {
            lastNameField.setText(last);
        }

        if (! (phone == null || phone.equals (""))) {
            phoneNumberField.setText(phone);
        }

        if (! (email == null || email.equals (""))) {
            emailAddressField.setText(email);
        }

        //---------



    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.save_button) {
            if (isEmpty(firstNameField) && isEmpty(lastNameField)) { //error
                Toast.makeText(getApplicationContext(), "You must at least enter a name!", Toast.LENGTH_LONG).show();
                return;
            }

            SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();

            editor.putString("first", firstNameField.getText().toString().trim());
            editor.putString("last", lastNameField.getText().toString().trim());
            editor.putString("phone", phoneNumberField.getText().toString().trim());
            editor.putString("email", emailAddressField.getText().toString().trim());

            editor.commit();
            if (getIntent().getExtras().getBoolean("calledByFirst")) {
                Intent i = new Intent(EditActivity.this, MenuActivity.class);
                startActivity(i);
            }
            this.finish();
        }
        if (v.getId() == R.id.cancel_button) {
            if (getIntent().getExtras().getBoolean("calledByFirst")) {
                Intent i = new Intent(EditActivity.this, MenuActivity.class);
                startActivity(i);
            }
            this.finish();
        }

        if (v.getId() == R.id.user) {
            final CharSequence[] options = new CharSequence[] {"Use Image from Gallery", "Revert to Default Image"};

            AlertDialog.Builder builder = new  AlertDialog.Builder(this);
            builder.setTitle("Choose Image...");
            builder.setItems (options, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //options[0] or options[1]
                    Toast.makeText(getApplicationContext(), "Chose: " + options[which], Toast.LENGTH_LONG).show();
                }
            });
            builder.show();
        }
    }

    private boolean isEmpty (EditText t) {
        if (t.getText().toString() == null || t.getText().toString().trim().equals("")) {
            return true;
        }
        return false;
    }
}