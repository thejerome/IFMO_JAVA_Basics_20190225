package ru.ifmo.cet.javabasics;

        import java.io.IOException;
        import java.nio.charset.Charset;
        import java.nio.file.Path;
        import java.nio.file.Paths;
        import java.util.*;
        import static java.nio.file.Files.readAllLines;

public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {
        
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
        List<String> TextLines = readAllLines(tome12Path, Charset.forName("windows-1251"));
        TextLines.addAll(readAllLines(tome34Path, Charset.forName("windows-1251")));

        
        Map<String, Integer> Voc = new HashMap<>();
        TextLines.forEach(Line -> Arrays.stream(Line.split("[\\s,.[0-9]«»()?!\\]\\[;:'\\“\"…„]+")).
                filter(x -> x.length() >= 4).map(String::toLowerCase).forEach(Word ->
        { Voc.put(Word, 1 + ((Voc.keySet().contains(Word)) ? Voc.get(Word) : 0)); }));

        
        List<Map.Entry<String, Integer>> WordFreq = new ArrayList<>(Voc.entrySet());
        WordFreq.sort(Map.Entry.comparingByKey());
        WordFreq.sort(Map.Entry.comparingByValue((x, y) -> y - x));
        WordFreq.removeIf((x) -> x.getValue() < 10);
        
        StringBuilder builder = new StringBuilder();
        WordFreq.forEach(p -> builder.append(p.getKey() + " - " + p.getValue() + "\n"));

        return (builder.length() > 0) ? builder.substring(0, builder.length() - 1) : "";
    }
}
