package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.*;

public class WarAndPeaceExercise {
    private static String[] readFileAsStrings(Path path) throws IOException {
        List<String> fileSet = Files.readAllLines(path, Charset.forName("windows-1251"));
        return Arrays.toString(fileSet.toArray())
                .toLowerCase()
                .split("([^А-я\\w]|[\\s\\d])+");
    }
    private static void mapWords(Map<String, Integer> map, String[] array) {
        for (String word : array) {
            if (word.length() >= 4) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
    }
    public static String warAndPeace() {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
        try {
            String[] tome12String = readFileAsStrings(tome12Path);
            String[] tome34String = readFileAsStrings(tome34Path);
            Map<String, Integer> wordsMap = new HashMap<>();
            mapWords(wordsMap, tome12String);
            mapWords(wordsMap, tome34String);
            SortedSet<KeyValuePair> sortedMapSet = new TreeSet<>();
            for(Map.Entry<String, Integer> item : wordsMap.entrySet())
            {
                sortedMapSet.add(new KeyValuePair(item.getValue(),item.getKey()));
            }
            StringBuilder result = new StringBuilder();
            for (KeyValuePair p : sortedMapSet) {
                if (p.getValue() >= 10) {
                    result.append(p.getKey()).append(" - ").append(p.getValue()).append("\n");
                }
            }
            return result.deleteCharAt(result.length()-1).toString();
        }
        catch (IOException e) {
            return e.getMessage();
        }
    }
}
