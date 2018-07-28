package com.example.android.footballscoresapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    int teamAScore;
    int teamAFoul;
    int teamBScore;
    int teamBFoul;

    TextView scoreView1;
    TextView scoreView2;
    TextView scoreView3;
    TextView scoreView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        scoreView1 = (TextView) findViewById(R.id.team_a_score);
        scoreView2 = (TextView) findViewById(R.id.team_b_score);
        scoreView3 = (TextView) findViewById(R.id.team_a_foul_text);
        scoreView4 = (TextView) findViewById(R.id.team_b_foul_text);

        if (savedInstanceState != null){

            ArrayList<Integer> statA = savedInstanceState.getIntegerArrayList("TeamAStats");
            ArrayList<Integer> statB = savedInstanceState.getIntegerArrayList("TeamBStats");

            scoreView1.setText(String.valueOf(statA.get(0)));
            scoreView2.setText(String.valueOf(statB.get(0)));
            scoreView3.setText(String.valueOf("Fouls : " + statA.get(1)));
            scoreView4.setText(String.valueOf("Fouls : " + statB.get(1)));

            Log.i("Saved i", "Not null");
        } else {
            Log.i("Save i", "Null");
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        ArrayList<Integer> statA = savedInstanceState.getIntegerArrayList("TeamAStats");
        ArrayList<Integer> statB = savedInstanceState.getIntegerArrayList("TeamBStats");

        teamAScore = statA.get(0);
        teamBScore = statB.get(0);
        teamAFoul = statA.get(1);
        teamBFoul = statB.get(1);

        scoreView1.setText(String.valueOf(statA.get(0)));
        scoreView2.setText(String.valueOf(statB.get(0)));
        scoreView3.setText(String.valueOf("Fouls : " + statA.get(1)));
        scoreView4.setText(String.valueOf("Fouls : " + statB.get(1)));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        ArrayList<Integer> teamAStats = new ArrayList<Integer>(Arrays.asList(teamAScore,teamAFoul));
        ArrayList<Integer> teamBStats = new ArrayList<Integer>(Arrays.asList(teamBScore,teamBFoul));
        outState.putIntegerArrayList("TeamAStats",  teamAStats);
        outState.putIntegerArrayList("TeamBStats",  teamBStats);

        super.onSaveInstanceState(outState);
    }

    public void updateScoreA (int score) {
        scoreView1.setText(String.valueOf(score));
    }

    public void updateScoreB (int score) {
        scoreView2.setText(String.valueOf(score));
    }

    public void updateFoulA (String foul) {
        scoreView3.setText(String.valueOf(foul));
    }

    public void updateFoulB (String foul) {
        scoreView4.setText(String.valueOf(foul));
    }

    public void resetGame (View view) {
        teamAScore = teamAFoul = teamBScore = teamBFoul = 0;
        scoreView1.setText(String.valueOf(0));
        scoreView2.setText(String.valueOf(0));
        scoreView3.setText(String.valueOf("Fouls : 0"));
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

