package com.example.musicplayer1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer=MediaPlayer.create(this,R.raw.song);


        Button playButton=(Button)findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "play", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
            }
        });
        Button pauseButton=(Button)findViewById(R.id.pauseButton);
        playButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "pause", Toast.LENGTH_SHORT).show();
              mediaPlayer.stop();
            }
        });

    }
}