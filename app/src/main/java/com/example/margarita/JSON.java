package com.example.margarita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSON { //is URL istraukiamas JSON ir jis atspausdinamas

    private static String readAll(Reader rd) throws IOException { //metodas
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    //Visas ilgas tekstas is API nuskaitomas i stringa, o is stringo jis konvertuojamas i JSON objekta
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

    //metodas, kuris paims JSON objekta ir grazins JSON masyva. Issitraukiame is JSON tik tai, kas mus domina. Nereikalingos info reikia atsikratyti. Isimsim pacia pradzia (meta duomenis) ir pabaigos simbolius
    public static ArrayList<Margarita> getList(JSONArray jsonArray) throws JSONException {//metodo antraste. Grazins sarasa, Margarita klases objektu (ArrayList, o ne visa JSON). JSONArray yra klase ir jsonArray yra objektas. ArrayList - vienas is sarasu programavime
        ArrayList<Margarita> margaritaList = new ArrayList<Margarita>();//sukureme sarasa, kur norime pataplinti klases Margarita objektus. margaritaList - saraso pavadinimas.
        //isimti "data" is JSON (pirma eilute) ir issaugoti margarita objektu sarase (margaritaList)
        for (int i = 0; i < jsonArray.length(); i++) { //ciklas, rodo 3 salygas: pradinis iteratorius i
            JSONObject jsonObject = jsonArray.getJSONObject(i); //eisim per visa sarasa JSON masyva, sarasa. Issitrauksime reiksmes
            Margarita margarita = new Margarita( //Margarita konstruktorius, susideda is 5 elemntu. 1 elementas - idDrink, todel trauksime idDrink
                    //public Margarita(String idDrink, String strDrink, String strTags, String strCategory, String strGlass)
                    jsonObject.getString("idDrink"), //idDrink rasoma taip, kaip JSON duomenyse. Traukiant raktus is JSON, jie turi buti IDENTISKI
                    jsonObject.getString("strDrink"),
                    jsonObject.getString("strAlcoholic"),
                    jsonObject.getString("strCategory"), //visi raktai yra String tipo, eilutes, nors ir grazins int skaiciu
                    jsonObject.getString("strGlass")
            );
            margaritaList.add(margarita); //eis per visus JSON sarase esancius objektus, paims objektus, issitrauks reiksmes, konstruosime margarita klases objekta ir prideime i margarita sarasa
        }

        return margaritaList;
    }

    public static JSONArray getJSONArray(JSONObject json) throws JSONException {//metodas
//        //pasalinama is JSON visa nereikalinga info (meta duomenys), paliekant tik covid19Stats masyva
//        int jsonLength = jsonObject.toString().length(); //mums reikia tik covid19Stats. Gauname viso JSON ilgi (apie 80 tukst simboliu), grazina ilgio skaiciu
//        String covid19Stats = "{" + jsonObject.toString().substring(96, jsonLength) + "}"; //jsonObject konvertuojame i eilute (String), substring - iskerpa dali simboliu is stringo. Iskirps nuo 96-to iki pacio galo

        //String konvertacija i JSON objekta
//        JSONObject json = new JSONObject(drinks); //perduodame covid19Stats stringa

        //JSONObject i JSONArray. Sukonstravome is objekto sarasa, masyva
        JSONArray jsonArray = json.getJSONArray("drinks");
        return jsonArray; //jsonArray paims getList
    }

    //pagal visa sarasa suformuos tik tra valstybe, kurios mumsreikia
    public static ArrayList<Margarita> getMargaritaListByQuery(ArrayList<Margarita> margaritaArrayList, String name) { //metodas, noresim gauti sarasa pagal kokteilio pavadinima. F-ja paims du parametrus - ArrayList, kokteil. pav. Grazins arrayList
        ArrayList<Margarita> margaritaListByQuery = new ArrayList<Margarita>();
        //pereisime per visa sarasa Margarita ArrayList, ieskosime tos valstybes ir formuosime
        for (Margarita margarita : margaritaArrayList) { //desineje puseje bus sukuriamas tos klases objektas, per kurios sarasa iteruojame. Iteruojame per klases objektus
            if (margarita.getName().contains(name)) { //contains metodas (vienas is String metodu) - iesko zodzio dalies is ivesto getName. Pradejus rasyti zodi, pradeda ieskoti.
                margaritaListByQuery.add(margarita);
            }
        }

        return margaritaListByQuery;
    }
}

//    public static void main(String[] args) throws IOException, JSONException {
//        JSONObject json = readJsonFromUrl("https://graph.facebook.com/19292868552");
//        System.out.println(json.toString());
//        System.out.println(json.get("id"));
//    }
