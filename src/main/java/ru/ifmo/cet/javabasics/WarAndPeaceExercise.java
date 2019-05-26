package ru.ifmo.cet.javabasics;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;




public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        StringBuilder result = new StringBuilder();

        Stream<String> summary = Stream.concat(Files.lines(tome12Path, Charset.forName("windows-1251")), Files.lines(tome34Path, Charset.forName("windows-1251")));


        summary.map((p) -> p.toLowerCase())
                .map((p) -> p.replaceAll("[^a-zа-я]", " "))
                .flatMap((p) -> Arrays.stream(p.split(" ")))
                .filter((p) -> p.length() >= 4)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter((p) -> p.getValue() >= 10)
                .sorted(Comparator.<Map.Entry<String, Long>, Long>comparing((p) -> p.getValue())
                        .reversed()
                        .thenComparing((p) -> p.getKey()))
                .forEach((p) -> result.append(p.getKey()).append(" - ").append(p.getValue()).append("\n"));

        return result.toString().trim();


    }

}