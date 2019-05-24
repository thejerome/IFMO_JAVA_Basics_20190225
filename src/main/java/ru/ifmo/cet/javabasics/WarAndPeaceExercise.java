package ru.ifmo.cet.javabasics;

import java.nio.file.Path;
import java.nio.file.Paths;


public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException
    {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
        Map<String, Integer> mp = new HashMap<>();
        List<List<String>> WaP = new ArrayList<>();
        Integer[] a = new Integer[1];
        WaP.add(readAllLines(tome12Path, Charset.forName("windows-1251")));
        WaP.add(readAllLines(tome34Path, Charset.forName("windows-1251")));
        WaP.forEach(tomes -> tomes.forEach(lines -> Arrays.stream(lines.split("[\\s,.[0-9]«»()?!\\]\\[;:'\\“\"…„]+")).filter(x -> x.length() >= 4).map(String::toLowerCase).forEach(word -> {
            a[0] = (mp.keySet().contains(word)) ? mp.put(word, mp.get(word) + 1) : mp.put(word, 1);
        })));
       a[0]++;
        List<Map.Entry<String, Integer>> list = new ArrayList<>(mp.entrySet());
        SortedSet<KeyValuePair> sortedSet = new TreeSet<KeyValuePair>();
        list.stream().filter(sort -> sort.getValue() >= 10).forEach(item -> {
            sortedSet.add(new KeyValuePair(item.getValue(),item.getKey()));
        });
        StringBuilder builder = new StringBuilder();
        sortedSet.forEach(item -> {
            builder.append(item.toString());
        });
        return builder.substring(0, builder.length()-1);
    }

}
