package ru.ifmo.cet.javabasics;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        Stream<String> stringOfFirstFile = Files.lines(tome12Path, Charset.forName("windows-1251"));
        Stream<String> stringOfBothFile = Files.lines(tome34Path, Charset.forName("windows-1251"));
        stringOfBothFile = Stream.concat(stringOfFirstFile, stringOfBothFile);


        StringBuilder strBuilder = new StringBuilder();

        stringOfBothFile.map(String::toLowerCase).flatMap(s -> Arrays.stream(s.split("[^а-яa-z]+")))
                .flatMap(lines -> Arrays.stream(lines.split(" ")))
                .filter(word -> word.length()>=4)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(word -> word.getValue()>9)
                .sorted(Comparator.<Map.Entry<String, Long>, Long>comparing(entry -> entry.getValue()).reversed().thenComparing(entry -> entry.getKey()))
                .forEach(word -> strBuilder.append(word.getKey()).append(" - ").append(word.getValue()).append("\n"));

        return strBuilder.toString().trim();

    }
}