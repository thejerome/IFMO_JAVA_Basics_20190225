package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static java.nio.file.Files.readAllLines;


public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException
    {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        List<String> S = new ArrayList<>();
        Map<String, Integer> mp = new HashMap<>();
        List<List<String>> WaPList = new ArrayList<>();
        WaPList.add(readAllLines(tome12Path, Charset.forName("windows-1251")));
        WaPList.add(readAllLines(tome34Path, Charset.forName("windows-1251")));
        WaPList.forEach(tomes -> tomes.forEach(lines -> Arrays.stream(lines.split("[\\s,.[0-9]«»()?!\\]\\[;:'\\“\"…„]+")).filter(x -> x.length() >= 4).map(String::toLowerCase).forEach(word -> {
            Integer integer = (mp.keySet().contains(word)) ? mp.put(word, mp.get(word) + 1) : mp.put(word, 1);
        })));

        List<Map.Entry<String, Integer>> list = new ArrayList<>(mp.entrySet());
        SortedSet<KeyValuePair> sortedSet = new TreeSet<KeyValuePair>();
        list.stream().filter(sort -> sort.getValue() >= 10).forEach(item -> {
            sortedSet.add(new KeyValuePair(item.getValue(),item.getKey()));
        });
        StringBuilder builder = new StringBuilder();
        sortedSet.forEach(item -> {
            builder.append(item.toString());
        });
        return builder.substring(0, builder.length()-1);
    }

}

class KeyValuePair implements Comparable<KeyValuePair> {
    private String key;
    private long value;

    KeyValuePair(long value, String key) {
        super();
        this.key = key;
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return key + " - " + value + "\n";
    }

    @Override
    public int compareTo(KeyValuePair o) {
        return value != o.value ? (int) (o.value - value) : key.compareTo(o.key);
    }
}