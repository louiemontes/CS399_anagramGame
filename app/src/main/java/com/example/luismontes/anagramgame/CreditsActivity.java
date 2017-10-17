package com.example.luismontes.anagramgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreditsActivity extends AppCompatActivity {

    // Reference the one major XML element here
    private Button goBackFromCredits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        goBackFromCredits = (Button) findViewById(R.id.goBackFromCredits);

        // Go back to menu with that one XML button
        goBackFromCredits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
