package com.example.infotech;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText loginEmailEditText, loginPasswordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Initialize views
        loginEmailEditText = findViewById(R.id.loginEmailEditText);
        loginPasswordEditText = findViewById(R.id.loginPasswordEditText);
        loginButton = findViewById(R.id.loginButton);

        // Set click listener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user-entered data
                String enteredEmail = loginEmailEditText.getText().toString();
                String enteredPassword = loginPasswordEditText.getText().toString();

                // Check if email and password match the stored credentials
                if (isValidLogin(enteredEmail, enteredPassword)) {
                    // Redirect to MainActivity
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Login.this, "Invalid login credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidLogin(String enteredEmail, String enteredPassword) {
        // Retrieve stored credentials from SharedPreferences
        SharedPreferences preferences = getSharedPreferences("user_credentials", MODE_PRIVATE);
        String storedEmail = preferences.getString("USER_EMAIL", "");
        String storedPassword = preferences.getString("USER_PASSWORD", "");

        // Compare entered credentials with stored data
        return enteredEmail.equals(storedEmail) && enteredPassword.equals(storedPassword);
    }
}