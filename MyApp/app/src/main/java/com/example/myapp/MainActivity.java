package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// ------------------------To Open Numbers Activity--------------------------------------

        TextView numbers = (TextView) findViewById(R.id.category_number);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Number", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(v.getContext(), NumberActivity.class);
                startActivity(i);

            }
        });
// ------------------- TO OPEN FAMILY ACTIVITY------------------------------------------
        TextView family=(TextView)findViewById(R.id.Family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Family", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(v.getContext(),FamilyActivity.class);
                startActivity(i);


            }
        });
//  -------------------------------------------------------------------------------
    }




}