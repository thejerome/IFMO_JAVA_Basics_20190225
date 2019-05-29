package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.*;

public class WarAndPeaceExercise {

    private static List<String> readOnlyWords(Path path) {
        try {
            return Arrays.asList(Files.readAllLines(path, Charset.forName("windows-1251"))
                    .toString()
                    .toLowerCase()
                    .split("([^а-я\\w]|[\\s\\d])+"));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private static Comparator<Map.Entry<String, Integer>> descendingOrder() {
        return Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                .reversed()
                .thenComparing(Map.Entry::getKey);
    }

    public static String warAndPeace() {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        List<String> wordsList = new ArrayList<>(readOnlyWords(tome12Path));
        wordsList.addAll(readOnlyWords(tome34Path));

        Map<String, Integer> wordsMap = new HashMap<>();

        wordsList.stream().filter(word -> word.length() >= 4)
                .forEach(words -> wordsMap.put(words, wordsMap.getOrDefault(words, 0) + 1));

        StringBuilder result = new StringBuilder();

        wordsMap.entrySet().stream().filter(entry -> entry.getValue() >= 10)
                .sorted(descendingOrder())
                .forEach(entry -> result.append(String.format("%s - %s\n", entry.getKey(), entry.getValue())));

        return result.deleteCharAt(result.length() - 1).toString();
    }
}
