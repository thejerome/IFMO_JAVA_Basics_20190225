package ru.ifmo.cet.javabasics;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;


public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        List<String> rows;

        rows = Files.readAllLines(tome12Path, Charset.forName("windows-1251"));
        rows.addAll(Files.readAllLines(tome34Path, Charset.forName("windows-1251")));

        //приводим все символы к строчным
        //выбираем все не строчные ([^a-zа-я]+) символы и и делаем по ним split.
        String[] words = Arrays.toString(rows.toArray()).toLowerCase().split("[^a-zа-я]+");

        Map<String, Integer> wordsMap = new HashMap<>();

        //пробегаемся по массиву words
        //считаем количество повторений
        //кладём пары (слово, повторения) в wordsMap
        for (String word : words) {
            if (word.length() >= 4) {
                wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
            }
        }

        //сортируем получившийся wordsMap c помощью TreeSet
        SortedSet<Map.Entry<String, Integer>> sorted = new TreeSet<>(

                //и поскольку лямбда выражения писать нельзя, напишем компаратор
                new Comparator<Map.Entry<String, Integer>>() {
                    public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {

                        if (a.getValue().equals(b.getValue())) {
                            return a.getKey().compareTo(b.getKey());
                        }
                        else {
                            return b.getValue() - a.getValue();
                        }
                    }
                }
        );

        //добавляем все элементы wordsMap в созданный set
        sorted.addAll(wordsMap.entrySet());


        StringBuilder result = new StringBuilder();

        //записываем получившийся sorted в строку.
        for (Map.Entry<String, Integer> entry : sorted) {
            //но только, если количество повторений не меньше 10
            if (entry.getValue() >= 10) {
                result.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
            }
        }
        //удаляем последний перенос строки и возвращаем результат.
        return result.deleteCharAt(result.length()-1).toString();
    }
}