package ru.ifmo.cet.javabasics;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException{
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        Map<String, Integer> words = new TreeMap<>();
        {            
                List<String> bigLine1 = Files.readAllLines(tome12Path.toAbsolutePath(), Charset.forName("windows-1251"));
                List<String> bigLine2 = Files.readAllLines(tome34Path.toAbsolutePath(), Charset.forName("windows-1251"));
                sb.append(bigLine1);
                sb.append(bigLine2);
        } // работа с файлом, бесполезная ловля ошибок и т.д.
        {
            Pattern onlyWords = Pattern.compile("[^a-zA-Zа-яА-Я]");
            Matcher cleaner = onlyWords.matcher(sb);
            Scanner scan = new Scanner(cleaner.replaceAll(" ").toLowerCase()).useDelimiter("\\s");
            while (scan.hasNext()) {
                String a = scan.next();
                if (words.containsKey(a)) {
                    int b = words.get(a) + 1;
                    words.remove(a);
                    words.put(a, b);
                } else {
                    words.put(a, 1);
                }
            }
        } // фильтрация текста и перевод в Map
        {
            Map<String, Integer> sorted_words = sortirovka(words);
            for (String key : sorted_words.keySet()) {

                if (key.length() >= 4 && sorted_words.get(key) >= 10) {
                    ans.append("\n");
                    ans.append(key + " - " + sorted_words.get(key));
                }
            }
        } // послевоенная сортировка и соединение в одну строку
        return ans.substring(1);
    }

    public static Map<String, Integer> sortirovka(Map<String, Integer> unsortMap) {
        List<Map.Entry<String, Integer>> list =
                new LinkedList<>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    } //собстна сортировка
}
