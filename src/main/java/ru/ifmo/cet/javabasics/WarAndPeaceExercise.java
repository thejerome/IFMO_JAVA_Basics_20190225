package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.Files.readAllLines;

public class WarAndPeaceExercise {

public static String warAndPeace() throws IOException {
List<String> WaPList = new ArrayList<>();
WaPList.addAll(readAllLines(Paths.get("src", "main", "resources", "WAP12.txt"), Charset.forName("windows-1251")));
WaPList.addAll(readAllLines(Paths.get("src", "main", "resources", "WAP34.txt"), Charset.forName("windows-1251")));
Map<String, Integer> mp = new HashMap<>();
for (String line : WaPList) {
for (String word : line.split("[\\s,.[0-9]«»()?!\\]\\[;:'\\“\"…„]+")) {
word = word.toLowerCase();
if (word.length() >= 4) {
if (mp.keySet().contains(word))
mp.put(word, mp.get(word) + 1);
else
mp.put(word, 1);

}
}
}
List<Map.Entry<String, Integer» list = new ArrayList<>(mp.entrySet());
SortedSet<KeyValuePair> sortedSet = new TreeSet<KeyValuePair>();
for(Map.Entry<String, Integer> item : list)
sortedSet.add(new KeyValuePair(item.getValue(),item.getKey()));

StringBuilder builder = new StringBuilder();
for(KeyValuePair p : sortedSet)
if(p.getValue() >= 10) builder.append(p.toString());
System.out.println(builder.toString());
return builder.substring(0,builder.length()-1);
}
}
class KeyValuePair implements Comparable<KeyValuePair>{
private String key;
private int value;

KeyValuePair(int value, String key) {
super();
this.key = key;
this.value = value;
}

public int getValue() {
return value;
}

@Override
public String toString()
{
return key + " - " + value + "\n";
}

@Override
public int compareTo(KeyValuePair o) {
if(value != o.value)
{
return o.value - value;
}
else
{
return key.compareTo(o.key);
}
}
}
