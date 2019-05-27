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
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        StringBuilder res = new StringBuilder();
        Stream<String> strm = Stream.concat(Files.lines(tome12Path, Charset.forName("windows-1251")), Files.lines(tome34Path, Charset.forName("windows-1251")));

        strm.map(s -> s.toLowerCase())
                .flatMap(s -> Arrays.stream(s.split("[^а-яa-z]+")))
                .filter(s -> s.length() >= 4)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= 10)
                .sorted(Comparator.<Map.Entry<String, Long>, Long>comparing(entry -> entry.getValue()).reversed().thenComparing(entry -> entry.getKey()))
                .forEach((a) -> res.append(a.getKey()).append(" - ").append(a.getValue()).append('\n'));

        return res.substring(0,res.length()-1);
    }

}