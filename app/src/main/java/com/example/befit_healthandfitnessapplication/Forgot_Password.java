package com.example.befit_healthandfitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class Forgot_Password extends AppCompatActivity {
    TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_forgot_password);

        textView1 = (TextView)findViewById(R.id.goback);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Forgot_Password.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}