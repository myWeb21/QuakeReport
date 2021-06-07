package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> a=new ArrayList();
        a.add(new Word("Father","papa",R.drawable.ic_launcher_background));
        a.add(new Word("Mother","mummy",R.drawable.ic_launcher_background));
        a.add(new Word("Brother","Bhai",R.drawable.ic_launcher_background));
        a.add(new Word("Sister","Bhen",R.drawable.ic_launcher_background));
        WordAdapter w=new WordAdapter(this,a);
        ListView l=(ListView)findViewById(R.id.list);
        l.setAdapter(w);




    }
}