package ru.ifmo.cet.javabasics;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.*;


public class WarAndPeaceExercise {

    public static String warAndPeace() {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        Map<String, Integer> txtMap = new TreeMap();
        List<String> linetome12 = Files.readAllLines(tome12Path, Charset.forName("windows-1251"));
        List<String> linetome34 = Files.readAllLines(tome34Path, Charset.forName("windows-1251"));
        ArrayList<String> txtLines = new ArrayList<>();
        txtLines.addAll(linetome12);
        txtLines.addAll(linetome34);

        for(String i : txtLines){
            String lines = i.toLowerCase().replaceAll("[^а-яa-z]", " ");
            for(String txtWord : lines.split(" ")){
                if(txtWord.length()>=4){
                    if(txtMap.containsKey(txtWord)) txtMap.put(txtWord,txtMap.get(txtWord)+1);
                    else txtMap.put(txtWord,1);
                }
            }
        }
        return wordsSort(txtMap);
    }
    public static String wordsSort(Map<String,Integer> txtMap){
        List<Map.Entry<String,Integer>> words = new ArrayList<Map.Entry<String, Integer>>(txtMap.entrySet());
        Collections.sort(words,new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2){
                if(o1.getValue().equals(o2.getValue())) return o1.getKey().compareTo(o2.getKey());
                else return -(o1.getValue()).compareTo(o2.getValue());
            }
        });
        String result = "";
        for(Map.Entry<String,Integer> k : words){
            if(k.getValue()>=10) result += k.getKey()+" - "+k.getValue()+"\n";
        }
        return result.trim();
    }
}