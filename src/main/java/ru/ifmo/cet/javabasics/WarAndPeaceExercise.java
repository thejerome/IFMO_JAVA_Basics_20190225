package ru.ifmo.cet.javabasics;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Stream;


public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        Stream<String> streamFromFiles = Stream.concat(Files.lines(tome12Path.toAbsolutePath(), Charset.forName("windows-1251")), Files.lines(tome34Path.toAbsolutePath(), Charset.forName("windows-1251")));

        Map<String, Integer> data = new HashMap<String, Integer>();

        streamFromFiles.map((s) -> s.toLowerCase().replaceAll("[^а-яa-z]", " "))
                .forEach((line) -> Stream.of(line.split(" ")).filter(filteredWord -> filteredWord.length() >= 4).forEach(
                        (word) -> data.put(word, data.getOrDefault(word, 0) + 1))
                );


        StringBuilder finalSB = new StringBuilder();

        List<Map.Entry<String, Integer>> list = new LinkedList<>(data.entrySet());

        Comparator<Map.Entry<String, Integer>> comp = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> i1, Map.Entry<String, Integer> i2) {
                int valueComaration = i2.getValue().compareTo(i1.getValue());
                return valueComaration == 0 ? i1.getKey().compareTo(i2.getKey()) : valueComaration;
            }
        };

        list.stream()
                .sorted(comp)
                .filter(word -> word.getValue() >= 10)
                .forEach(word -> finalSB.append(word.getKey() + " - " + word.getValue() + "\n"));

        return finalSB.toString().substring(0, finalSB.toString().length() - 1);
    }
}
