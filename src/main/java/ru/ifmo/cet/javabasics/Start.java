package ru.ifmo.cet.javabasics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import static java.util.Collections.swap;

public class Start {
    public HashMap<String, Integer> installMap(ArrayList<String> allLines, HashMap<String, Integer> map) {
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
                    if (map.containsKey(word)) {
                        int count = map.get(word);
                        count++;
                        map.put(word, count);
                    } else {
                        map.put(word, 1);
                    }
                }
            }
        }
        return map;
    }

    public ArrayList<MyClass> installAndSort(Set words, ArrayList<MyClass> temp, HashMap<String, Integer> map) {
        int k = 0;
        for (Object word : words) {
            if (map.get(word) >= 10) {
                String s = word.toString();
                MyClass t = new MyClass(map.get(word), s);
                temp.add(k, t);
                k++;
            }
        }
        for (int i = 0; i < temp.size() - 1; i++) {
            for (int j = i; j < temp.size(); j++) {
                if (temp.get(i).compareTo(temp.get(j)) < 0) {
                    swap(temp, i, j);
                }
            }
        }
        return temp;
    }
}
