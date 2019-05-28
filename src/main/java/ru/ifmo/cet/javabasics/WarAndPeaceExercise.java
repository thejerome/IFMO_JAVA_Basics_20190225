package ru.ifmo.cet.javabasics;

import java.nio.file.Files;
import java.io.*;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;


public class WarAndPeaceExercise {
    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) return o1.getKey().compareTo(o2.getKey());
                else return -(o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        List<String> parseBase = Files.readAllLines(tome12Path, Charset.forName("windows-1251"));
        parseBase.addAll(Files.readAllLines(tome34Path, Charset.forName("windows-1251")));

        Map<String, Integer> data = new HashMap<>();

        for (var tempLine : parseBase) {
            String temp = tempLine.toLowerCase().replaceAll("[^а-яa-z]", " ");

            for (var tempWord : temp.split(" ")) {
                if (tempWord.length() > 3) {
                    if (!data.containsKey(tempWord)) {
                        data.put(tempWord, 0);
                    }
                    data.put(tempWord, data.get(tempWord) + 1);
                }
            }
        }

        Map<String, Integer> srtdata = sortByValue(data);

        String generated = "";

        for (Map.Entry<String, Integer> entry : srtdata.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value >= 10) {
                generated += key + " - " + value + "\n";
            }
        }

        return generated.substring(0, generated.length() - 1);

    }
}
