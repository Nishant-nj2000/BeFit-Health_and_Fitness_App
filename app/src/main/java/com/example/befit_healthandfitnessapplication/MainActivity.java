package com.example.befit_healthandfitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;

    EditText email;
    EditText password;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//hide title bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        textView1 = (TextView)findViewById(R.id.register);
        textView2 = (TextView)findViewById(R.id.forgotPassword);

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

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(email.getText()) ||  TextUtils.isEmpty(password.getText()))
                {
                    if(TextUtils.isEmpty((email.getText())))
                    {
                        email.requestFocus();
                        email.setError("Email cannot be empty !");
                    }
                    else
                    {
                        password.requestFocus();
                        password.setError("Password cannot be empty !");
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}