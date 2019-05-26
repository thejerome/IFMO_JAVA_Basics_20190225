package ru.ifmo.cet.javabasics;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;




public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException{
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
        List<String> volumes12 = Files.readAllLines(tome12Path.toAbsolutePath(), Charset.forName("windows-1251"));
        List<String> volumes34 = Files.readAllLines(tome34Path.toAbsolutePath(), Charset.forName("windows-1251"));
        volumes12.addAll(volumes34);

        String frequences = volumes12.stream().map(String :: toLowerCase).map(s -> s.replaceAll("[^а-яa-z]", " "))
                .map(s -> s.split(" ")).flatMap(s -> Arrays.stream(s))
                .filter((s) -> s.length() >= 4).collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream().filter(s -> s.getValue() >= 10)
                .sorted(new Comparator<Map.Entry<String, Long>>() {
                    @Override
                    public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                        return o1.getValue().compareTo(o2.getValue()) == 0
                                ? o1.getKey().compareTo(o2.getKey())
                                : o1.getValue().compareTo(o2.getValue()) * (-1);
                    }
                }).map(s -> s.getKey() + " - " +s.getValue()).reduce("", (x, y) -> x + y + "\n").trim();
        return frequences;
    }
}