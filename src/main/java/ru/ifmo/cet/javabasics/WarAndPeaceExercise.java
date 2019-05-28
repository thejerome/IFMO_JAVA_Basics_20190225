package ru.ifmo.cet.javabasics;

import java.util.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class WarAndPeaceExercise {

    public static Map<String, Integer> words = new HashMap<>();

    private static void find(Path path) throws IOException {
        String str;
        str = Files.readAllLines(path, Charset.forName("windows-1251")).toString();
        str = str.toLowerCase();
        str = str.replaceAll("[^а-яa-z]"," ");
        Stream<String > streamWords = Stream.of(str.split(" "));
        streamWords.filter(os -> os.length() > 3).forEach((String os) -> {
            int value = words.getOrDefault(os,0) + 1;
            words.put(os,value);
        });
    }

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        find(tome12Path);
        find(tome34Path);

        ArrayList<Map.Entry<String,Integer>> sortMap = new ArrayList<>(words.entrySet());

        sortMap.sort((o1, o2) ->
                (o1.getValue().equals(o2.getValue())) ? (o1.getKey().compareTo(o2.getKey())) : (o2.getValue().compareTo(o1.getValue())));

        return sortMap.stream().filter(len -> len.getValue() >= 10).map(get -> get.getKey() + " - " + get.getValue()).collect(Collectors.joining("\n"));
    }
}