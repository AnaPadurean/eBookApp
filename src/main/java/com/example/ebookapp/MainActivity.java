package com.example.ebookapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<SubjectModel>list;
    SubjectAdaptor adapter;
    RecyclerView recyclerView;
    DrawerLayout drawerLayout;

    NavigationView navigationView;
    ImageView menu ;
    View header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

       recyclerView =findViewById(R.id.recySubject);
       menu=findViewById(R.id.menu_icon);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView= findViewById(R.id.navView);
        list =new ArrayList<>();
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);


        list.add(new SubjectModel("Beginner"));
        list.add(new SubjectModel("Intermediate"));
        list.add(new SubjectModel("Advanced"));

        adapter = new SubjectAdaptor(this, list);
        recyclerView.setAdapter(adapter);

        header=navigationView.getHeaderView(0);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else{
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              if(item.getItemId() == R.id.home ) {

                  Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                  drawerLayout.closeDrawer(GravityCompat.START);
              }

               else if(item.getItemId() == R.id.my_profile) {

                    Toast.makeText(MainActivity.this,"My profile", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }

         else if  (item.getItemId() == R.id.sign_out) {


                        Toast.makeText(MainActivity.this, "Sign Out", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);

                }

                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }

        else{
            super.onBackPressed();
        }


    }
}