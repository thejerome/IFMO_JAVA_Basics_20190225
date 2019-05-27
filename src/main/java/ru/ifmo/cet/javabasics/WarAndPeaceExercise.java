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

        Stream<String> txtLines12 = Files.lines(tome12Path.toAbsolutePath(), Charset.forName("windows-1251"));
        Stream<String> txtLines34 = Files.lines(tome34Path.toAbsolutePath(), Charset.forName("windows-1251"));
        Stream<String> txtLines = Stream.concat(txtLines12,txtLines34);

        StringBuilder result = new StringBuilder();

        txtLines.map(String::toLowerCase).map(lines -> lines.replaceAll("[^a-zа-я]"," "))
                .flatMap(lines -> Arrays.stream(lines.split(" ")))
                .filter(word -> word.length()>3)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(word -> word.getValue()>=10)
                .sorted((o1, o2) -> o1.getValue().equals(o2.getValue()) ? o1.getKey().compareTo(o2.getKey()) : -(o1.getValue()).compareTo(o2.getValue()))
                .forEach(word -> result.append(word.getKey()).append(" - ").append(word.getValue()).append("\n"));

        return result.toString().trim();
    }

}