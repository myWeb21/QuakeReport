package com.example.prac3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  int ascore=0,bscore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //displayForTeamA(8);
    }
    public void submitOrder3a(View view)
    {

            displayForTeamA(ascore+3);
            ascore=ascore+3;

    }

        /**
         * Displays the given score for Team A.
         */
        public void displayForTeamA(int score) {
            TextView scoreView = (TextView) findViewById(R.id.team_a_score);
            scoreView.setText(String.valueOf(score));
        }


    public void submitOrder2a(View view) {
            displayForTeamA(ascore+2);
            ascore=ascore+2;
    }

    public void submitOrder1a(View view) {
            displayForTeamA(ascore+1);
            ascore=ascore+1;
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void submitOrder3b(View view) {
        displayForTeamB(bscore+3);
        bscore=bscore+3;
    }

    public void submitOrder2b(View view) {
        displayForTeamB(bscore+2);
        bscore=bscore+2;
    }

    public void submitOrder1b(View view) {
        displayForTeamB(bscore+1);
        bscore=bscore+1;
    }

    public void reset(View view) {
        ascore=0;
        bscore=0;
        displayForTeamA(0);
        displayForTeamB(0);
    }
}