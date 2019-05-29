package ru.ifmo.cet.javabasics;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class WarAndPeaceExercise {
    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
        Stream<String> Text = Stream.concat(Files.lines(tome12Path.toAbsolutePath(), Charset.forName("windows-1251")), Files.lines(tome34Path.toAbsolutePath(), Charset.forName("windows-1251")));

        String Note = Text.map(String::toLowerCase).map(s -> s.replaceAll("[^а-яa-z]", " "))
                .map(s -> s.split(" ")).flatMap(s -> Arrays.stream(s))
                .filter((s) -> s.length() >= 4).collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream().filter(s -> s.getValue() >= 10).sorted(new Comparator<Map.Entry<String, Long>>() {
                    @Override
                    public int compare(Map.Entry<String, Long> a, Map.Entry<String, Long> b) {
                        return a.getValue().compareTo(b.getValue()) == 0
                                ? a.getKey().compareTo(b.getKey())
                                : a.getValue().compareTo(b.getValue()) * (-1);
                    }
                }).map(s -> s.getKey() + " - " + s.getValue()).reduce("", (x, y) -> x + y + "\n").trim();
        return Note;
    }
}