package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.*;


public class WarAndPeaceExercise {

    private static String readFileAsString(Path path) throws IOException {
        return new String(Files.readAllBytes(path));
    }

    public static String warAndPeace() {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        try {
            String fullText = readFileAsString(tome12Path) + readFileAsString(tome34Path);
            String[] wordsArray = fullText.toLowerCase().split("(?U)[\\W\\d]");

            Map<String, Integer> wordsMap = new HashMap<>();

            for (String word : wordsArray) {
                if (word.length() >= 4) {
                    wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
                }
            }

            StringBuilder result = new StringBuilder();
            List<Map.Entry<String, Integer>> list = new ArrayList<>(wordsMap.entrySet());
            SortedSet<KeyValuePair> sortedSet = new TreeSet<>();

            for(Map.Entry<String, Integer> item : list)
            {
                sortedSet.add(new KeyValuePair(item.getValue(),item.getKey()));
            }

            for (KeyValuePair p : sortedSet) {
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