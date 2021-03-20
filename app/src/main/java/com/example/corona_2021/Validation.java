package com.example.corona_2021;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String USERNAME_REGEX_PATTERN = "^[a-zA-Z0-9]{3,20}$"; //globalusis kintamasis, matomas visur, nes yra klases viduje. Final - galutinis, nesikeicia. Static - matomas ir kitose klasese.
    public static final String PASSWORD_REGEX_PATTERN = "^[a-zA-Z0-9.!@_]{5,20}$"; //Jei kintamasis turi tris zodzius public static final, jis rasomas Capslock
    public static final String EMAIL_REGEX_PATTERN = "^[a-zA-Z0-9@._-]{10,50}$";

    public static boolean isUsernameValid(String username) { //funkcijos antraste. Boolean naujas bazinis tipas, dvi opcijos: true (1) arba false (0), kitas tipas - String. Jei yra void - funkcija niekur negrazina. is zodeliu pradedant, tai grazina true arba false. Aprasant metoda reikia rasyti skliaustuose, kreipiantis - ne.
        return isCredentialsValid(username, USERNAME_REGEX_PATTERN);
    }

    public static boolean isPasswordValid(String password) {
        return isCredentialsValid(password, PASSWORD_REGEX_PATTERN);
    }

    public static boolean isEmailValid(String email) {
        return isCredentialsValid(email, EMAIL_REGEX_PATTERN);
    }

    private static boolean isCredentialsValid(String string, String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern); //Pattern yra klase. Sukuriamos username validacijai taisykles pagal nurodyta sablona. Sablonas sukurk (compile) kazka. Pattern.compile sukuria grieztas taisykles
        Matcher matcher = pattern.matcher(string); //Pagal anksciau sukurtas taisykles (eilute pries) palyginami vartotojo ivesti duomenys (username).
        return matcher.find(); //Kadangi nera void, todel rasome return (graziname).
    }
}
        //boolean isUsernameValid = matcher.find(); //Jei atitinka, grazins true; priesingu atveju - false.






