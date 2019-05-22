package ru.ifmo.cet.javabasics;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import java.io.*;


public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");


        HashMap<String, Integer> dict = new HashMap<>();

        List<String> tome12List = Files.readAllLines(tome12Path, Charset.forName("windows-1251"));
        List<String> tome34List = Files.readAllLines(tome34Path, Charset.forName("windows-1251"));
        tome12List.addAll(tome34List); //весь текст в tome12

        for (String str : tome12List) {
            str = str.toLowerCase().replaceAll("[^a-zа-я]", " ");
            String[] words = str.split(" ");
            for (String word : words) {
                if (word.length() >= 4) {
                    dict.put(word, dict.get(word) == null ? 1 : dict.get(word) + 1);
                }
            }

        }

        ArrayList<String> dictlist = new ArrayList<>();

        for(Map.Entry<String, Integer> i : dict.entrySet()) {
            if (i.getValue() >= 10)
                dictlist.add(i.getKey() + " - " + i.getValue());
        } //ответ без сортировки


        Collections.sort(dictlist);
        dictlist.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int value1 = Integer.parseInt(o1.substring(o1.lastIndexOf(" ") + 1));
                int value2 = Integer.parseInt(o2.substring(o2.lastIndexOf(" ") + 1));
                return value2 - value1;
            }
        });

        StringBuilder answer = new StringBuilder(""); //пустая строка

        for (int i = 0; i < dictlist.size(); i++){
            answer.append(dictlist.get(i));
            if(i != dictlist.size() - 1) {
                answer.append('\n');
            }
        }
        return answer.toString();
    }
}