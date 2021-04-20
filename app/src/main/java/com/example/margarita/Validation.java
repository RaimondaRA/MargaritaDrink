package com.example.margarita;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String USERNAME_REGEX_PATTERN = "^[a-zA-Z0-9]{3,20}$"; //globalusis kintamasis, matomas visur (visose f-jose), nes yra klases, o ne funkcijos viduje. Final - galutinis, nesikeicia. Static - matomas ir kitose klasese.
    public static final String PASSWORD_REGEX_PATTERN = "^[a-zA-Z0-9.!@_]{5,20}$"; //Jei kintamasis turi tris zodzius public static final, jis rasomas Capslock
    public static final String EMAIL_REGEX_PATTERN = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+[a-zA-Z]{10,50}$"; //Zemiau sias eilutes (simboliu kratinius) paversime i grieztas taisykles

    public static boolean isUsernameValid(String username) { //funkcijos antraste. Boolean naujas bazinis tipas, dvi opcijos: true (1) arba false (0), kitas tipas - String. Jei yra void - funkcija niekur negrazina. "is" zodeliu pradedant, tai grazina true arba false. Aprasant f-ja, tipa reikia rasyti skliaustuose, kreipiantis - ne. isUsernameValid yra funkcija, o zemiau tokiu pat pavadinimu - kintamasis
        Pattern pattern = Pattern.compile(USERNAME_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(username);
        boolean isUsernameValid = matcher.find(); //Irasome username, nes tikrinama, ar username atitinka taisykles. isUsernameValid yra kintamasis, galima ji bet kaip pavadinti
        return isUsernameValid; //arba galima apjungti dvi eilutes ir rasyti return matcher.find(). return true pakeitus isUsernameValid - vietoj nuolat true, grazins atitinkamai.
        //return isCredentialsValid(username, USERNAME_REGEX_PATTERN); galima 12-15 eilutes istrinti ir palikti tik sia - 16 eilute
    }

    public static boolean isPasswordValid(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(password);
        boolean isPasswordValid = matcher.find(); //Jei atitinka, grazins true; priesingu atveju - false.
        return isPasswordValid;
        //return isCredentialsValid(password, PASSWORD_REGEX_PATTERN);
    }

    public static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(email);
        boolean isEmailValid = matcher.find();
        return isEmailValid;
        //return isCredentialsValid(email, EMAIL_REGEX_PATTERN);
    }

    //private static boolean isCredentialsValid(String string, String regexPattern) { //Perduodame du parametrus - string ir pattern. isCredentialsValid paims du parametrus: viename nurodysime tai, ka vartotojas iveda (username, password arba email), o kitas parametras - regexPattern, kuri perduosime is virsaus. Todel netenka prasmes Validation klaseje musu apsirasyti sablonai, nebent, jei is LoginActivity besikreipiant i sia f-ja, nurodysime Validation.isUsernameValid, isPasswordValid, tai viska pasiims
    ////isCredentialsValid tampa universalia f-ja. Siuo atveju nereikia kurtis 3 f-ju, kad pravaliduoti 3 laukelius
    //Pattern pattern = Pattern.compile(regexPattern); //Pattern yra klase. Sukuriamos username validacijai taisykles pagal nurodyta sablona. Sablonas sukurk (compile) kazka. Pattern.compile sukuria grieztas taisykles
    //Matcher matcher = pattern.matcher(string); //Pagal anksciau sukurtas taisykles (eilute pries) palyginami vartotojo ivesti duomenys (username). Matcher - atitikmuo/atitikimas
    //return matcher.find(); //Kadangi nera void, todel rasome return (graziname). Jei atitinka - grazins true, priesingu atveju - false
    //}
}







