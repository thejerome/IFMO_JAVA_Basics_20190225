package ru.ifmo.cet.javabasics;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;



    class WarAndPeaceExercise {
        private Map<String, Integer> result = new HashMap<>();

        public static String warAndPeace() {
            final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
            final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

            // TODO map lowercased words to its amount in text and concatenate its entries.
            // TODO Iff word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
            // TODO Entries in final String should be also sorted by amount and then in alphabetical order iff needed.
            // TODO Also omit any word with lengths less than 4 and frequency less than 10

            WarAndPeaceExercise exercise = new WarAndPeaceExercise();
            exercise.readTheFile(tome12Path);
            exercise.readTheFile(tome34Path);
            return exercise.getResult();
        }

        private String getResult() {
            StringBuilder result = new StringBuilder();
            this.sortByValue(this.result);
            this.result.entrySet().stream()
                    .filter(o1 -> o1.getValue() >= 10)
                    .forEach(o1 -> result.append(o1.getKey())
                            .append(" - ")
                            .append(o1.getValue())
                            .append("\n"));
            result.deleteCharAt(result.lastIndexOf("\n"));
            return result.toString();
        }


        private void sortByValue(Map<String, Integer> mapToSort) {
            this.result = mapToSort.entrySet().stream()
                    .sorted((o1, o2) ->
                            o1.getValue().compareTo(o2.getValue()) == 0 ?
                                    o1.getKey().compareTo(o2.getKey()) : -(o1.getValue()).compareTo(o2.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o1, LinkedHashMap::new));
        }

        private void readTheFile(Path fileToRead) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(
                            new File(String.valueOf(fileToRead))), Charset.forName("windows-1251"))
            )) {
                reader.lines().flatMap(word ->
                        Arrays.stream(word.split("[^a-zA-Zа-яА-Я]"))
                                .map(String::toLowerCase)
                                .filter(str -> str.length() >= 4))
                        .forEach(string -> this.result.put(string, this.result.get(string) == null ?
                                1 : this.result.get(string) + 1));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }