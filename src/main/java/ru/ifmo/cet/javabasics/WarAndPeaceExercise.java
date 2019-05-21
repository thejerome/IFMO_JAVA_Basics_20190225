package ru.ifmo.cet.javabasics;

import com.google.common.base.Charsets;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class WarAndPeaceExercise {

    private static void calcwords(List<String> listtome, HashMap<String, Integer> calcWord){
        for(int i = 0; i < listtome.size(); i++){
            int right = 0, left = -1;
            while (right != -1) {
                right = listtome.get(i).indexOf(' ', left + 1);
                String word;
                if (right != -1) {
                    word = listtome.get(i).substring(left + 1, right);
                }else{
                    word = listtome.get(i).substring(left + 1, listtome.get(i).length() - 1);
                }
                if (word.length() >= 4) {
                    //проверка если последний символ '.' ',' '!' '?'
                    if (word.charAt(word.length() - 1) == ',' ||
                            word.charAt(word.length() - 1) == '.' ||
                            word.charAt(word.length() - 1) == '!' ||
                            word.charAt(word.length() - 1) == '?') {
                        word = word.substring(0, word.length() - 2);
                    }
                    Integer frequency = calcWord.get(word);
                    calcWord.put(word, frequency == null ? 1 : frequency + 1);
                    left = right;
                }
            }
        }
    }

    public static String warAndPeace() throws IOException{
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO If word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order if needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10
        List<String> listtome12 = Files.readAllLines(tome12Path, Charset.forName("windows-1252"));
        List<String> listtome34 = Files.readAllLines(tome34Path, Charset.forName("windows-1252"));
        HashMap<String, Integer> calcWord = new HashMap<String, Integer>();
        calcwords(listtome12, calcWord);
        calcwords(listtome34, calcWord);
        ArrayList<String> beforeans = new ArrayList<String>();
        for(Map.Entry<String, Integer> item : calcWord.entrySet()){
            if (item.getValue() > 10) {
                beforeans.add(item.getValue().toString() + ' ' + item.getKey());
            }
        }
        Collections.sort(beforeans);
        StringBuilder ans = new StringBuilder("");
        for(int i = 0; i < beforeans.size(); i++){
            int space = beforeans.get(i).indexOf(' ');
            ans.append(beforeans.get(i).substring(space + 1, beforeans.size()));
            ans.append(" - ");
            ans.append(beforeans.get(i).substring(0, space));
            ans.append('\n');
        }
        return ans.toString();
    }

}