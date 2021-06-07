package com.example.miwokapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        TextView numbers = (TextView)findViewById(R.id.numbers);

        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent (v.getContext(),NumbersActivity.class);
                startActivity(i);

            }
        });

        TextView Family= (TextView)findViewById(R.id.family);
        Family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent (v.getContext(),FamilyMembersActivity.class);
                startActivity(i);

            }
        });

        TextView colors =(TextView)findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent i=new Intent (v.getContext(),ColorsActivity.class);
                startActivity(i);

            }
        });

        TextView phrases=(TextView)findViewById(R.id.phrases);
        phrases.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(v.getContext(),PhrasesActivity.class);
                startActivity(i);
            }
        });

    }









    
}
