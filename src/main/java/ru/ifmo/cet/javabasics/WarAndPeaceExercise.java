package ru.ifmo.cet.javabasics;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.*;
import java.nio.charset.Charset;
import java.util.stream.Collectors;
import java.util.*;
import java.util.stream.Stream;
import java.util.function.Function;

public class WarAndPeaceExercise
{

    public static String warAndPeace() throws IOException
    {

        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");



        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO Iff word "котик" occurred in text 23 times then its entry would be "котик - 23\n".

        // TODO Entries in final String should be also sorted by amount and then in alphabetical order iff needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10


        Stream<String> strngTf = Files.lines(tome34Path.toAbsolutePath(), Charset.forName("windows-1251"));

        Stream<String> strngTwlv = Files.lines(tome12Path.toAbsolutePath(), Charset.forName("windows-1251"));

        Stream<String> strng = Stream.concat(strngTwlv,strngTf);


        StringBuilder Result = new StringBuilder();

        strng.map(String::toLowerCase).map(lines->lines.replaceAll("[^a-zа-я]"," "))

                .flatMap(lines -> Arrays.stream(lines.split(" ")))
                .filter(word -> word.length() > 3)

                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()

                .stream()
                .sorted((o1, o2) ->o1.getValue().equals(o2.getValue()) ? o1.getKey().compareTo(o2.getKey()) : -(o1.getValue()).compareTo(o2.getValue()))
                .filter(word-> word.getValue()>=10)

                .forEach(word->Result.append(word.getKey()).append(" - ").append(word.getValue()).append("\n"));


        return Result.toString().trim();
    }

}