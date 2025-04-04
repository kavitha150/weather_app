package com.example.weather_app;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

    public class LoginActivity extends AppCompatActivity {

        private EditText loginEmail, loginPassword;
        private Button loginSubmitButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            loginEmail = findViewById(R.id.loginEmail);
            loginPassword = findViewById(R.id.loginPassword);
            loginSubmitButton = findViewById(R.id.loginSubmitButton);

            loginSubmitButton.setOnClickListener(v -> {
                String email = loginEmail.getText().toString();
                String password = loginPassword.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this, homepage.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }



