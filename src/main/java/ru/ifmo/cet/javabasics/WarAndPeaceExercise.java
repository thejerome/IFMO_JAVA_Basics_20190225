package ru.ifmo.cet.javabasics;

import com.google.common.base.Charsets;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException{
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
        //final Path testPath = Paths.get("src", "main", "resources", "test.txt");

        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO If word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order if needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10
        List<String> listtome12 = Files.readAllLines(tome12Path, Charset.forName("windows-1251"));
        List<String> listtome34 = Files.readAllLines(tome34Path, Charset.forName("windows-1251"));
        listtome12.addAll(listtome34);

        HashMap<String, Integer> calcWord = new HashMap<>();

        for(String i : listtome12){
            i = i.toLowerCase().replaceAll("[^а-яa-z]", " ");
            int right = 0, left = -1;
            while (right != -1){
                right = i.indexOf(' ', left + 1);
                if (right != -1){
                    String word = i.substring(left + 1, right);
                    if (word.length() >= 4) {
                        Integer frequence = calcWord.get(word);
                        calcWord.put(word, (frequence == null) ? 1 : frequence + 1);
                    }
                }else{
                    String word = i.substring(left + 1);
                    if (word.length() >= 4) {
                        Integer frequence = calcWord.get(word);
                        calcWord.put(word, (frequence == null) ? 1 : frequence + 1);
                    }
                }
                left = right;
            }
        }

        ArrayList<String> beforeans = new ArrayList<>();
        for(Map.Entry<String, Integer> item : calcWord.entrySet()){
            if (item.getValue() >= 10) {
                beforeans.add(item.getKey() + " " + item.getValue());
            }
        }
        //Collections.sort(beforeans, new Sortbyvalue() );
        Collections.sort(beforeans);
        beforeans.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int valuea = Integer.parseInt(a.substring(a.indexOf(' ') + 1));
                int valueb = Integer.parseInt(b.substring(b.indexOf(' ') + 1));
                return valueb - valuea;
            }
        });
        StringBuilder ans = new StringBuilder("");
        for(int i = 0; i < beforeans.size(); i++){
            int space = beforeans.get(i).indexOf(' ');
            ans.append(beforeans.get(i).substring(0, space));
            ans.append(" - ");
            ans.append(beforeans.get(i).substring(space + 1, beforeans.get(i).length()));
            if(i != beforeans.size() - 1) ans.append('\n');
        }
        return ans.toString();
    }

}