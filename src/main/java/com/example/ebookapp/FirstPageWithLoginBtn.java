package com.example.ebookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstPageWithLoginBtn extends AppCompatActivity {
    private Button signInBtn;
    private Button signUpBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page_with_login_btn);
        signInBtn = findViewById(R.id.signInBtn);
        signUpBtn = findViewById(R.id.signUpBtn);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstPageWithLoginBtn.this, LoginPage.class);
                startActivity(intent);
                finish();
            }
        });
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstPageWithLoginBtn.this, CreateNewAccount.class);
                startActivity(intent); // Navigate to CreateNewAccount
                finish();
            }
        });
    }
}


