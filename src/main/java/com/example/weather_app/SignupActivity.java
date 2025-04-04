package com.example.weather_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    private EditText signupName, signupEmail, signupPassword;
    private Button signupSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupName = findViewById(R.id.signupName);
        signupEmail = findViewById(R.id.signupEmail);
        signupPassword = findViewById(R.id.signupPassword);
        signupSubmitButton = findViewById(R.id.signupSubmitButton);

        signupSubmitButton.setOnClickListener(v -> {
            String name = signupName.getText().toString();
            String email = signupEmail.getText().toString();
            String password = signupPassword.getText().toString();

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(SignupActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SignupActivity.this, "Signup successful", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(SignupActivity.this, homepage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

