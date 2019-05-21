package ru.ifmo.cet.javabasics;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.io.*;
import java.util.*;

import static java.nio.file.Files.readAllLines;



public class WarAndPeaceExercise {
    private static HashMap<String, Integer> dictionary = new HashMap<>();


    public static String warAndPeace() throws IOException{
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO If word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order if needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10
        findWord(tome12Path);
        findWord(tome34Path);
        return compareAndCheckCount();


    }
    private static void findWord(Path path) throws IOException {
        for (String line : readAllLines(path, Charset.forName("windows-1251"))) {
            line = line.replaceAll("[^а-яА-Яa-zA-Z]", " ");
            for (String word : line.split(" ")) {
                if (word.length() < 4) {
                    continue;
                }
                word = word.toLowerCase();
                if (dictionary.containsKey(word)) {
                    dictionary.put(word, dictionary.get(word) + 1);
                } else {
                    dictionary.put(word, 1);
                }
            }
        }
    }

    private static String compareAndCheckCount() {
        List<Map.Entry<String,Integer>> list = new ArrayList<>(dictionary.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if(e1.getValue().equals(e2.getValue()))
                    return e1.getKey().compareTo(e2.getKey());
                else
                    return e2.getValue().compareTo(e1.getValue());
            }
        });
        String text = "";
        for(Map.Entry<String,Integer> entry : list){
            if(entry.getValue() >= 10)
                text += entry.getKey() + " - " + entry.getValue() + "\n";
        }
        return text.trim();
    }

}