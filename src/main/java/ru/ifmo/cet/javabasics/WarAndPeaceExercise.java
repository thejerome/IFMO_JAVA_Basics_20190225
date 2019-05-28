package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;

import static java.nio.file.Files.readAllLines;

public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {
        // Text load
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
        List<String> TextLines = readAllLines(tome12Path, Charset.forName("windows-1251"));
        TextLines.addAll(readAllLines(tome34Path, Charset.forName("windows-1251")));

        // Get all the words with frequencies
        Map<String, Integer> Voc = new HashMap<>();
        for (String Line : TextLines)
            for (String word : Line.split("[\\s,.[0-9]«»()?!\\]\\[;:'\\“\"…„]+"))
                if ((word = word.toLowerCase()).length() >= 4)
                    Voc.put(word, 1 + (Voc.keySet().contains(word) ? Voc.get(word) : 0));

        // List, sort and filter
        List<Map.Entry<String, Integer>> WordFreq = new ArrayList<>(Voc.entrySet());
        WordFreq.sort(Map.Entry.comparingByKey());
        WordFreq.sort(Map.Entry.comparingByValue(new Comparator<Integer>() {@Override public int compare(Integer x, Integer y) { return y - x; }}));
        WordFreq.removeIf(new Predicate<Map.Entry<String, Integer>>() {@Override public boolean test(Map.Entry<String, Integer> x) { return x.getValue() < 10; }});

        // Obtain the answer
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> p : WordFreq)
            builder.append(p.getKey() + " - " + p.getValue() + "\n");

        return (builder.length() > 0) ? builder.substring(0, builder.length() - 1) : "";
    }
}
