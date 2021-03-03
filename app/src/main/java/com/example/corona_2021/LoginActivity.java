package com.example.corona_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        Button login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View focusView) {

                String username2 = username.getText().toString();
                String password2 = password.getText().toString();
                Toast.makeText(LoginActivity.this, "Username " + username2 + "\n" + "Password " + password2, Toast.LENGTH_SHORT).show();

                //Perform action on click
                Intent goToSearchActivity = new Intent(LoginActivity.this, SearchActivity.class);
                startActivity(goToSearchActivity);
                //Klaidu zurnalo isvalymas
                username.setError(null);
                password.setError(null);
                if (Validation.isCredentialsValid(username2) && Validation.isCredentialsValid(password2)){

                    goToSearchActivity = new Intent(LoginActivity.this, SearchActivity.class);
                    startActivity(goToSearchActivity);
            } else {
                    username.setError(getResources().getString(R.string.login_invalid_credentials_message));
                    username.requestFocus();
                }
            }
        });
    }
}










