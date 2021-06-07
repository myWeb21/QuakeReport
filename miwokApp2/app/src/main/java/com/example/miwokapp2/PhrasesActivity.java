package com.example.miwokapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
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

        num.add(new word("where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        num.add(new word("what is your name","tinna oyaasina",R.raw.phrase_what_is_your_name));
        num.add(new word("my name is","oyyasit",R.raw.phrase_my_name_is));
        num.add(new word("how are you feeling","michaksas",R.raw.phrase_how_are_you_feeling));
        num.add(new word("i'm feeling good","kuchi achit",R.raw.phrase_im_feeling_good));
        num.add(new word("are you coming","aanas'aa",R.raw.phrase_are_you_coming));
        num.add(new word("yes , i'am coming","haa'aanam",R.raw.phrase_yes_im_coming));
        num.add(new word("i'm coming","aanam",R.raw.phrase_im_coming));





        WordAdapter a=new WordAdapter(this,num,R.color.category_phrases);
        ListView l=(ListView)findViewById(R.id.list);
        l.setAdapter(a);
        l.setAdapter(a);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word wrd =num.get(position);
                releaseMediaPlayer();
                mediaPlayer=MediaPlayer.create(PhrasesActivity.this,wrd.getAudioResourceId());
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