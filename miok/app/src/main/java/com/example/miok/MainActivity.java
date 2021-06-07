package com.example.miok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberClickListener onClick=new numberClickListener();

        TextView numbers=(TextView) findViewById(R.id.textView);

        numbers.setOnClickListener(onClick);

    }


}