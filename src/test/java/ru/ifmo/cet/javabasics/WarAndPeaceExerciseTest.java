package ru.ifmo.cet.javabasics;
 
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
 
        List<String> linesList = new ArrayList<>();
        linesList.addAll(readAllLines(tome12Path, Charset.forName("windows-1251")));
        linesList.addAll(readAllLines(tome34Path, Charset.forName("windows-1251")));
        List<String> words = new ArrayList<>();
        for(String In : linesList) {
            String[] tmp = In.split("[\\s,.[0-9]«»()?!\\]\\[;:'\\“\"…„]+");
            words.addAll(Arrays.asList(tmp));
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            if (word.length() >= 4) {
                if (map.keySet().contains(word)) { map.put(word, map.get(word) + 1); }
                else { map.put(word, 1); }
            }
        }
        SortedSet<KeyValuePair> set = new TreeSet<>();
        for(Map.Entry<String, Integer> item : new ArrayList<>(map.entrySet())) {
            set.add(new KeyValuePair(item.getValue(),item.getKey()));
        }
 
        StringBuilder builder = new StringBuilder();
        for(KeyValuePair p : set) {
            if(p.getValue() >= 10) builder.append(p.toString());
        }
        return builder.substring(0,builder.length()-1);
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
