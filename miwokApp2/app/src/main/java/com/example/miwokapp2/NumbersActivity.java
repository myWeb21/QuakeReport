package com.example.miwokapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
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

        num.add(new word("one","lutti",R.drawable.number_one,R.raw.number_one));
        num.add(new word("two","otiiko",R.drawable.number_two,R.raw.number_two));
        num.add(new word("three","tolookasu",R.drawable.number_three,R.raw.number_three));
        num.add(new word("four","oyyisa",R.drawable.number_four,R.raw.number_four));
        num.add(new word("five","massoka",R.drawable.number_five,R.raw.number_five));
        num.add(new word("six","temamokka",R.drawable.number_six,R.raw.number_six));
        num.add(new word("seven","kenekaku",R.drawable.number_seven,R.raw.number_seven));
        num.add(new word("eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
        num.add(new word("nine","wo'e",R.drawable.number_nine,R.raw.number_nine));
        num.add(new word("ten","na'aacha",R.drawable.number_ten,R.raw.number_ten));





       WordAdapter a=new WordAdapter(this,num,R.color.category_numbers);
        ListView l=(ListView)findViewById(R.id.list);
        l.setAdapter(a);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word wrd =num.get(position);
                releaseMediaPlayer();
                 mediaPlayer=MediaPlayer.create(NumbersActivity.this,wrd.getAudioResourceId());
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