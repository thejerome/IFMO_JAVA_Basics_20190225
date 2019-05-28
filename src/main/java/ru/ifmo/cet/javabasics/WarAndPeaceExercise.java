package ru.ifmo.cet.javabasics;

import java.nio.file.Path;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;


public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException{
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
        final Charset charset = Charset.forName("windows-1251");

        HashMap<String, Integer> dictionary = new HashMap<>();
        ArrayList<String> text;
        text = (ArrayList<String>) Files.readAllLines(tome12Path,charset);
        text.addAll(Files.readAllLines(tome34Path,charset));
        String str = text.toString();
        str = str.replaceAll("[^a-zA-Zа-яА-Я]", " ");
        Arrays.stream(str.split(" "))
                .map(String::toLowerCase)
                .filter(s->s.length()>3)
                .forEach(s->{dictionary.put(s, dictionary.getOrDefault(s, 0) + 1);});




        List <Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>();
        dictionary.entrySet().stream().filter(pair -> pair.getValue() >= 10).forEach(list::add);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b){
                int result=-a.getValue() + b.getValue();
                return result==0? -b.getKey().compareTo(a.getKey()):-a.getValue() + b.getValue();
            }
        });

        StringBuilder b = new StringBuilder();

        list.forEach(s-> b.append((String) s.getKey()).append(" - ").append(s.getValue()).append("\n"));


        b.deleteCharAt(b.length()-1);
        return b.toString();
    }
    public static void main (String[] args) throws IOException{

        System.out.print(warAndPeace());
    }
}