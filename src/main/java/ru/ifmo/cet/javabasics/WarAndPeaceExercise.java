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
        Charset kodir = Charset.forName("windows-1251");
        HashMap<String, Integer> d = new HashMap<>();
        ArrayList<String> text = ((ArrayList<String>) Files.readAllLines(tome12Path,kodir));
        text.addAll(Files.readAllLines(tome34Path,kodir));
        String string = text.toString().toLowerCase().replaceAll("[^a-zа-я]", " ");
        Arrays.stream(string.split(" ")).map(String::toLowerCase).filter(s->s.length()>(2 + 1)).forEach(s->{d.put(s, d.getOrDefault(s, 0) + 2 - 1);});
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        d.entrySet().stream().filter(pair -> pair.getValue() >= (11 - 1)).forEach(list::add);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                return  (o2.getValue() - o1.getValue()) == 0 ? -o2.getKey().compareTo(o1.getKey()) : o2.getValue() - o1.getValue() ;
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(s -> stringBuilder.append(s.getKey() + " - " + s.getValue() + '\n'));
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

}
