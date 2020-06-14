package com.cookandroid.davin;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity  {
    MediaPlayer startplayer ;
    Button startbtn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        startbtn=findViewById(R.id.startbtn);
        startplayer= MediaPlayer.create(this,R.raw.game_bgm);
       hidenavigate();

    }
    /*
    ** 네비게이션 숨기기
     */
    public void hidenavigate()
    {
        View decor_View = getWindow().getDecorView();
        int ui_Options = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decor_View.setSystemUiVisibility(ui_Options);

    }
    /*
    ** 사운드 넣기.
     */
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
    public void onUserLeaveHint(){
        startplayer.pause();
        super.onUserLeaveHint();
    }

    public void onDestroy(){
        startplayer.stop();
        super.onDestroy();
    }
    public void onBackPressed(){
        startplayer.stop();
        super.onBackPressed();
    }
    public void onResume(){
        startplayer.start();
        super.onResume();
    }
}
