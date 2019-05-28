package ru.ifmo.cet.javabasics;

import java.nio.file.Files;
import java.io.*;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;



public class WarAndPeaceExercise {

    private static <TK,TV> String convertMapToString(Map<TK, TV> map){
        String temp = "";
        for (TK key : map.keySet()) {
            temp += key + " - " + map.get(key) + "\n";
        }
        return temp.substring(0, temp.length()-1);
    }

    private static boolean filterCheck(String filter, Integer value, Integer target){
        if (filter.contains("=") && value.equals(target)){
            return true;
        }

        if (filter.contains(">") && value > target){
            return true;
        }

        if (filter.contains("<") && value < target){
            return  true;
        }

        return false;
    }

    private static Map<String, Integer> mapFilterIntParam (Map<String, Integer> map, String filter, Integer targetValue){
        Map<String, Integer> temp = new HashMap<String,Integer>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (filterCheck(filter, value, targetValue)){
                temp.put(key, value);
            }
        }

        return  temp;
    }

    private static Map<String, Integer> sortMap(Map<String, Integer> unsortMap) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b){
                if(a.getValue().equals(b.getValue())) {
                    return a.getKey().compareTo(b.getKey());
                }

                return -(a.getValue()).compareTo(b.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static String warAndPeace() throws IOException  {
        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO If word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order if needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10

        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        List<String> readenData = Files.readAllLines(tome12Path, Charset.forName("windows-1251"));
        readenData.addAll(Files.readAllLines(tome34Path, Charset.forName("windows-1251")));

        Map<String, Integer> finalList = new HashMap<String,Integer>();

        for (String line : readenData){
            for (String word : line.toLowerCase().replaceAll("[^а-яa-z]", " ").split(" ")){
                if (word.length() > 3){
                    if (finalList.containsKey(word)){
                        finalList.put(word, finalList.get(word)+1);
                    }else{
                        finalList.put(word, 1);
                    }
                }
            }
        }

        return convertMapToString(sortMap(mapFilterIntParam(finalList, ">=", 10)));
    }
}