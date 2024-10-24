package com.example.ebookapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ImageView menuIcon;
    private RecyclerView recyclerView;
    private CardView beginnerCard;


//    private static final String TAG = "Firebase";
//
//    private TextView dataDisplayText;
//    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        menuIcon = findViewById(R.id.menu_icon);


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
        beginnerCard = findViewById(R.id.beginnerCard);

        // Set OnClickListener on the Beginner Card
        beginnerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the BeginnerBooksPageActivity when beginnerCard is clicked
                Intent intent = new Intent(MainActivity.this, BeginnerBooksPageActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START); // Close the drawer if it is open when back button is pressed
        } else {
            super.onBackPressed();
        }
    }
}
//        setContentView(R.layout.testfirebase);

//        dataDisplayText = findViewById(R.id.dataDisplayText);
//
//        FirebaseApp.initializeApp(this);
//        db = FirebaseFirestore.getInstance();
//
//        fetchDataFromFirestore();


//    private void fetchDataFromFirestore() {
//        Log.d(TAG, "Fetching data from Firestore...");
//        db.collection("beginner").document("aeMY0Tq4lJ0FWSAK3yzv")
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        DocumentSnapshot document = task.getResult();
//                        if (document.exists()) {
//                            // Retrieve multiple fields
//                            String field1 = document.getString("Brown bear, Brown bear, what do you see?");
//                            String field2 = document.getString("Goodnight moon");
//                            String field3 = document.getString("Green Eggs and Ham");
//                            // Add more fields as necessary
//
//                            // Concatenate the field values
//                            String text = "Field 1: " + (field1 != null ? field1 : "N/A") + "\n" +
//                                    "Field 2: " + (field2 != null ? field2 : "N/A") + "\n" +
//                                    "Field 3: " + (field3 != null ? field3 : "N/A");
//                            // Add more fields to the text as necessary
//
//                            Log.d(TAG, "Text from Firestore: " + text);
//                            dataDisplayText.setText(text);
//                        } else {
//                            Log.d(TAG, "No such document");
//                            dataDisplayText.setText("No such document");
//                        }
//                    } else {
//                        Log.d(TAG, "get failed with ", task.getException());
//                        dataDisplayText.setText("Failed to fetch data");
//                    }
//                })
//                .addOnFailureListener(e -> {
//                    Log.e(TAG, "Error fetching data", e);
//                    dataDisplayText.setText("Error fetching data: " + e.getMessage());
//                });
//    }

