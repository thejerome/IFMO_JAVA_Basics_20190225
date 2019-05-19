package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {
        StringBuilder result = new StringBuilder();
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
        Stream<String> book = Files.lines(tome12Path, Charset.forName("windows-1251"));
        Stream<String> book1 = Files.lines(tome34Path, Charset.forName("windows-1251"));
        Map<String, Long> map = Stream.concat(book, book1)
                .map(s -> s.toLowerCase().replaceAll("\\p{Punct}", " "))
                .map(s -> s.replaceAll("\\u2026", " "))
                .map(s -> s.replaceAll("\\u00BB", " "))
                .map(s -> s.replaceAll("\\u00AB", " "))
                .map(s -> s.replaceAll("\\u201C", " "))
                .map(s -> s.replaceAll("\\u201D", " "))
                .map(s -> s.replaceAll("\\u201E", " "))
                .map(s -> s.replaceAll("\\u2033", " "))
                .map(s -> s.replaceAll("\\u0030", " "))
                .map(s -> s.replaceAll("\\u0031", " "))
                .map(s -> s.replaceAll("\\u0032", " "))
                .map(s -> s.replaceAll("\\u0033", " "))
                .map(s -> s.replaceAll("\\u0034", " "))
                .map(s -> s.replaceAll("\\u0035", " "))
                .map(s -> s.replaceAll("\\u0036", " "))
                .map(s -> s.replaceAll("\\u0037", " "))
                .map(s -> s.replaceAll("\\u0038", " "))
                .map(s -> s.replaceAll("\\u0039", " "))
                .flatMap(s -> Arrays.stream(s.split(" ")))
                //.distinct()
                .filter(s -> s.length() > 3)
                //.peek(s -> System.out.println(s))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        map.entrySet().stream()
                .filter(entry -> entry.getValue() >= 10)
                .sorted(Comparator.<Map.Entry<String, Long>, Long>comparing(entry -> entry.getValue()).reversed().thenComparing(entry -> entry.getKey()))
                .forEach(entry -> result.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n"));

        return result.toString().trim();

    }

}