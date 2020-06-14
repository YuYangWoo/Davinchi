package com.cookandroid.davin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class tuto_1 extends AppCompatActivity {
       static MediaPlayer startplayer;
    Button startbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tuto_1);
        Intent intent = new Intent(this,tuto_2.class);
        startplayer= MediaPlayer.create(this,R.raw.tuto_bgm);
        startbtn=findViewById(R.id.startbtn);
        View decor_View = getWindow().getDecorView();
        int ui_Options = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decor_View.setSystemUiVisibility(ui_Options);

    }

    public static void  stopBgm(){
     if(startplayer!=null)
         startplayer.stop();
    }


    public void startbtnclick(View v)
    {

        if(startplayer.isPlaying()==true){
            startbtn.setBackgroundResource(R.drawable.umx);
            startplayer.pause();
        }
        else
        {
            startbtn.setBackgroundResource(R.drawable.umo);
            startplayer.start();
        }
    }
    public void onResume(){
        startplayer.start();
        super.onResume();
    }






    public void onDestroy(){
        tuto_1.stopBgm();
        android.util.Log.i("액티비티 테스트","ondestroy()");
        super.onDestroy();
    }
    public void onBackPressed(){
        tuto_1.stopBgm();
        android.util.Log.i("액티비티 테스트","onbackpressed()");
        super.onBackPressed();
    }
    public void skipBtnclick(View v)
    {
        tuto_1.stopBgm();
        Intent mintent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(mintent);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        int action = event.getAction();
        if(action == MotionEvent.ACTION_DOWN){
            Intent intent = new Intent(getApplicationContext(),tuto_2.class);
            startActivity(intent);
        }
        return super.onTouchEvent(event);
    }
}
