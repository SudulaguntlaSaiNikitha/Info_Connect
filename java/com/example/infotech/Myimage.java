package com.example.infotech;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Myimage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_main);

        // Get reference to the button in the CardView
        Button cardButton = findViewById(R.id.cardButton);

        // Set click listener for the button
        cardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open a website in the default web browser when the button is clicked
                String websiteUrl = "httpsnikini://www.youtube.com/";  // Replace with your desired website URL
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
                startActivity(intent);
            }
        });
    }
}
