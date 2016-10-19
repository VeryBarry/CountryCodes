package com.company;

/**
 * Created by VeryBarry on 9/22/16.
 */
public class Country {
    String countryCode;
    String countryName;
    public Country(String countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }
    public String getCountryName() {
        return countryName;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    @Override
    public String toString() {
        return "Country{" + "Country Code:'" + countryCode + '\'' + ", Country Name:" + countryCode + '}';
    }
}