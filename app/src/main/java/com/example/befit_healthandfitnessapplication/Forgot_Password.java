package com.example.befit_healthandfitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Forgot_Password extends AppCompatActivity {
    EditText email;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_forgot_password);

        email = findViewById(R.id.email);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(email.getText()))
                {
                    email.requestFocus();
                    email.setError("Email cannot be empty !");
                }
                else
                {
                    String emailToText = email.getText().toString();
                    if(!Patterns.EMAIL_ADDRESS.matcher(emailToText).matches())
                    {
                        email.requestFocus();
                        email.setError("Invalid Email !");
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}