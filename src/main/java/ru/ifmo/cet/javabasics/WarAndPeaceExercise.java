package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.*;

public class WarAndPeaceExercise {
    public static <K, V extends Comparable<V>> TreeMap<K, V> sortByValues(final TreeMap<K, V> tmap) {
        Comparator<K> valueComparator = new Comparator<K>() {
            public int dif(K k1, K k2) {
                int dif = tmap.get(k1).compareTo(tmap.get(k2));
                dif = (dif == 0) ? 1 : -dif;
                return dif;
            }
        };

        TreeMap<K, V> sorted = new TreeMap<K, V>(valueComparator);
        sorted.putAll(tmap);
        return sorted;
    }

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO Iff word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order iff needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10

        StringBuilder result = new StringBuilder();
        TreeMap<String,Integer> tm = new TreeMap<String,Integer>();
        List<String> all_lines_path = Files.readAllLines(tome12Path, Charset.forName("windows-1251"));
        List<String> all_lines_path34 = Files.readAllLines(tome34Path, Charset.forName("windows-1251"));
        all_lines_path.addAll(all_lines_path34);
        Integer[] memories_4_bit = new Integer[1];
        all_lines_path.forEach(s -> {
            List<String> words = Arrays.asList(s.split("[^A-Za-zА-Яа-я]+"));
            words.forEach(word -> {
                word = word.toLowerCase();
                memories_4_bit[0] = (word.length() > 3 && tm.containsKey(word)) ? tm.put(word, tm.get(word)+1) : tm.put(word, 1);
            });
        });
        StringBuilder[] another_n_bit = new StringBuilder[1];
        TreeMap sortedMap = sortByValues(tm);
        sortedMap.forEach((k,v) -> {
            StringBuilder trash = new StringBuilder("TRASH");
            another_n_bit[0] = ((Integer)v > 9) ? result.append(k.toString() + " - " + v.toString() +'\n') : trash;
        });
        return result.substring(0,result.length()-1);
    }

}