package ru.ifmo.cet.javabasics;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Stream;



public class WarAndPeaceExercise {

    private static List<String> finalValue = new LinkedList<String>();
    private static Map<String, Integer> wordsCount = new HashMap<String, Integer>();

    public static Integer getValue(String baseValue){
        return Integer.parseInt(baseValue.split(" - ")[1]);
    }

    public static String getKey(String baseValue){
        return baseValue.split(" - ")[0];
    }

    public static void addWord(String word){
        wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        finalValue.add(word);
    }

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        Stream<String> streamFromFiles = Stream.concat(Files.lines(tome12Path.toAbsolutePath(), Charset.forName("windows-1251")), Files.lines(tome34Path.toAbsolutePath(), Charset.forName("windows-1251")));

        streamFromFiles
                .forEach((l) -> Stream.of(l.toLowerCase().replaceAll("[^а-яa-z]", " ").split(" ")).filter(r -> r.length() >= 4).forEach(
                        (w) -> addWord(w))
                );


        StringBuilder generator = new StringBuilder();

        finalValue.stream()
                .map(s -> s + " - " + wordsCount.get(s))
                .distinct()
                .sorted((i1, i2) -> getValue(i2).compareTo(getValue(i1)) == 0 ?  getKey(i1).compareTo(getKey(i2)): getValue(i2).compareTo(getValue(i1)))
                .filter(t -> getValue(t) >= 10)
                .forEach(word -> generator.append(word + "\n"));

        return  generator.toString().substring(0, generator.toString().length()-1);
    }
}