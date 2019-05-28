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

    public static String warAndPeace() throws IOException{
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
        //final Path testPath = Paths.get("src", "main", "resources", "test.txt");

        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO If word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order if needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10
        List<String> listtome12 = Files.readAllLines(tome12Path, Charset.forName("windows-1251"));
        List<String> listtome34 = Files.readAllLines(tome34Path, Charset.forName("windows-1251"));
        listtome12.addAll(listtome34);
        Stream<String> words = Arrays.stream(listtome12.toArray())
                .flatMap(s -> Arrays.stream(s.toString().toLowerCase().replaceAll("[^а-яa-z]", " ").split(" ")))
                .filter(s -> s.length() >= 4)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(s -> s.getValue() >= 10)
                .sorted(Comparator.<Map.Entry<String, Long>, Long>comparing(entry -> entry.getValue()).reversed().thenComparing(entry -> entry.getKey()))
                .map(s -> s.getKey() + " - " + s.getValue());
        StringBuilder ans = new StringBuilder();
        words.forEach((s) -> ans.append(s).append("\n"));//.reduce("", (s1, s2) -> s1 + "\n" + s2);
        return ans.substring(0, ans.length() - 1);
    }

}