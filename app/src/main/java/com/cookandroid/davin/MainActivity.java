package com.cookandroid.davin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     TextView start,tuto,exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.start);
        tuto=findViewById(R.id.tuto);
        exit=findViewById(R.id.exit);
    }
   public void startClick(View v)
    {
        Intent startintent = new Intent(getApplicationContext(),StartActivity.class);
        startActivity(startintent);
    }
    public void tutoClick(View v)
    {

    }
    public void exitClick(View v)
    {
        finish();
    }
}
