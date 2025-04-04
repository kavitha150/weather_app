package com.example.weather_app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        // Initialize the Back button
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the previous activity
                finish();
            }
        });

        // Reference the views
        Switch switchNotification = findViewById(R.id.switchNotification);
        View btnChangeLanguage = findViewById(R.id.btnChangeLanguage);
        View ivAboutIcon = findViewById(R.id.ivAboutIcon);

        // Handle notifications switch
        switchNotification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(SettingsActivity.this, "Notifications Enabled", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SettingsActivity.this, "Notifications Disabled", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Handle change language button click
        btnChangeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to a ChangeLanguageActivity (to be implemented)
                Toast.makeText(SettingsActivity.this, "Change Language Selected", Toast.LENGTH_SHORT).show();
                // Intent intent = new Intent(SettingsActivity.this, ChangeLanguageActivity.class);
                // startActivity(intent);
            }
        });

        // Handle about icon click
        ivAboutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display app information (can navigate to AboutActivity or show a dialog)
                Toast.makeText(SettingsActivity.this, "About the App", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
