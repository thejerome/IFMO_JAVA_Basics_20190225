package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;

public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {

        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
        List<String> listNovel = Files.readAllLines(tome12Path, Charset.forName("windows-1251"));
        listNovel.addAll(Files.readAllLines(tome34Path, Charset.forName("windows-1251")));

        Map<String, Integer> words = new HashMap<>();
        for (String Line : listNovel)
            for (String word : Line.split("[\\s,.[0-9]«»()?!\\]\\[;:'\\“\"…„]+"))
                if ((word = word.toLowerCase()).length() >= 4)
                    words.put(word, 1 + (words.keySet().contains(word) ? words.get(word) : 0));

        List<Map.Entry<String, Integer>> wordFreq = new ArrayList<>(words.entrySet());
        wordFreq.sort(Map.Entry.comparingByKey());
        wordFreq.sort(Map.Entry.comparingByValue(new Comparator<Integer>() {
            @Override public int compare(Integer x, Integer y) { return y - x; }}));
        wordFreq.removeIf(new Predicate<Map.Entry<String, Integer>>() {
            @Override public boolean test(Map.Entry<String, Integer> x) { return x.getValue() < 10; }});

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> p : wordFreq)
            result.append(p.getKey() + " - " + p.getValue() + "\n");

        return result.substring(0, result.length() - 1);
    }
}