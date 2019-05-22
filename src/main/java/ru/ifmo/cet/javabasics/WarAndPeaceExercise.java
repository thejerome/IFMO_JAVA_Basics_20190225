package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.*;

public class WarAndPeaceExercise {

    static class KeyValuePair implements Comparable<KeyValuePair>{
        private String key;
        private int value;

        KeyValuePair(int value, String key) {
            super();
            this.key = key;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public String getKey() {
            return key;
        }

        @Override
        public int compareTo(KeyValuePair other) {
            if (value != other.value) {
                return other.value - value;
            }
            else {
                return key.compareTo(other.key);
            }
        }
    }

    private static String[] readFileAsStrings(Path path) {
        try {
            List<String> fileSet = Files.readAllLines(path, Charset.forName("windows-1251"));
            return Arrays.toString(fileSet.toArray())
                    .toLowerCase()
                    .split("([^а-я\\w]|[\\s\\d])+");
        } catch (IOException e) {
            return new String[0];
        }
    }

    private static void putWordsToMap(Map<String, Integer> map, String[] array) {
        for (String word : array) {
            if (word.length() >= 4) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
    }

    public static String warAndPeace() {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        String[] tome12String = readFileAsStrings(tome12Path);
        String[] tome34String = readFileAsStrings(tome34Path);

        Map<String, Integer> wordsMap = new HashMap<>();

        putWordsToMap(wordsMap, tome12String);
        putWordsToMap(wordsMap, tome34String);

        SortedSet<KeyValuePair> sortedMapSet = new TreeSet<>();

        for (Map.Entry<String, Integer> item : wordsMap.entrySet()) {
            sortedMapSet.add(new KeyValuePair(item.getValue(), item.getKey()));
        }

        StringBuilder result = new StringBuilder();
        for (KeyValuePair p : sortedMapSet) {
            if (p.getValue() >= 10) {
                result.append(p.getKey()).append(" - ").append(p.getValue()).append("\n");
            }
        }

        return result.deleteCharAt(result.length() - 1).toString();
    }
}