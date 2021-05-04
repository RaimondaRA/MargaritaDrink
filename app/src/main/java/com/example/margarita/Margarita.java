package com.example.margarita;

public class Margarita {
    private String id;
    private String name;
    private String types;
    private String category;
    private String glass;

    public Margarita(String idDrink, String strDrink, String strAlcoholic, String strCategory, String strGlass) { //Konstruktorius
        this.id = idDrink;
        this.name = strDrink;
        this.types = strAlcoholic;
        this.category = strCategory;
        this.glass = strGlass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    @Override
    public String toString() {// toString grazina eilute tvarkinga - Drink name ir t.t.
        return "Margarita{" +
                "Drink ID='" + id + '\'' +
                ", Drink Name='" + name + '\'' +
                ", Drink Type='" + types + '\'' +
                ", Category=" + category +
                ", Glass Type=" + glass +
                '}';
    }
}
