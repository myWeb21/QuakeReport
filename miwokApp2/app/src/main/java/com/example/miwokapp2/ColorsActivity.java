package com.example.miwokapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);


        final ArrayList<word> num=new ArrayList<>();
        // num.add("one");

        num.add(new word("red","wetetti",R.drawable.color_red,R.raw.color_red));
        num.add(new word("mustard Yellow","chiwiita",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        num.add(new word("dusty yellow","topiisa",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        num.add(new word("green","chokokki",R.drawable.color_green,R.raw.color_green));
        num.add(new word("brown","temamokka",R.drawable.color_brown,R.raw.color_brown));
        num.add(new word("gray","takaakki",R.drawable.color_gray,R.raw.color_gray));
        num.add(new word("black","topoppi",R.drawable.color_black,R.raw.color_black));
        num.add(new word("white","kululli",R.drawable.color_white,R.raw.color_white));





        WordAdapter a=new WordAdapter(this,num,R.color.category_colors);
        ListView l=(ListView)findViewById(R.id.list);
        l.setAdapter(a);l.setAdapter(a);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word wrd =num.get(position);
                releaseMediaPlayer();
                mediaPlayer=MediaPlayer.create(ColorsActivity.this,wrd.getAudioResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });




    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    private void releaseMediaPlayer()
    {
        if(mediaPlayer!=null)
        {
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
}