package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.*;

public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        List<String> lines = Files.readAllLines(tome12Path, Charset.forName("windows-1251"));
        lines.addAll(Files.readAllLines(tome34Path, Charset.forName("windows-1251")));

        String[] words = Arrays.toString(lines.toArray()).toLowerCase().split("[^a-zа-я]+");

        Map<String, Integer> wordsMap = new HashMap<>();

        for (String word : words)
            if (word.length() >= 4)
                wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);

        SortedSet<Map.Entry<String, Integer>> answers = new TreeSet<>(
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                        if (!a.getValue().equals(b.getValue()))
                            return b.getValue() - a.getValue();
                        else
                            return a.getKey().compareTo(b.getKey());
                    }
                }
        );
        answers.addAll(wordsMap.entrySet());

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : answers)
            if (entry.getValue() >= 10)
                result.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");

        return result.deleteCharAt(result.length()-1).toString();
    }
}
