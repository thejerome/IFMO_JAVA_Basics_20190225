package ru.ifmo.cet.javabasics;

import sun.reflect.generics.tree.Tree;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WarAndPeaceExercise {
    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K k1, K k2) {
                return map.get(k2).compareTo(map.get(k1));
            }
        };
        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
        StringBuilder result = new StringBuilder("");
        ArrayList<String> list = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();

        List<String> volumes12 = Files.readAllLines(tome12Path.toAbsolutePath(), Charset.forName("windows-1251"));
        List<String> volumes34 = Files.readAllLines(tome34Path.toAbsolutePath(), Charset.forName("windows-1251"));

        list.addAll(getList(volumes12));
        list.addAll(getList(volumes34));

        Iterator<String> it = list.iterator();

        while(it.hasNext()){
            String str = it.next();
            if (str.length() >= 4){
                int count = 1;
                if (map.containsKey(str)) {
                    count = map.get(str) + 1;
                }
                map.put(str, count);
            }
        }

        List<String> list_sort = new ArrayList<>();
        Iterator<String> itMap = map.keySet().iterator();
        while (itMap.hasNext()) {
            String str = itMap.next();
            if (map.get(str)>= 10) {
                list_sort.add(str+ " - " + map.get(str) );
            }
        }



        list_sort.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer tmp1 = Integer.parseInt(o1.substring(o1.lastIndexOf(" ") + 1));
                Integer tmp2 = Integer.parseInt(o2.substring(o2.lastIndexOf(" ") + 1));
                if (tmp1.compareTo(tmp2) > 0) {
                    return -1;
                } else if (tmp1.compareTo(tmp2) < 0) {
                    return 1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        for (int i = 0; i < list_sort.size(); i++){
            result.append(list_sort.get(i) + '\n');
        }
        return result.toString().substring(0, result.length()-1);


        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO If word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order if needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10

        // throw new UnsupportedOperationException();
    }

    public static ArrayList getList(List<String> line){



        ArrayList<String> list = new ArrayList<>();

            String[] str = correctLine(line.toString()).split(" ");
            for (int j = 0; j < str.length; j++) {
                if (str[j].length() >= 4) {
                    list.add(str[j]);
                }
            }

        return list;

    }
    public static String correctLine(String line){
        line = line.toLowerCase().replaceAll("[^а-яa-z]", " ");
        return line;
    }




}