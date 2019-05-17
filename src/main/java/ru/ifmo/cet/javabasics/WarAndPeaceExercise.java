package ru.ifmo.cet.javabasics;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


import static java.util.Collections.swap;


public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        class MyClass implements Comparable<MyClass> {
            private int i;
            private String n;
            public MyClass(int i, String n) {
                this.i = i;
                this.n = n;
            }
            @Override
            public int compareTo(MyClass my) {
                if (this == my) {
                    return 0;
                }
                if (i != my.i && i > my.i) {
                    return (1);
                } else {
                    if (i < my.i) {
                        return (-1);
                    } else {
                        return (my.n.compareTo(n));
                    }
                }
            }
            public String getWord(){
                return (n);
            }
            public int getFrequence(){
                return (i);
            }
        }

        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO If word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order if needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10
        List<String> lines12 = Files.readAllLines(tome12Path.toAbsolutePath(), Charset.forName("windows-1251"));
        List<String> lines34 = Files.readAllLines(tome34Path.toAbsolutePath(), Charset.forName("windows-1251"));
        List<String> allLines = new ArrayList<>();
        allLines.addAll(lines12);
        allLines.addAll(lines34);

        Map<String, Integer> map = new HashMap<>();

        for (String line : allLines) {
            line = line.toLowerCase().replaceAll("\\p{Punct}", " ");
            line = line.toLowerCase().replaceAll("\\u2026", " ");
            line = line.toLowerCase().replaceAll("\\u00BB", " ");
            line = line.toLowerCase().replaceAll("\\u00AB", " ");
            line = line.toLowerCase().replaceAll("\\u201C", " ");
            line = line.toLowerCase().replaceAll("\\u201D", " ");
            line = line.toLowerCase().replaceAll("\\u201E", " ");
            line = line.toLowerCase().replaceAll("\\u2033", " ");
            line = line.toLowerCase().replaceAll("\\u0030", " ");
            line = line.toLowerCase().replaceAll("\\u0031", " ");
            line = line.toLowerCase().replaceAll("\\u0032", " ");
            line = line.toLowerCase().replaceAll("\\u0033", " ");
            line = line.toLowerCase().replaceAll("\\u0034", " ");
            line = line.toLowerCase().replaceAll("\\u0035", " ");
            line = line.toLowerCase().replaceAll("\\u0036", " ");
            line = line.toLowerCase().replaceAll("\\u0037", " ");
            line = line.toLowerCase().replaceAll("\\u0038", " ");
            line = line.toLowerCase().replaceAll("\\u0039", " ");
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.length() >= 4) {
                    if(map.containsKey(word)) {
                        int count = map.get(word);
                        count++;
                        map.put(word, count);
                    } else {
                        map.put(word, 1);
                    }
                }
            }
        }
        List<MyClass> temp = new ArrayList<>();
        Set words = map.keySet();
        //System.out.println(map.entrySet());
        int k = 0;
        for (Object word : words) {
            if (map.get(word) >= 10) {
                String s = word.toString();
                MyClass t = new MyClass(map.get(word), s);
                temp.add(k, t);
                k++;
            }
        }
        for (int i = 0; i < temp.size()-1; i++){
            for (int j = i; j < temp.size(); j++){
                if (temp.get(i).compareTo(temp.get(j)) < 0) {
                    swap(temp, i, j);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < temp.size(); i++){
            result.append(temp.get(i).getWord());
            result.append(" - ");
            result.append(temp.get(i).getFrequence());
            if (i != temp.size()-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }
}