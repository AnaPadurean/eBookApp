package com.example.ebookapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DifficultyLevels extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_levels);

        CardView beginnerCard = findViewById(R.id.beginnerCard);

        // Set click listener
        beginnerCard.setOnClickListener(view -> {
            Intent intent = new Intent(DifficultyLevels.this, BeginnerBooksPageActivity.class);
            startActivity(intent);
        });
    }
}