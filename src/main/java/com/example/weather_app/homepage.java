////
////package com.example.weather_app;
////
////import android.content.Intent;
////import android.os.Bundle;
////import android.view.View;
////import android.widget.Button;
////import androidx.appcompat.app.AppCompatActivity;
////
////public class homepage extends AppCompatActivity {
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.homepage);
////
////        Button btnCheckWeather = findViewById(R.id.btnCheckWeather);
////        Button btnSettings = findViewById(R.id.btnSettings);
////
////        // OnClickListener for the "Check Weather" button
////        btnCheckWeather.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                // Navigate to MainActivity
////                Intent intent = new Intent(homepage.this, MainActivity.class);
////                startActivity(intent);
////            }
////        });
////
////        // OnClickListener for the "Settings" button
////        btnSettings.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                // Navigate to SettingsActivity
////                Intent intent = new Intent(homepage.this, SettingsActivity.class);
////                startActivity(intent);
////            }
////        });
////    }
////}
////
//
//
//package com.example.weather_app;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.widget.Button;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//
//public class homepage extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.homepage);
//
//        // Enable back button in the Action Bar
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setTitle("homepage"); // Set a title for the screen
//        }
//
//        // Initialize buttons
//        Button btnCheckWeather = findViewById(R.id.btnCheckWeather);
//        Button btnSettings = findViewById(R.id.btnSettings);
//
//        // Navigate to the weather screen (MainActivity)
//        btnCheckWeather.setOnClickListener(v -> {
//            Intent intent = new Intent(homepage.this, MainActivity.class);
//            startActivity(intent);
//        });
//
//        // Navigate to the settings screen (SettingsActivity)
//        btnSettings.setOnClickListener(v -> {
//            Intent intent = new Intent(homepage.this, SettingsActivity.class);
//            startActivity(intent);
//        });
//    }
//
//    // Handle the back button in the Action Bar
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == android.R.id.home) {
//            // Navigate back to the previous activity
//            onBackPressed();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    // Explicitly handle back button press
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed(); // Navigate back to the previous activity
//        finish(); // Ensure the activity is removed from the stack
//    }
//}
//





package com.example.weather_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        Button btnCheckWeather = findViewById(R.id.btnCheckWeather);
        Button btnSettings = findViewById(R.id.btnSettings);
        Button btnBack = findViewById(R.id.btnBack); // Back button

        // "Check Weather" button logic
        btnCheckWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // "Settings" button logic
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        // Back button logic
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close the current activity and go back to the previous one
                finish();
            }
        });
    }
}
