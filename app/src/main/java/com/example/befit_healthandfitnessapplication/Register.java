package com.example.befit_healthandfitnessapplication;

import androidx.annotation.NonNull;
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
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    EditText txtemail,txtpassword,txtcnfpassword;
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
        txtemail = (EditText) findViewById(R.id.email);
        txtpassword = (EditText) findViewById(R.id.password);
        btn_register = (Button) findViewById(R.id.register);
        txtcnfpassword = (EditText) findViewById(R.id.cnfpassword);
        gender_grp = (RadioGroup) findViewById(R.id.gender);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

                if(TextUtils.isEmpty(txtemail.getText()) ||  TextUtils.isEmpty(txtpassword.getText()) || TextUtils.isEmpty(txtcnfpassword.getText()))
                {
                    if(TextUtils.isEmpty((txtemail.getText())))
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
                             long val = db.addUser(email,gender,password);
                             if(val>0)
                             {
                                 btn_register.setVisibility(View.INVISIBLE);
                                 progressBar.setVisibility(View.VISIBLE);
                                 Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                                 startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                 finish();
                             }
                             else
                             {
                                 btn_register.setVisibility(View.VISIBLE);
                                 progressBar.setVisibility(View.INVISIBLE);
                                 Toast.makeText(getApplicationContext(), "Something went wrong !", Toast.LENGTH_SHORT).show();
                             }
                         }
                    }
                }
            }
        });
    }
}