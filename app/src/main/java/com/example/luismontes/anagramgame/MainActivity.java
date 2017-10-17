package com.example.luismontes.anagramgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {

    // Reference some XML elements
    private Button goToCredits;
    private Button goToDifficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // activate button to go to credits
        goToCredits = (Button) findViewById(R.id.goToCredits);
        goToCredits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCredits();
            }
        });

        goToDifficulty = (Button) findViewById(R.id.goToDifficulty);
        goToDifficulty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchDifficulty();
            }
        });
    }

    // make the goToCredits button go to the credits screen
    private void launchCredits() {
        Intent intent = new Intent(this, CreditsActivity.class);
        startActivity(intent);
    }

    // make the goToDifficulty button go to the game mode select screen
    private void launchDifficulty() {
        Intent intent = new Intent(this, DifficultyActivity.class);
        startActivity(intent);
    }
}
