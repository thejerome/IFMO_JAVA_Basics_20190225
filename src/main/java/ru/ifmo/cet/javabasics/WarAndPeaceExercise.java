package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WarAndPeaceExercise {

    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K k1, K k2) {
                int compare = map.get(k1).compareTo(map.get(k2));
                if (compare == 0) return 1;
                else return -compare;
            }
        };

        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        StringBuilder result = new StringBuilder();
        TreeMap<String,Integer> tm = new TreeMap<String,Integer>();
        List<String> all_lines_path = Files.readAllLines(tome12Path, Charset.forName("windows-1251"));
        List<String> all_lines_path34 = Files.readAllLines(tome34Path, Charset.forName("windows-1251"));
        all_lines_path.addAll(all_lines_path34);
        for(String s : all_lines_path) {
            Scanner fromStr = new Scanner(s);
            fromStr.useDelimiter("[^A-Za-zА-Яа-я]+");
            while (fromStr.hasNext()) {
                String Str = fromStr.next();
                Str = Str.toLowerCase();
                if (Str.length() >= 4) {
                    if (tm.containsKey(Str)) tm.put(Str, tm.get(Str)+1);
                    else tm.put(Str, 1);
                }
            }
        }
        Map sortedMap = sortByValues(tm);
        Set set = sortedMap.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()) {
            Map.Entry<String,Integer> me = (Map.Entry<String,Integer>)i.next();
            if (me.getValue() >= 10) result.append(me.getKey() + " - " + Integer.toString(me.getValue())+'\n');
        }
        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO If word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order if needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10
        return result.substring(0,result.length()-1);
    }

}