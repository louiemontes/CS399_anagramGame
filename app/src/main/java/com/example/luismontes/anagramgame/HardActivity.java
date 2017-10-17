package com.example.luismontes.anagramgame;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
import android.os.CountDownTimer;

public class HardActivity extends AppCompatActivity {

    // A few beginnings needed for the game
    private int completedScore = 0;
    public String[] wordBank = {"algorithm","mortify","elaborate"};
    private Random rand = new Random();
    private int secondsLeft = 30;

    // Making references for XML elements
    private Button goBackFromHard;
    private Button firstSubmit;
    private EditText firstInput;
    private TextView firstWord;
    private Button secondSubmit;
    private EditText secondInput;
    private TextView secondWord;
    private TextView timer;

    // This method scrambes the words from the word bank using an array of characters
    private static String scramble( Random random, String inputString )
    {
        // function courtesy of Fisher-Yates scramble
        char a[] = inputString.toCharArray();
        for( int i=0 ; i<a.length ; i++ )
        {
            int j = random.nextInt(a.length);
            char temp = a[i]; a[i] = a[j];  a[j] = temp;
        }
        return new String( a );
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);

        // "Give up?" button returns to menu
        goBackFromHard = (Button) findViewById(R.id.goBackFromHard);
        goBackFromHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMenu();
            }
        });

        // Save the word shuffles in a separate array
        String scrambles[] = new String[10];
        for (int i=0; i<wordBank.length; i++) {
            scrambles[i] = scramble(rand, wordBank[i]);
        }

        // Set up the word-answer section
        firstWord = (TextView)findViewById(R.id.firstWord);
        firstWord.setText(scrambles[0]);
        firstSubmit = (Button) findViewById(R.id.firstSubmit);
        firstSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if the word guess at the scramble is correct
                firstInput = (EditText) findViewById(R.id.firstInput);
                if ((firstInput.getText().toString()).equals(wordBank[0])) {
                    firstInput.setTextColor(Color.parseColor("#0000FF"));
                    System.out.println("correct word");
                    completedScore++;
                    firstSubmit.setTextColor(Color.parseColor("#0000FF"));
                    // disable submit button since used already guessed word correctly
                    firstSubmit.setClickable(false);
                } else {
                    System.out.println("not correct?");
                    firstInput.setTextColor(Color.parseColor("#FF0000"));

                }
            }
        });

        // same as the first word spot but with another word from the word bank
        secondWord = (TextView)findViewById(R.id.secondWord);
        secondWord.setText(scrambles[1]);
        secondSubmit = (Button) findViewById(R.id.secondSubmit);
        secondSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondInput = (EditText)findViewById(R.id.secondInput);
                if ( (secondInput.getText().toString()).equals(wordBank[1])){
                    secondInput.setTextColor(Color.parseColor("#0000FF"));
                    System.out.println("correct word");
                    completedScore++;
                    secondSubmit.setTextColor(Color.parseColor("#0000FF"));
                    secondSubmit.setClickable(false);
                } else {
                    System.out.println("not correct?");
                    secondInput.setTextColor(Color.parseColor("#FF0000"));
                }
            }
        });

        // Timer starts to make the game finite
        timer = (TextView) findViewById(R.id.timer);
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {

                timer.setText("  " + (millisUntilFinished / 1000) +"s");
                secondsLeft = secondsLeft -1;

                // should the user complete before the time alloted,
                // end game and show the score
                if (completedScore == 2) {
                    cancel();
                    showScore(secondsLeft, completedScore);
                }

            }
            public void onFinish() {
                timer.setText("done!");
                showScore(0, completedScore);
            }
        }.start();
    }

    // go back to menu AND end session
    private void launchMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    // send user to score page
    private void showScore(int secondsLeft, int numberCorrect) {
        Intent intent = new Intent(this, ScoresActivity.class);
        intent.putExtra("secondsLeft", secondsLeft);
        intent.putExtra("answersCorrect", completedScore);
        startActivity(intent);
    }
}