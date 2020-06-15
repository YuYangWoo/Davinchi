package com.cookandroid.davin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     TextView start,tuto,exit;
     Button startbtn;
    MediaPlayer mediaPlayer ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.start);
        tuto=findViewById(R.id.tuto);
        exit=findViewById(R.id.exit);
        startbtn=findViewById(R.id.startbtn);
        mediaPlayer= MediaPlayer.create(this,R.raw.main_bgm);
      hidenavigate();


    }
public void hidenavigate()
{
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
    View decor_View = getWindow().getDecorView();
    int ui_Options = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_FULLSCREEN
            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    decor_View.setSystemUiVisibility(ui_Options);
}

    public void startbtnclick(View v)
    {

      if(mediaPlayer.isPlaying()==true){
          startbtn.setBackgroundResource(R.drawable.umx);
          mediaPlayer.pause();
      }
      else
      {
          startbtn.setBackgroundResource(R.drawable.umo);
          mediaPlayer.start();
      }
    }
public void onUserLeaveHint(){
        mediaPlayer.pause();
        super.onUserLeaveHint();
}
public void onResume(){
        mediaPlayer.start();
        super.onResume();
}
public void onDestroy(){
        mediaPlayer.stop();
        super.onDestroy();
}
public void onBackPressed(){
        mediaPlayer.stop();
        super.onBackPressed();
}
   public void startClick(View v)
    {
        Intent startintent = new Intent(getApplicationContext(),gameActivity.class);
        startActivity(startintent);
    }
    public void tutoClick(View v)
    {
     Intent tutointent = new Intent(getApplicationContext(),tuto_1.class);
     startActivity(tutointent);
    }
    public void exitClick(View v)
    {

        ActivityCompat.finishAffinity(MainActivity.this);
        System.exit(0);

    }
}
