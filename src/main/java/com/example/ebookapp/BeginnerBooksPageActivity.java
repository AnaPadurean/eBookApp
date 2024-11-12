package com.example.ebookapp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BeginnerBooksPageActivity extends AppCompatActivity {

    private ImageView menuIcon;
    private DrawerLayout drawerLayout;
    private LinearLayout bookOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner_books_page);

        drawerLayout = findViewById(R.id.drawerLayout);
        menuIcon = findViewById(R.id.menu_icon);
        bookOne = findViewById(R.id.read_eggsandham);
        bookOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to open MainActivity
                Intent intent = new Intent(BeginnerBooksPageActivity.this, BeginnerBook1EggsAndHam.class);
                startActivity(intent);  // Start MainActivity

            }
        });


        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START); // Close the drawer if it is open
                } else {
                    drawerLayout.openDrawer(GravityCompat.START); // Open the drawer if it is closed
                }
            }
        });
    }

}