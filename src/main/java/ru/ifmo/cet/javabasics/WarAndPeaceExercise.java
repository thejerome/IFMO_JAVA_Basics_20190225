package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import static java.nio.file.Files.readAllLines;

public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
        List<String> TextLines = readAllLines(tome12Path, Charset.forName("windows-1251"));
        TextLines.addAll(readAllLines(tome34Path, Charset.forName("windows-1251")));
        Map<String, Integer> words = new HashMap<>();
        TextLines.forEach(Line -> Arrays.stream(Line.split("[\\s,.[0-9]«»()?!\\]\\[;:'\\“\"…„]+")).
                filter(x -> x.length() >= 4).map(String::toLowerCase).forEach(Word ->
                { words.put(Word, 1 + ((words.keySet().contains(Word)) ? words.get(Word) : 0)); }));
        List<Map.Entry<String, Integer>> frequencies = new ArrayList<>(words.entrySet());
        frequencies.sort(Map.Entry.comparingByKey());
        frequencies.sort(Map.Entry.comparingByValue((x, y) -> y - x));
        frequencies.removeIf((x) -> x.getValue() < 10);
        StringBuilder builder = new StringBuilder();
        frequencies.forEach(p -> builder.append(p.getKey() + " - " + p.getValue() + "\n"));
        return (builder.length() > 0) ? builder.substring(0, builder.length() - 1) : "";
        //maybe C# next time..?
    }
}
