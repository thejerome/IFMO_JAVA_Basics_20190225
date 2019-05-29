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
        StringBuilder result = new StringBuilder();

        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO Iff word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order iff needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10

        Stream<String> wap = Stream.concat(Files.lines(tome12Path, Charset.forName("windows-1251")),
                                            Files.lines(tome34Path, Charset.forName("windows-1251")));

        wap.map(s -> s.toLowerCase())

                .map((s) -> s.replaceAll("[^а-яa-z]", " "))

                .flatMap(s -> Arrays.stream(s.split(" ")))

                .filter(s -> s.length() >= 4)

                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))

                .entrySet()

                .stream()

                .filter(entry -> entry.getValue() >= 10)

                .sorted(Comparator.<Map.Entry<String, Long>, Long>comparing(entry -> entry.getValue()).reversed().thenComparing(entry -> entry.getKey()))

                .forEach((a) -> result.append(a.getKey() + " - " + a.getValue() + '\n'));

        return result.substring(0,result.length()-1).toString();
    }

}