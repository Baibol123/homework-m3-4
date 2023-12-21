package com.example.homework_m3_4;

import java.io.Serializable;
import java.util.ArrayList;

public class Continent implements Serializable {
    private String continentName;
    private String continentImage;
    private ArrayList<String> continentCountries;

    public Continent(String continentName, String continentImage, ArrayList<String> cities) {
        this.continentName = continentName;
        this.continentImage = continentImage;
        this.continentCountries = cities;
    }




    public String getContinentName() {
        return continentName;
    }

    public String getContinentImage() {
        return continentImage;
    }

    public ArrayList<String> getContinentCountries() {
        return continentCountries;
    }
}
