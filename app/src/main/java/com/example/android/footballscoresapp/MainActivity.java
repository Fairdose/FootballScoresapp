package com.example.android.footballscoresapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int teamAScore = 0;
    int teamAFoul = 0;
    int teamBScore = 0;
    int teamBFoul = 0;

    public void updateScoreA (int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void updateScoreB (int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void updateFoulA (String foul) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_foul_text);
        scoreView.setText(String.valueOf(foul));
    }

    public void updateFoulB (String foul) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_foul_text);
        scoreView.setText(String.valueOf(foul));
    }

    public void resetGame (View view) {
        teamAScore = teamAFoul = teamBScore = teamBFoul = 0;

        TextView scoreView1 = (TextView) findViewById(R.id.team_a_score);
        scoreView1.setText(String.valueOf(0));

        TextView scoreView2 = (TextView) findViewById(R.id.team_b_score);
        scoreView2.setText(String.valueOf(0));

        TextView scoreView3 = (TextView) findViewById(R.id.team_a_foul_text);
        scoreView3.setText(String.valueOf("Fouls : 0"));

        TextView scoreView4 = (TextView) findViewById(R.id.team_b_foul_text);
        scoreView4.setText(String.valueOf("Fouls : 0"));
    }

    public void teamAGoal (View view) {
        teamAScore = teamAScore + 1;
        updateScoreA(teamAScore);
    }

    public void teamBGoal (View view) {
        teamBScore = teamBScore + 1;
        updateScoreB(teamBScore);
    }

    public void teamAFoul (View view) {
        teamAFoul = teamAFoul + 1;
        updateFoulA("Fouls : " + teamAFoul);
    }

    public void teamBFoul (View view) {
        teamBFoul = teamBFoul + 1;
        updateFoulB("Fouls : " + teamBFoul);
    }


}
