package com.example.ebookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {
    private Button signInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


        signInButton = findViewById(R.id.login);
        TextView forgotPasswordText = findViewById(R.id.forgotPass);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
            // Create an Intent to open MainActivity
            Intent intent = new Intent(LoginPage.this, MainActivity.class);
            startActivity(intent);  // Start MainActivity
            finish();  // Close LoginPage so that the user can't go back to it
        }
    });
        forgotPasswordText.setOnClickListener(view -> {
            // Create an intent to open forgot_password_page activity
            Intent intent = new Intent(LoginPage.this, forgot_password_page.class);
            startActivity(intent);
        });
    }
    }

