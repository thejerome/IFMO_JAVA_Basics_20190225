package ru.ifmo.cet.javabasics;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.*;


public class WarAndPeaceExercise {

        public static String warAndPeace() throws IOException {
            final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
            final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
            Map<String, Integer> TMap = new TreeMap();
            List<String> Text = Files.readAllLines(tome12Path, Charset.forName("windows-1251"));
            List<String> DText = Files.readAllLines(tome34Path, Charset.forName("windows-1251"));
            Text.addAll(DText);

            // TODO map lowercased words to its amount in text and concatenate its entries.
            // TODO If word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
            // TODO Entries in final String should be also sorted by amount and then in alphabetical order if needed.
            // TODO Also omit any word with lengths less than 4 and frequency less than 10
            for(String i : Text){
                String lines = i.toLowerCase().replaceAll("[^а-яa-z]", " ");
                for(String word : lines.split(" ")){
                    if(word.length() >= 4){
                        if(TMap.containsKey(word)) TMap.put(word,TMap.get(word)+1);
                        else TMap.put(word,1);
                    }
                }
            }
        List<Map.Entry<String,Integer>> words = new ArrayList<Map.Entry<String, Integer>>(TMap.entrySet());

        Collections.sort(words,new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b) {
                return b.getValue() - a.getValue();
            }
        });

        String result = "";
        for(Map.Entry<String,Integer> word : words){
            if(word.getValue()>=10) result += word.getKey() + " - " + word.getValue()+"\n";
        }
        return result.trim();
    }
}