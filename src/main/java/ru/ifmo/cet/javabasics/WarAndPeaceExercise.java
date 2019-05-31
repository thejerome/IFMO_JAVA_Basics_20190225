package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.Files.readAllLines;


public class WarAndPeaceExercise {

    private static void find(Path path) throws IOException {
        for (String line : readAllLines(path, Charset.forName("windows-1251"))) {
            line = line.toLowerCase();
            line = line.replaceAll("[^а-яa-z]", " ");
            for (String word : line.split(" ")) {
                if (word.length() > 3) {
                    if (words.containsKey(word)) {
                        words.put(word, words.get(word) + 1);
                    } else {
                        words.put(word, 1);
                    }
                }
            }
        }
    }

    private static Map<String, Integer> words = new HashMap<>();

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        find(tome12Path);
        find(tome34Path);
        List<Map.Entry<String,Integer>> sortMap = new ArrayList<>(words.entrySet());
        sortMap.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue()))
                    return o1.getKey().compareTo(o2.getKey());
                else
                    return o2.getValue().compareTo(o1.getValue());
            }
        });
        StringBuilder result = new StringBuilder();
        for(Map.Entry entry: sortMap){
            String key = (String) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if (value >= 10) {
                result.append(key).append(" - ").append(value).append("\n");
            }
        }
        return result.toString().trim();
    }
}