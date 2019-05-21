package ru.ifmo.cet.javabasics;


import java.io.*;
import java.util.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WarAndPeaceExercise
{
    public static String warAndPeace() throws IOException
    {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");

        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        List<String> listtome12 = Files.readAllLines(tome12Path, Charset.forName("windows-1251"));

        List<String> listtome34 = Files.readAllLines(tome34Path, Charset.forName("windows-1251"));

        listtome12.addAll(listtome34);

        HashMap<String, Integer> calcWord = new HashMap<>();

        for(String n : listtome12)
        {
            n = n.toLowerCase().replaceAll("[^а-яa-z]", " ");

            int lft=-1;
            int rgt=0;

            while (rgt!=-1)
            {
                rgt = n.indexOf(' ', lft+1);

                if (rgt!=-1)
                {
                    String word = n.substring(lft+1, rgt);
                    if (word.length()>=4)
                    {
                        Integer frequence = calcWord.get(word);
                        calcWord.put(word, (frequence == null)?1 : frequence+1);
                    }

                }

                else
                    {
                    String word = n.substring(lft+1);

                    if (word.length()>=4)
                    {
                        Integer frequence = calcWord.get(word);
                        calcWord.put(word, (frequence == null)?1 : frequence+1);
                    }
                    }
                lft = rgt;
            }
        }

        ArrayList<String> beforeans = new ArrayList<>();

        for(Map.Entry<String, Integer> item : calcWord.entrySet())
        {
            if (item.getValue()>=10)
            {
                beforeans.add(item.getKey()+ " " +item.getValue());
            }
        }

        Collections.sort(beforeans);
        beforeans.sort(new Comparator<String>()
        {
            @Override
            public int compare(String one, String two)
            {
                int j = Integer.parseInt(two.substring(two.indexOf(' ')+1));
                int i = Integer.parseInt(one.substring(one.indexOf(' ')+1));

                return j - i;
            }
        }
        );

        StringBuilder otv = new StringBuilder("");

        for (int m =0; m <beforeans.size(); m++)
        {
            int prs = beforeans.get(m).indexOf(' ');

            otv.append(beforeans.get(m).substring(0, prs));
            otv.append(" - ");
            otv.append(beforeans.get(m).substring(prs+1, beforeans.get(m).length()));
            if(m != beforeans.size()-1) otv.append('\n');
        }

        return otv.toString();
    }

}