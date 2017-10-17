package com.example.luismontes.anagramgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class ScoresActivity extends AppCompatActivity {
    // Reference important XML elements
    private Button goBackFromScores;
    private TextView secondsLeftDisplay;
    private TextView answersCorrectDisplay;
    private TextView finalScoreDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        goBackFromScores = (Button) findViewById(R.id.goBackFromScores);

        secondsLeftDisplay = (TextView) findViewById(R.id.secondsLeftDisplay);
        answersCorrectDisplay = (TextView) findViewById(R.id.answersCorrectDisplay);
        finalScoreDisplay = (TextView) findViewById(R.id.finalScoreDisplay);


        goBackFromScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMenu();
            }
        });

        // Pull the values sent from EasyActivity or HardActivity that are the ending game state
        Bundle b = getIntent().getExtras();
        int secondsLeft = b.getInt("secondsLeft");
        int answersCorrect = b.getInt("answersCorrect");
        int finalScore = calculateFinalScore(secondsLeft, answersCorrect);

        // Show the ending game state in the XML elements
        secondsLeftDisplay.append(" " + Integer.toString(secondsLeft));
        answersCorrectDisplay.append(" " + Integer.toString(answersCorrect));
        finalScoreDisplay.append(" " + Integer.toString(finalScore));
    }

    // The final score creator which is a multiplier and combiner of game state endings
    public int calculateFinalScore (int seconds, int answers) {
        int finalScore = 0;
        finalScore = seconds*2;
        finalScore += answers * 5;
        return finalScore;
    }

    // Send the user back to the menu
    private void launchMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
