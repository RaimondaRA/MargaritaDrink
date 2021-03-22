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
    protected void onCreate(Bundle savedInstanceState) { //Funkcijos pradzia, antraste
        super.onCreate(savedInstanceState); //Tuscio lango sukurimas
        setContentView(R.layout.activity_login); //Suteik tusciam langui šį vaizda (kodas susiejamas su vaizdu)

        EditText username = findViewById(R.id.username); //Susiejamas elementas vaizde su kintamuoju kode
        EditText password = findViewById(R.id.password);
        Button kaipNoriuTaipVadinu = findViewById(R.id.login);
        Button register = findViewById(R.id.register);

        //Kodas, susijes su mygtuko paspaudimu
        kaipNoriuTaipVadinu.setOnClickListener(new View.OnClickListener() { //setOnClickListener - nustatytk ant paspaudimo; skliausteliuose () yra funkcija (onClick) (o ne kintamasis), kintamuju niekada nebus tokiuose skliausteliouse
            @Override
            public void onClick(View view) { //onClick pradzia, onClick yra metodas
                //Cia rasomas kodas, kuris bus vykdomas, kai bus paspaustas mygtukas
                String usernameStr = username.getText().toString(); //Stringams - pagarba: String rasoma is didziosios raides; String - bazinis tipas; String - kabutese
                String passwordStr = password.getText().toString(); //getText - issitraukti teksta, kurio mums reikia

                username.setError(null); //0 yra verte, skaicius. Null yra nieko, tuscia. setError - issivalome username klaidu zurnala. Pries validacija - klaidu nera.
                password.setError(null);

                if (Validation.isUsernameValid(usernameStr) && Validation.isPasswordValid(passwordStr)) { //if prasideda salyga. if grazina true arba false. {} nusako ir salygos if pradzia ir pabaiga, ne tik funkcijos ir klases. Kreipinyje i f-ja nenurodome tipo, nes jis aprasytas 29 eiluteje: usernameStr.
                    Intent goToSearchActivity = new Intent(LoginActivity.this, SearchActivity.class); //is kur {pirmas parametras .this}, i kur {antras parametras .class}
                    startActivity(goToSearchActivity); //Jei bus validus duomenys, pereisime is vieno lango i kita.
                } else { //visais kitais atvejais, todel nereikia skliausteliu. Tai tas pats if, tik nusako priesingu atveju
                    username.setError(getResources().getString(R.string.login_invalid_credentials)); //jei nevalidus, ismesime i ekrana klaida
                    username.requestFocus(); //Ismeta lentele juoda prie username laukelio.
                    //Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_invalid_username), Toast.LENGTH_LONG).show();
                }
            } //onClick pabaiga
        }); //jie eina kartu, mygtuko paspaudimo funkcijos pabaiga

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToRegisterActivity = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(goToRegisterActivity);
            }
        });

    } //Funkcijos pabaiga

} //Klases pabaiga


// } else if (!Validation.isUsernameValid(usernameStr)){ //! yra paneigimas, t. y. jeigu nebus validus, ismesime i ekrana klaida
//  username.setError(getResources().getString(R.string.login_invalid_username)); getResources - R. raide kreipiames i resursus
//  username.requestFocus();

//Toast.makeText(LoginActivity.this, "Prisijungimo vardas: " + //Tarp skliausteliu yra parametrai; + sujungia eilutes
//usernameStr + "\n" + "Slaptazodis: " + passwordStr, Toast.LENGTH_LONG).show(); // Teksta, esanti tarp kabuciu, mato vartotojas









