package com.example.luismontes.anagramgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DifficultyActivity extends AppCompatActivity {

    private Button goBackFromDifficulty;
    private Button goToEasy;
    private Button goToHard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

        goBackFromDifficulty = (Button) findViewById(R.id.goBackFromDifficulty);
        goBackFromDifficulty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMenu();
            }
        });

        goToEasy = (Button) findViewById(R.id.goToEasy);
        goToEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchEasy();
            }
        });

        goToHard = (Button) findViewById(R.id.goToHard);
        goToHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchHard();
            }
        });
    }

    // The intention changers: move to proper intention based on user choice from clicking on the buttons
    private void launchMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void launchEasy() {
        Intent intent = new Intent(this, EasyActivity.class);
        startActivity(intent);
    }
    private void launchHard() {
        Intent intent = new Intent(this, HardActivity.class);
        startActivity(intent);
    }
}