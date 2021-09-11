package com.example.befit_healthandfitnessapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    EditText txtemail, txtpassword;
    Button btn_login;
    ProgressBar progressBar;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//hide title bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        db = new DBHelper(this);
        textView1 = (TextView)findViewById(R.id.register);
        textView2 = (TextView)findViewById(R.id.forgotPassword);
        txtemail = (EditText) findViewById(R.id.email);
        txtpassword = (EditText) findViewById(R.id.password);
        btn_login = (Button) findViewById(R.id.login);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Register.class);
                startActivity(intent);
                finish();
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Forgot_Password.class);
                startActivity(intent);
            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = txtemail.getText().toString();
                String password = txtpassword.getText().toString();

                if(TextUtils.isEmpty(txtemail.getText()) ||  TextUtils.isEmpty(txtpassword.getText()))
                {
                    if(TextUtils.isEmpty((txtemail.getText())))
                    {
                        txtemail.requestFocus();
                        txtpassword.setError("Email cannot be empty !");
                    }
                    else
                    {
                        txtpassword.requestFocus();
                        txtpassword.setError("Password cannot be empty !");
                    }
                }
                else
                {
                    if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                    {
                        txtemail.requestFocus();
                        txtemail.setError("Invalid Email !");
                    }
                    else
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
                            Boolean res = db.checkUser(email,password);
                            if(res == true)
                            {
                                btn_login.setVisibility(View.INVISIBLE);
                                progressBar.setVisibility(View.VISIBLE);
                                Toast.makeText(MainActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), Dashboard_User.class));
                                finish();
                            }
                            else
                            {
                                btn_login.setVisibility(View.VISIBLE);
                                progressBar.setVisibility(View.INVISIBLE);
                                Toast.makeText(MainActivity.this, "Incorrect Email id or Password !", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }


        });
    }
}