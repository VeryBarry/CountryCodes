package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static HashMap<String, ArrayList<Country>> countryHash = new HashMap<>();

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a character: ");
        String input = scanner.nextLine();

        File f = new File("countries.txt");
        ArrayList<Country> country = new ArrayList<>();
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(f);
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] column = line.split("\\|");
                String countryID = column[0];
                String countryName = column[1];

                country.add();


            }
            for (Country c : country) {
                String firstLetter = String.valueOf(countryID.charAt(0));
                countryHash.put(firstLetter, new ArrayList<>());
            }

            for (Country c : country) {
                String firstLetter = String.valueOf(countryName.charAt(0));
                ArrayList<Country> currentList = countryHash.get(firstLetter);
                countryHash.put(firstLetter, currentList);
            }
            System.out.println(countryHash);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}


/*
Create a Country class to store both the name and abbreviation.

Read and parse the "countries.txt" file into an HashMap<String, ArrayList<Country>>
    where the key is a single letter and the value is a list of countries whose names start with that letter.

Ask the user to type a letter (if they don't type a single letter, throw an exception).

Save an "X_countries.txt" file, where X is the letter they typed, which only lists the countries starting with that letter.

Break your code into separate methods, especially the for loop that loops over each line in the file,
    and the code under it that reads the user's input and writes the file.

Write tests for your methods where it makes sense to.

Encode the output as JSON instead of building a string manually.

You should be able to take the ArrayList you pulled out of your HashMap and put it in a wrapper class.

Remember to add getters to your Country class.

Override the toString method in your Country class so when you print your HashMap you can see the country abbreviations and names.

Recall that, by default, Java prints out objects like this: Country@21345362.
*/