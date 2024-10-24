package com.example.ebookapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import androidx.appcompat.app.AppCompatActivity;

public class BeginnerBook1EggsAndHam extends AppCompatActivity {
    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    private TextView textDisplay;
    private ImageButton micButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner_book1_eggsandham);

        textDisplay = findViewById(R.id.text_display);
        micButton = findViewById(R.id.mic_button);

        // Set sample text from database (this should come from your DB)
        textDisplay.setText("This is the sample text for the user to read.");

        micButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSpeechToText();
            }
        });
    }

    private void startSpeechToText() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
//        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Start speaking...");

        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
        } catch (Exception e) {
            Toast.makeText(this, "Speech-to-Text not supported on this device", Toast.LENGTH_SHORT).show();
        }
    }

    // Handle the Speech input
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SPEECH_INPUT && resultCode == RESULT_OK && data != null) {
            ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String spokenText = result.get(0);

            // Check if spoken text matches the displayed text
            if (spokenText.equalsIgnoreCase(textDisplay.getText().toString())) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

