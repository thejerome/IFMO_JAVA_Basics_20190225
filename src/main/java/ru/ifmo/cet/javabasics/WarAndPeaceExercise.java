package ru.ifmo.cet.javabasics;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.nio.file.Path;
import java.nio.file.Paths;


public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException{
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO Iff word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order iff needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10

        Stream<String> textInLines = Stream.concat(Files.lines(tome12Path.toAbsolutePath(), Charset.forName("windows-1251")), Files.lines(tome34Path.toAbsolutePath(), Charset.forName("windows-1251")));

        StringBuilder end = new StringBuilder();

        textInLines.map(String::toLowerCase).map(lines -> {
            return lines.replaceAll("[^а-яa-z]", " ");
        })
                .flatMap(lines -> {
                    return Arrays.stream(lines.split(" "));
                })
                .filter(word -> {
                    return word.length() > 3;
                })
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(word -> {
                    return word.getValue() >= 10;
                })
                .sorted((o1, o2) -> {
                    return (o1.getValue().compareTo(o2.getValue()) == 0) ? o1.getKey().compareTo(o2.getKey()) : -(o1.getValue()).compareTo(o2.getValue());
                })
                .forEach(word -> end.append(word.getKey()).append(" - ").append(word.getValue()).append("\n"));

        return end.toString().trim();
    }
}