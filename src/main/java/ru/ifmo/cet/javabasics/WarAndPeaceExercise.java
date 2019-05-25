package ru.ifmo.cet.javabasics;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class WarAndPeaceExercise {

    private static String text;
    private static Map<String, Integer> alphabetMap;
    private static String res;
    private static String result;


    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
        List<String> firstFile = Files.readAllLines(tome12Path, Charset.forName("windows-1251"));
        List<String> secondFile = Files.readAllLines(tome34Path, Charset.forName("windows-1251"));
        firstFile.addAll(secondFile);
        text = "";
        alphabetMap = new TreeMap<>();
        res = "";


        for (String s : firstFile) {
            text = s.toLowerCase().replaceAll("[^a-zа-я]", " ");
            for (String splited : text.split(" ")) {
                if (3 < splited.length()) {
                    if (alphabetMap.containsKey(splited)) {
                        alphabetMap.put(splited, alphabetMap.get(splited) + 1);
                    } else {
                        alphabetMap.put(splited, 1);
                    }
                }
            }
        }

        for (String re : alphabetMap.toString().trim().replaceAll("[{}1234567890,=]", "").split(" ")) {
            if (alphabetMap.get(re) < 10) {
                alphabetMap.remove(re);
            }
        }
        alphabetMap = sortByValue(alphabetMap);
        res = alphabetMap.toString().trim().replaceAll("[{}]", "");
        res = res.replace("=", " - ");
        result = "";
        for (String slova : res.trim().split(", ")) {
            result += slova + "\n";
        }
        result = result.trim();

        return result;
    }


    public static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list =
                new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }

        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

}