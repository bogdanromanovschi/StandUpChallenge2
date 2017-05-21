package com.example.android.standupchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreFirstParticipant = 0;
    int scoreSecondParticipant = 0;
    static final String First_Score = "first_score";
    static final String Second_Score = "second_score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore value of members from saved state, variables and views
            scoreFirstParticipant = savedInstanceState.getInt(First_Score);
            displayParticipantOne(scoreFirstParticipant);
            scoreSecondParticipant = savedInstanceState.getInt(Second_Score);
            displayParticipantTwo(scoreSecondParticipant);
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(First_Score, scoreFirstParticipant);
        savedInstanceState.putInt(Second_Score, scoreSecondParticipant);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    /**  Adds one point to the first participants, for audience laughs */
    public void laughsFirstParticipant (View view) {
        scoreFirstParticipant = scoreFirstParticipant + 1;
        displayParticipantOne(scoreFirstParticipant);
    }
    /**  Adds three points to the first participants, for audience claps */
    public void clapsFirstParticipant (View view) {
        scoreFirstParticipant = scoreFirstParticipant + 3;
        displayParticipantOne(scoreFirstParticipant);
    }

    /**  Adds one point to the second participants, for audience laughs */
    public void laughsSecondParticipant (View view) {
        scoreSecondParticipant = scoreSecondParticipant + 1;
        displayParticipantTwo(scoreSecondParticipant);
    }
    /**  Adds three points to the second participants, for audience claps */
    public void clapsSecondParticipant (View view) {
        scoreSecondParticipant = scoreSecondParticipant + 3;
        displayParticipantTwo(scoreSecondParticipant);
    }
    /** Resets the score and starts a new challenge */
    public void resetScore (View view) {
        scoreFirstParticipant = 0;
        displayParticipantOne(scoreFirstParticipant);
        scoreSecondParticipant = 0;
        displayParticipantTwo(scoreSecondParticipant);
    }
    /**  Displays the score for the first participant. */
    public void displayParticipantOne(int score) {
        TextView scoreView = (TextView) findViewById(R.id.first_score);
        scoreView.setText(String.valueOf(score));
    }
    /**  Displays the score for the second participant. */
    public void displayParticipantTwo(int score) {
        TextView scoreView = (TextView) findViewById(R.id.second_score);
        scoreView.setText(String.valueOf(score));
    }
}
