package com.example.postnumre.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PostAccessor {


    public HashMap<Integer,String> readFile() {
        HashMap<Integer, String> postnumbers = new HashMap<>();

        try {
            File file = new File("danske-postnumre-byer-1.csv");
            Scanner line = new Scanner(file);
            line.nextLine();

            while (line.hasNextLine()) {
                Scanner fetcher = new Scanner(line.nextLine());
                fetcher.useDelimiter(";");
                int key = fetcher.nextInt();
                String value = fetcher.next();
                postnumbers.put(key,value);

            }


        } catch (IOException e) {
            System.out.println("ups");
        }



        return postnumbers;
    }



    public String cityIndexer(int index) {
        HashMap<Integer,String> hm = readFile();
        String found = "Ingen bydel findes ved dette postnummer";


        for (Map.Entry<Integer, String> entry: hm.entrySet()) {
            if (entry.getKey() == index) {
                found = entry.getValue();
            }
        }


        return found;
    }


}
