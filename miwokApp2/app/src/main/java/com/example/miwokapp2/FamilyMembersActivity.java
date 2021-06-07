package com.example.miwokapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {
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

        num.add(new word("father","apa",R.drawable.family_father,R.raw.family_father));
        num.add(new word("mother","ata",R.drawable.family_mother,R.raw.family_mother));
        num.add(new word("son","angsi",R.drawable.family_son,R.raw.family_son));
        num.add(new word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        num.add(new word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        num.add(new word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        num.add(new word("older sister","tete",R.drawable.family_older_sister,R.raw.family_older_sister));
        num.add(new word("younger sister","kollete",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        num.add(new word("grand mother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        num.add(new word("grand father","apa",R.drawable.family_grandfather,R.raw.family_grandfather));





        WordAdapter a=new WordAdapter(this,num,R.color.category_family);
        ListView l=(ListView)findViewById(R.id.list);
        l.setAdapter(a);
        l.setAdapter(a);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word wrd =num.get(position);
                releaseMediaPlayer();
                mediaPlayer=MediaPlayer.create(FamilyMembersActivity.this,wrd.getAudioResourceId());
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