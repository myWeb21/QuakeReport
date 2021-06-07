package com.example.practicehj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int pointa=0,pointb=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void point1a(View view) {
        pointa+=1;
        displayA(pointa);
    }
    public void point2a(View view) {
        pointa+=2;
        displayA(pointa);
    }
    public void point3a(View view) {
        pointa+=3;
        displayA(pointa);
    }
    public void point1b(View view) {
        pointb+=1;
        displayB(pointb);
    }
    public void point2b(View view) {
        pointb+=2;
        displayB(pointb);
    }
    public void point3b(View view) {
        pointb+=3;
        displayB(pointb);
    }




    public void displayA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void displayB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void reset(View view)
    {
        pointa=0;
        pointb=0;
        displayA(pointa);
        displayB(pointb);
    }


}