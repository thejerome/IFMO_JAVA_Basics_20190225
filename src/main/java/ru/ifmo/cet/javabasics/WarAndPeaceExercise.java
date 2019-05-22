package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        List<String> tom12 = Files.readAllLines(tome12Path, Charset.forName("windows-1251"));
        List<String> tom34 = Files.readAllLines(tome34Path, Charset.forName("windows-1251"));
        ArrayList<String> lines = new ArrayList<>();
        lines.addAll(tom12);
        lines.addAll(tom34);

        Map<String, Integer> map = new TreeMap();

        for(String cur : lines){
            String llines = cur.toLowerCase().replaceAll("[^а-яa-z]", " ");
            for(String word : llines.split(" ")){
                if(word.length()>=4){
                    if(map.containsKey(word))
                        map.put(word,map.get(word)+1);
                    else
                        map.put(word,1);
                }
            }
        }

        return wordsSort(map);
    }

    public static String wordsSort(Map<String,Integer> map){

        List< Map.Entry<String,Integer> > ws = new ArrayList<>(map.entrySet());

        Collections.sort(ws, new Comparator< Map.Entry<String,Integer> >(){
            public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b){
                if(a.getValue().equals(b.getValue())) return a.getKey().compareTo(b.getKey());
                else return -(a.getValue()).compareTo(b.getValue());
            }
        });

        String res = "";

        for(Map.Entry<String,Integer> kk : ws){
            if(kk.getValue()>=10) res += kk.getKey()+" - "+kk.getValue()+"\n";
        }

        return res.trim();
    }

}