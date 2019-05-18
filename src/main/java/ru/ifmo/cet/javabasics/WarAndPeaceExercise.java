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

        List<String> lines12 = Files.readAllLines(tome12Path.toAbsolutePath(), Charset.forName("windows-1251"));
        List<String> lines34 = Files.readAllLines(tome34Path.toAbsolutePath(), Charset.forName("windows-1251"));
        ArrayList<String> allLines = new ArrayList<>();
        allLines.addAll(lines12);
        allLines.addAll(lines34);

        Start start = new Start();

        HashMap<String, Integer> map = new HashMap<>();

        map = start.installMap(allLines, map);

        ArrayList<MyClass> temp = new ArrayList<>();

        Set words = map.keySet();
        //System.out.println(map.entrySet());

        temp = start.install_and_sort(words, temp, map);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < temp.size(); i++) {
            result.append(temp.get(i).getWord());
            result.append(" - ");
            result.append(temp.get(i).getFrequence());
            if (i != temp.size() - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }
}