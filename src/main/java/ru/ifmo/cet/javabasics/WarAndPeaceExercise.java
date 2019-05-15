package ru.ifmo.cet.javabasics;

import javax.crypto.Mac;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.Files.readAllLines;

public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");


        Map<String, Integer> mp = new HashMap<>();
        List<List<String>> WaPList = new ArrayList<>();
        WaPList.add(readAllLines(tome12Path, Charset.forName("windows-1251")));
        WaPList.add(readAllLines(tome34Path, Charset.forName("windows-1251")));
        for(List<String> In : WaPList) {
            for (String line : In) {
                for (String word : line.split("[\\s,.[0-9]«»()?!\\]\\[;:'\\“\"…„]+")) {
                    word = word.toLowerCase();
                    if (word.length() >= 4) {
                        if (mp.keySet().contains(word)) {
                            mp.put(word, mp.get(word) + 1);
                            // Если нет, то кладем ключ и присваиваем значение 1
                        } else {
                            mp.put(word, 1);
                        }
                    }
                }
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(mp.entrySet());
        SortedSet<KeyValuePair> sortedSet = new TreeSet<KeyValuePair>();
        for(Map.Entry<String, Integer> item : list)
        {
            sortedSet.add(new KeyValuePair(item.getValue(),item.getKey()));
        }

        StringBuilder builder = new StringBuilder();
        for(KeyValuePair p : sortedSet)
        {
            if(p.getValue() >= 10) builder.append(p.toString());
        }
        return builder.substring(0,builder.length()-1);
        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO If word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order if needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10

        //throw new UnsupportedOperationException();
    }
}
class KeyValuePair implements Comparable<KeyValuePair>{
    private String key;
    private int value;

    KeyValuePair(int value, String key) {
        super();
        this.key = key;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString()
    {
        return key + " - " + value + "\n";
    }

    @Override
    public int compareTo(KeyValuePair o) {
        if(value != o.value)
        {
            return o.value - value;
        }
        else
        {
            return key.compareTo(o.key);
        }
    }
}