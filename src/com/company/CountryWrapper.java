package com.company;

import java.util.ArrayList;

/**
 * Created by VeryBarry on 9/23/16.
 */
public class CountryWrapper {
    ArrayList<Country> country;

    CountryWrapper(){
    }
    public CountryWrapper(ArrayList<Country> country) {
        this.country = country;
    }

    public ArrayList<Country> getCountry() {
        return country;
    }

    public void setCountry(ArrayList<Country> country) {
        this.country = country;
    }
}

