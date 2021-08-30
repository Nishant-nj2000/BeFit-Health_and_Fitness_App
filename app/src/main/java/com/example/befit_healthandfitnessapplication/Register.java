package com.example.befit_healthandfitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    EditText email;
    EditText password;
    EditText cnfpassword;
    Button register;
    CheckBox show_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);


        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        cnfpassword = findViewById(R.id.cnfpassword);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(email.getText()) ||  TextUtils.isEmpty(password.getText()) || TextUtils.isEmpty(cnfpassword.getText()))
                {
                    if(TextUtils.isEmpty((email.getText())))
                    {
                        email.requestFocus();
                        email.setError("Email cannot be empty !");
                    }
                    else if(TextUtils.isEmpty((password.getText())))
                    {
                        password.requestFocus();
                        password.setError("Password cannot be empty !");
                    }
                    else
                    {
                        cnfpassword.requestFocus();
                        cnfpassword.setError("Confirm password cannot be empty !");
                    }
                }
                else
                {
                    String emailToText = email.getText().toString();
                    String passwordToText = password.getText().toString();
                    String cnfPasswordToText = cnfpassword.getText().toString();

                    if(!Patterns.EMAIL_ADDRESS.matcher(emailToText).matches())
                    {
                        email.requestFocus();
                        email.setError("Invalid Email !");
                    }
                    else if(!passwordToText.matches(cnfPasswordToText))
                    {
                        password.requestFocus();
                        password.setError("Passwords do not match");
                    }
                    else if(passwordToText.matches(cnfPasswordToText))
                    {
                         final Pattern PASSWORD_PATTERN =
                                Pattern.compile("^" +
                                        "(?=.*[@#$%^&+=])" +     // at least 1 special character
                                        "(?=\\S+$)" +            // no white spaces
                                        ".{8,}" +                // at least 8 characters
                                        "$");
                         if(!PASSWORD_PATTERN.matcher(passwordToText).matches())
                         {
                             password.requestFocus();
                             password.setError("Use 8 characters with a mix of letters, numbers & symbols");
                         }
                         else
                         {
                             Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                         }
                    }
                }
            }
        });
    }
}