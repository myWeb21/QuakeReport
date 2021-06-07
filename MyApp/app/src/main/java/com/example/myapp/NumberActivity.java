package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> a=new ArrayList<>();
        a.add(new Word("One","ek",R.drawable.ic_launcher_foreground));
        a.add(new Word("Two","doo",R.drawable.ic_launcher_foreground));
        a.add(new Word("Three","teen",R.drawable.ic_launcher_foreground));
        a.add(new Word("Four","chaar",R.drawable.ic_launcher_foreground));
        a.add(new Word("five","paanch",R.drawable.ic_launcher_foreground));

     WordAdapter w=new WordAdapter(this,a);
        ListView l=(ListView)findViewById(R.id.list);
        l.setAdapter(w);







    }
}