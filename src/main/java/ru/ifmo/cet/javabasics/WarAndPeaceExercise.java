package ru.ifmo.cet.javabasics;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;




public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException{
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
        List<String> volumes12 = Files.readAllLines(tome12Path.toAbsolutePath(), Charset.forName("windows-1251"));
        List<String> volumes34 = Files.readAllLines(tome34Path.toAbsolutePath(), Charset.forName("windows-1251"));
        volumes12.addAll(volumes34);

        Map<String, Integer> myWords = new HashMap<>();
        for (String line : volumes12){
            line = line.toLowerCase().replaceAll("[^а-яa-z]", " ");
            String[] allWords = line.split(" ");
            for (String word : allWords){
                if (word.length() >= 4){
                    if (myWords.containsKey(word)){
                        myWords.put(word, myWords.get(word) + 1);
                    }
                    else{
                        myWords.put(word, 1);
                    }
                }
            }
        }


        List <String> listWithWords = new ArrayList<>();
        Set<Map.Entry<String, Integer>> wordSet = myWords.entrySet();
        Iterator<Map.Entry<String, Integer>> iter = wordSet.iterator();
        while (iter.hasNext()){
            Map.Entry<String, Integer> tempMap = iter.next();
            if (tempMap.getValue() >= 10){
                String tmp = tempMap.getKey() + " - " + tempMap.getValue();
                listWithWords.add(tmp);
            }
        }
        listWithWords.sort(new Comparator<String>() {
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

        String frequences = "";

        for (int i = 0; i < listWithWords.size() - 1; i++) {
            frequences = frequences + (listWithWords.get(i) + "\n");
        }
        frequences = frequences + (listWithWords.get(listWithWords.size() - 1));
        return frequences;


    }
}
