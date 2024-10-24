package com.example.ebookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateNewAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_account);

        Button createAccountButton = findViewById(R.id.crateNewAccount);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateNewAccount.this, MainActivity.class);
                startActivity(intent);  // Start MainActivity
                finish();  // Close LoginPage so that the user can't go back to it
            }
        });
    }
}