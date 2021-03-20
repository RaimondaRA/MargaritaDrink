package com.example.corona_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Funkcijos pradzia, antraste
        super.onCreate(savedInstanceState); //Sukuriamas tuscias langas
        setContentView(R.layout.activity_register); //Tusciam langui suteikiamas vaizdas, kuris aprasytas activity_register.xml faile

        EditText username = findViewById(R.id.username); //Is resursu paimamas id, suranda username ir ji grazina (username yra kintamasisi). Susiejamas elementas vaizde su kintamuoju kode
        EditText email = findViewById(R.id.email); // Tai yra 4 elementai (16-19 eilutes), kuriuos aktyviai naudos vartotojas, kurie istraukti is vaizdo
        EditText password = findViewById(R.id.password);
        Button register = findViewById(R.id.register); //Kintamasis register identifikuojamas kaip mygtukas (Button)

        //Aprasomas kodas, susijes su mygtuko paspaudimu
        register.setOnClickListener(new View.OnClickListener() { //setOnClickListener yra kintamojo funkcija, kuri tikrina, kada mygtukas bus paspaustas
            @Override // Perrasome is anksto nustatyta mygtuko paspaudima, kas bus po paspaudimo
            public void onClick(View view) { //Tai yra onClick metodas/funkcija. Funkscijos pradzia
                //Cia rasomas kodas, kuris bus vykdomas paspaudus mygtuka
                String usernameStr = username.getText().toString(); //Vartotojas suves eilute. Kreipiames i kintamaji, kad nuskaitytu vartotojo suvesta teksta
                String emailStr = email.getText().toString(); //getText - issitraukiame eilute is EditText
                String passwordStr = password.getText().toString();

                username.setError(null); //Isvalomas klaidu zurnalas
                email.setError(null);
                password.setError(null);

                Intent goToLoginActivity = new Intent(RegisterActivity.this, LoginActivity.class); //Is kur, i kur
                startActivity(goToLoginActivity); //Jei bus validus duomenys, atsidarys login langas, pereisime is vieno lango i kita.

            } //onClick funkcijos pabaiga
        }); //onClick pabaiga
    }

}