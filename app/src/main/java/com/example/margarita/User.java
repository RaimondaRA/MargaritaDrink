package com.example.margarita;

import android.content.Context;
import android.content.SharedPreferences;

public class User { // Klases pradzia. Klase yra viena, todel is didziosios raides. Klase kuriame tam, kad ja panaudotume uz jos ribu, todel public.
    // 1. Klases kintamieji (argumentai, pozymiai). Sie kintamieji bus naudojami Login ir Register languose.
    private String username; // Matomumas, programavimo tipas ir kintamasis
    private String password; //username, password ir email yra User klases pozymiai
    private String email;

    private SharedPreferences sharedPreferences;

    private static final String PREFERENCES_PACKAGE_NAME = "com.example.margarita";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";
    private static final String REMEMBERME_KEY = "rememberMe";

    public User() { // Bevardis konstruktorius - galima jo ir nekurti, sukuriamas automatiskai. Jei konstruktoriaus neapsirasome, tai jis sukuriamas automatiskai.
    }

    // 2. Konstruktorius, skirtas vartotojo prisijungimui (LoginActivity langui).
    public User(String username, String password) { //public - konstruktorius turi buti matomas. Konstruktoriaus antraste
        this.username = username; // pozymis (username) = parametras/kintamasis (username). this. visada eina prie pozymio
        this.password = password;
    }

    //Konstruktorius, skirtas naujo vartotojo registracijai (RegisterActivity langui).
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(Context context) {
        this.sharedPreferences = context.getSharedPreferences(User.PREFERENCES_PACKAGE_NAME,
                Context.MODE_PRIVATE);
    }

    // 3. get'eriai, set'eriai - metodai. Keiciame objekto pozymius per set'erius, get'erius (per konstruktoriu)
    // get'eris atitinka grazinancia f-ja be parametru. Nes nenorime nieko keisti, norime gauti, kad grazintu.

    public String getUsernameForRegistration() {
        return username; // Grazins stringa. Prie f-jos visada yra skliausteliai. Tuo skiriasi nuo kintamojo. Per parametruos siuo atveju nieko neperduodame, bet gauname username.
    }

    ////set'eris atitinka negrazinancia f-ja su parametrais

    public String getPasswordForRegistration() {
        return password;
    }

    public String getEmailForRegistration() {
        return email;
    }

    //public void setUsername(String username){ // Jei norime keisti (set), tai nieko negraziname. Per parametrus (sklaisuteliuose) pakeiciame pozymi nauja reiksme
    //this.username = username; //this. nusako sios klases pozymi (username)
    //}

    public void setPasswordForRegistration(String password) {
        this.password = password;
    }

    public void setEmailForRegistration(String email) {
        this.email = email;
    }

    public String getUsernameForLogin() {
        return this.sharedPreferences.getString(USERNAME_KEY, ""); //nors kabutese tuscia - grazins tai, ka vartotojas ives
    }

    public void setUsernameForLogin(String username) {
        this.sharedPreferences.edit().putString(USERNAME_KEY, username).commit(); //issaugomi vartotojo suvesti duomenys, raktas ir reiksmes
    }

    public String getPasswordForLogin() {
        return this.sharedPreferences.getString(PASSWORD_KEY, "");
    }

    public void setPasswordForLogin(String password) {
        this.sharedPreferences.edit().putString(PASSWORD_KEY, password).commit(); //commit - jei kazka keiciame sharedPreferences, tada reikia dar commit
    }

    public boolean isRememberedForLogin() {
        return this.sharedPreferences.getBoolean(REMEMBERME_KEY, false);
    }

    public void setRemembermeKeyForLogin(boolean remembermeKey) {
        this.sharedPreferences.edit().putBoolean(REMEMBERME_KEY, remembermeKey).commit();
    }

}