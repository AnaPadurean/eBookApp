package com.example.ebookapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.cloud.speech.v1.SpeechSettings;

public class BeginnerBook1EggsAndHam extends AppCompatActivity {

    private static final String TAG = "BeginnerBooksPageActivity";
    private ProgressBar progressBar;
    private PDFView pdfView;
    private ImageView menuIcon;
    private DrawerLayout drawerLayout;

    // Declare the SpeechClient
    private SpeechClient speechClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner_book1_eggsandham);

        try {
            // Load credentials from the specified absolute path
            String keyFilePath = "eBookApp/app/nlpapp-441221-db67c1d72918.json";
            FileInputStream keyFileStream = new FileInputStream(keyFilePath);
            GoogleCredentials credentials = GoogleCredentials.fromStream(keyFileStream);

            speechClient = SpeechClient.create(SpeechSettings.newBuilder()
                    .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
                    .build());

            Log.d(TAG, "SpeechClient initialized successfully");
        } catch (Exception e) {
            Log.e("SpeechClientInit", "Failed to initialize SpeechClient: " + e.getMessage(), e);
        }

        // Initialize views
        progressBar = findViewById(R.id.progressBar);
        pdfView = findViewById(R.id.pdfView);
        menuIcon = findViewById(R.id.menu_icon);
        drawerLayout = findViewById(R.id.drawerLayout);

        // Download and display the PDF from Google Drive
        downloadAndDisplayPdf("https://drive.google.com/uc?export=download&id=1a1an6F5VFMT7A2IGoz7QLU4Oz9nbd9Y8");
    }

    private void downloadAndDisplayPdf(String fileUrl) {
        progressBar.setVisibility(View.VISIBLE);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                URL url = new URL(fileUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();

                InputStream inputStream = connection.getInputStream();
                runOnUiThread(() -> {
                    progressBar.setVisibility(View.GONE);
                    pdfView.fromStream(inputStream)
                            .swipeHorizontal(false) // Ensure vertical scrolling only
                            .enableAntialiasing(true) // Improve rendering on low-res screens
                            .spacing(10) // Add space between pages for better UX
                            .scrollHandle(new DefaultScrollHandle(this)) // Add scroll handle
                            .enableAntialiasing(true)
                            .onError(t -> {
                                Toast.makeText(BeginnerBook1EggsAndHam.this, "Error loading PDF: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                                Log.e(TAG, "Error loading PDF", t);
                            })
                            .onLoad(nbPages -> progressBar.setVisibility(View.GONE))
                            .load();
                });

            } catch (Exception e) {
                runOnUiThread(() -> {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(BeginnerBook1EggsAndHam.this, "Error downloading PDF", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "Error downloading PDF", e);
                });
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
