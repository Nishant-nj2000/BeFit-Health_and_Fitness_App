package com.example.befit_healthandfitnessapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    EditText txtfullname,txtemail,txtpassword,txtcnfpassword;
    Button btn_register;
    RadioGroup gender_grp;
    RadioButton gender_radio;
    ProgressBar progressBar;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);

        db = new DBHelper(this);
        txtfullname = (EditText) findViewById(R.id.fullname);
        txtemail = (EditText) findViewById(R.id.email);
        txtpassword = (EditText) findViewById(R.id.password);
        btn_register = (Button) findViewById(R.id.register);
        txtcnfpassword = (EditText) findViewById(R.id.cnfpassword);
        gender_grp = (RadioGroup) findViewById(R.id.gender);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullname = txtfullname.getText().toString();
                String email = txtemail.getText().toString();
                String password = txtpassword.getText().toString();
                String cnfPassword = txtcnfpassword.getText().toString();

                int selectedId = gender_grp.getCheckedRadioButtonId();
                if(selectedId == -1)
                {
                    Toast.makeText(getApplicationContext(), "Please Select Gender !", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    gender_radio = (RadioButton) findViewById(selectedId);
                }
                String gender = gender_radio.getText().toString();

                if(TextUtils.isEmpty(txtfullname.getText()) || TextUtils.isEmpty(txtemail.getText()) ||  TextUtils.isEmpty(txtpassword.getText()) || TextUtils.isEmpty(txtcnfpassword.getText()))
                {
                    if(TextUtils.isEmpty((txtfullname.getText())))
                    {
                        txtfullname.requestFocus();
                        txtfullname.setError("Full Name cannot be empty !");
                    }
                    else if(TextUtils.isEmpty((txtemail.getText())))
                    {
                        txtemail.requestFocus();
                        txtemail.setError("Email cannot be empty !");
                    }
                    else if(TextUtils.isEmpty((txtpassword.getText())))
                    {
                        txtpassword.requestFocus();
                        txtpassword.setError("Password cannot be empty !");
                    }
                    else
                    {
                        txtcnfpassword.requestFocus();
                        txtcnfpassword.setError("Confirm password cannot be empty !");
                    }
                }
                else
                {

                    if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                    {
                        txtemail.requestFocus();
                        txtemail.setError("Invalid Email !");
                    }
                    else if(!password.matches(cnfPassword))
                    {
                        txtcnfpassword.requestFocus();
                        txtcnfpassword.setError("Passwords do not match");
                    }
                    else if(password.matches(cnfPassword))
                    {
                         final Pattern PASSWORD_PATTERN =
                                Pattern.compile("^" +
                                        "(?=.*[@#$%^&+=])" +     // at least 1 special character
                                        "(?=\\S+$)" +            // no white spaces
                                        ".{8,}" +                // at least 8 characters
                                        "$");
                         if(!PASSWORD_PATTERN.matcher(password).matches())
                         {
                             txtpassword.requestFocus();
                             txtpassword.setError("Use 8 characters with a mix of letters, numbers & symbols");
                         }
                         else
                         {
                             long val = db.addUser(fullname,email,gender,password);
                             if(val>0)
                             {
                                 btn_register.setVisibility(View.INVISIBLE);
                                 progressBar.setVisibility(View.VISIBLE);
                                 progressBar.setSecondaryProgress(100);
                                 progressBar.setProgress(10);
                                 progressBar.setMax(100);
                                 SharedPreferences.Editor editor = getSharedPreferences("user", MODE_PRIVATE).edit();
                                 editor.putString("fullname", fullname);
                                 editor.apply();
                                 Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                                 startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                 finish();
                             }
                             else
                             {
                                 btn_register.setVisibility(View.VISIBLE);
                                 progressBar.setVisibility(View.INVISIBLE);
                                 Toast.makeText(getApplicationContext(), "Something went wrong !", Toast.LENGTH_LONG).show();
                             }
                         }
                    }
                }
            }
        });
    }
}