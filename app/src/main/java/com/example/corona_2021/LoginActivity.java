package com.example.corona_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);

        Button login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(LoginActivity.this, "Button clicked", Toast.LENGTH_LONG).show();
                //Perform action on click
                Intent activityChangeIntent = new Intent(LoginActivity.this, NextActivity.clone);
                startActivity (activityChangeIntent);
            }
        });

        Button register = (Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(LoginActivity.this, "Button clicked", Toast.LENGTH_LONG).show();

                //Perform action on click
                //Intent activityChangeIntent = new Intent(LoginActivity.this, NextActivity.clone);
                //startActivity (activityChangeIntent);
            }
        });



