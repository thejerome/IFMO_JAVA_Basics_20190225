package ru.ifmo.cet.javabasics;

import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.*;
import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        List<String> tome12List = Files.readAllLines(tome12Path, Charset.forName("windows-1251"));
        List<String> tome34List = Files.readAllLines(tome34Path, Charset.forName("windows-1251"));
        tome12List.addAll(tome34List); //весь текст в tome12


        String answer = Arrays.stream(tome12List.toArray())
                .flatMap(a -> Arrays.stream(a.toString().toLowerCase().replaceAll("[^а-яa-z]", " ").split(" ")))
                .filter(a -> a.length() >= 4)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(a -> a.getValue() >= 10)
                .map(a -> a.getKey()+ " - " + a.getValue().toString())
                .sorted()
                .sorted((s1, s2) -> Integer.parseInt(s2.substring(s2.lastIndexOf(" ") + 1)) - Integer.parseInt(s1.substring(s1.lastIndexOf(" ") + 1)))
                .reduce("", (a1, a2) -> a1 + "\n" + a2);
        return answer.substring(1);
    }

}