package com.example.infotech;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.infotech.R;
import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {

    private EditText signupEmailEditText, signupPasswordEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        // Initialize views
        signupEmailEditText = findViewById(R.id.signupEmailEditText);
        signupPasswordEditText = findViewById(R.id.signupPasswordEditText);
        submitButton = findViewById(R.id.submitButton);

        // Set click listener for the submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user-entered data
                String userEmail = signupEmailEditText.getText().toString();
                String userPassword = signupPasswordEditText.getText().toString();

                // Store user credentials in SharedPreferences
                storeCredentials(userEmail, userPassword);

                // Redirect to LoginActivity
                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void storeCredentials(String email, String password) {
        // Store user credentials in SharedPreferences
        SharedPreferences preferences = getSharedPreferences("user_credentials", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("USER_EMAIL", email);
        editor.putString("USER_PASSWORD", password);
        editor.apply();
    }
}
