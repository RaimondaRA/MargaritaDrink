package com.example.corona_2021;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity { //Klases pradzia

    @Override //Perrašymas nustatyta is anksto koda
    protected void onCreate(Bundle savedInstanceState) { //Funkcijos pradzia
        super.onCreate(savedInstanceState); //Tuscio lango sukurimas
        setContentView(R.layout.activity_login); //Suteik tusciam langui šį vaizda (kodas susiejamas su vaizdu)

        EditText username = findViewById(R.id.username); //Susiejamas elementas vaizde su kintamuoju kode
        EditText password = findViewById(R.id.password);
        Button kaipNoriuTaipVadinu = findViewById(R.id.login);

        //Kodas, susijes su mygtuko paspaudimu
        kaipNoriuTaipVadinu.setOnClickListener(new View.OnClickListener() { //setOnClickListener - nustatytk ant paspaudimo; skliausteliuose () yra funkcija (onClick) (o ne kintamasis), kintamuju niekada nebus tokiuose skliausteliouse
            @Override
            public void onClick(View view) { //onClick pradzia, onClick yra metodas
                //Cia rasomas kodas, kuris bus vykdomas, kai bus paspaustas mygtukas
                String usernameStr = username.getText().toString(); //Stringams - pagarba: String rasoma is didziosios raides; String - bazinis tipas; String - kabutese
                String passwordStr = password.getText().toString(); //getText - issitraukti teksta, kurio mums reikia

                Toast.makeText(LoginActivity.this, "Prisijungimo vardas: " + //Tarp skliausteliu yra parametrai; + sujungia eilutes
                        usernameStr + "\n" + "Slaptazodis: " + passwordStr, Toast.LENGTH_LONG).show(); // Teksta, esanti tarp kabuciu, mato vartotojas

                Intent goToSearchActivity = new Intent(LoginActivity.this, SearchActivity.class); //is kur {pirmas parametras .this}, i kur {antras parametras .class}
                startActivity(goToSearchActivity);


            } //onClick pabaiga
        }); //jie eina kartu, mygtuko paspaudimo funkcijo pabaiga

    } //Funkcijos pabaiga

} //Klases pabaiga










