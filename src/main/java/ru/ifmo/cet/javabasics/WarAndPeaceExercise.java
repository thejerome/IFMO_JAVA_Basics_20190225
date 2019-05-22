package ru.ifmo.cet.javabasics;

import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WarAndPeaceExercise{

    public static String warAndPeace() throws IOException{
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO If word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order if needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10


        Map<String, Integer> textMap = new TreeMap();
        List<String> linetome_12 = Files.readAllLines(tome12Path, Charset.forName("windows-1251"));
        List<String> linetome_34 = Files.readAllLines(tome34Path, Charset.forName("windows-1251"));
        ArrayList<String> LinesInText = new ArrayList<>();
        LinesInText.addAll(linetome_12);
        LinesInText.addAll(linetome_34);

        for(String i : LinesInText){
            String lines = i.toLowerCase().replaceAll("[^а-яa-z]", " ");
            for(String textWord : lines.split(" ")){
                if(textWord.length()>=4){
                    if(textMap.containsKey(textWord)) textMap.put(textWord,textMap.get(textWord)+1);
                    else textMap.put(textWord,1);
                }
            }
        }

        List<Map.Entry<String,Integer>> words = new ArrayList<Map.Entry<String, Integer>>(textMap.entrySet());
        Collections.sort(words,new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
        String result = "";
        for(Map.Entry<String,Integer> k : words){
            if(k.getValue()>=10) result += k.getKey()+" - "+k.getValue()+"\n";
        }
        return result.trim();
    }

}