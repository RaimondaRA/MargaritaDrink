package com.example.corona_2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class JSON {

    private static String readAll(Reader rd) throws IOException { //metodas
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
    //Visas ilgas tekstas is API nuskaitomas i stringa, o is tringo jis konvertuojamas i JSON objekta
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException { //metodas. Kreipsimes i URL ir mums is jo grazins JSON
        InputStream is = new URL(url).openStream();
        try { // i try talpinamas kodas, kuriame gali kilti kokia nors isimtis - klaida
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8"))); //nuskaitoma is URL linko
            String jsonText = readAll(rd); //Grazina stringa, padaromas stringas
            JSONObject json = new JSONObject(jsonText); //formuoja JSON objekta
            return json; //grazina JSON
        } finally { //Ivyks ar neivyks klaida, galiausiai viskas bus uzdaryta. Siuo atveju uzdaromi ivedimo srautai
            is.close();
        }
    }
}

//    public static void main(String[] args) throws IOException, JSONException {
//        JSONObject json = readJsonFromUrl("https://graph.facebook.com/19292868552");
//        System.out.println(json.toString());
//        System.out.println(json.get("id"));
//    }
