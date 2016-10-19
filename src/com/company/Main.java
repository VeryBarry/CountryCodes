package com.company;

import jodd.json.JsonSerializer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static HashMap<String, ArrayList<Country>> countriesH = new HashMap<>();
    static final String countriesList = "countries.txt";
    public static String firstLetter1;

    public static ArrayList<Country> read(String countriesList) {
        ArrayList<Country> countries = new ArrayList<>();
        File file = new File("countries.txt");
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(file);
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] columns = line.split("\\|");
                Country country = new Country(columns[0], columns[1]);
                countries.add(country);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return countries;
    }
    public static void addHash (ArrayList<Country> countries) {
        for (Country country : countries) {
            String secondLetter = String.valueOf(country.countryCode.charAt(0));
            ArrayList<Country> countryNameBeginsWith = countriesH.get(secondLetter);
            if ( countryNameBeginsWith == null) {
                countryNameBeginsWith = new ArrayList<>();
            }
            countryNameBeginsWith.add(country);
            countriesH.put(secondLetter, countryNameBeginsWith);
        }
    }
    public static void createFile(String firstLetter1, ArrayList<Country> countryList) throws IOException {
        File countryFile = new File(firstLetter1 + "_countries.txt");
        FileWriter fileWriter = new FileWriter(countryFile);
        for (Country country : countryList) {
            fileWriter.append(country.toString() + "\n");
        }
        fileWriter.close();
    }
    public static void createJson(String firstLetter1, ArrayList<Country> countryList) throws IOException {
        File countryJson = new File(firstLetter1 + "_countries.json");
        JsonSerializer serializer = new JsonSerializer();
        CountryWrapper wrapper = new CountryWrapper();
        wrapper.country = countryList;
        String json = serializer.deep(true).serialize(wrapper);
        FileWriter writeJson = new FileWriter(countryJson);
        writeJson.write(json);
        writeJson.close();
    }
    public static void main(String[] args) throws IOException {
        ArrayList<Country> countriesA = read(countriesList);
        System.out.println("Please enter a letter.");
        Scanner scanner = new Scanner(System.in);
        String firstLetter = scanner.nextLine();
        String firstLetter1 = firstLetter.toUpperCase();
        System.out.println("You entered : " + firstLetter1);
        if (!firstLetter1.matches("^[a-zA-Z]+$")){
            System.out.println("You must enter a letter.");
            main(args);
            return;
        }
        if (firstLetter1.isEmpty()) {
            System.out.println("You have to enter a letter");
            main(args);
            return;
        }
        if (firstLetter1.length() > 1) {
            System.out.println("You may only enter one letter.");
            main(args);
            return;
        }
        addHash(countriesA);
        ArrayList<Country> countryList = countriesH.get(firstLetter1);
        createFile(firstLetter1,countryList);
        createJson(firstLetter1,countryList);
    }


}