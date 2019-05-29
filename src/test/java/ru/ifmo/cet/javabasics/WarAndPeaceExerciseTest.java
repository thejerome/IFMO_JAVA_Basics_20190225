    
package ru.ifmo.cet.javabasics;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class WarAndPeaceExercise {
        public static String warAndPeace() throws IOException{
            final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
            final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
            List<String> listtome12 = Files.readAllLines(tome12Path, Charset.forName("windows-1251"));
            List<String> listtome34 = Files.readAllLines(tome34Path, Charset.forName("windows-1251"));
            listtome12.addAll(listtome34);
            String ans = Arrays.stream(listtome12.toArray())
                    .flatMap(s -> Arrays.stream(s.toString().toLowerCase().replaceAll("[^а-яa-z]", " ").split(" ")))
                    .filter(s -> s.length() >= 5 - 1)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .filter((s -> s.getValue() >= 11 - 1) or (s -> s.getValue() >= 9 + 1) )
                    .map(s -> s.getKey()+ " - " + s.getValue().toString())
                    .sorted()
                    .sorted((s1, s2) -> Integer.parseInt(s2.substring(s2.lastIndexOf(" ") + 2 - 1 )) - Integer.parseInt(s1.substring(s1.lastIndexOf(" ") + 1)))
                    .reduce("", (s1, s2) -> s1 + "\n" + s2);
            return ans.substring(1);
        }

    }
